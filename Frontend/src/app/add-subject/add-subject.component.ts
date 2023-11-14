import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../Service/api.service';

interface SectionData {
  name: string;
  des: string;
}

@Component({
  selector: 'app-add-subject',
  templateUrl: './add-subject.component.html',
  styleUrls: ['./add-subject.component.scss'],
})
export class AddSubjectComponent {
  successMessage: string | null = null;

  addSubjectForm: FormGroup;

  constructor(private apiService: ApiService, private formBuilder: FormBuilder) {
    this.addSubjectForm = this.formBuilder.group({
      name: ['', Validators.required],
      des: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.addSubjectForm.valid) {
      const formData: SectionData = this.addSubjectForm.value;
      this.apiService.addSubject(formData).subscribe(
        (response) => {
          console.log('API response:', response);
          this.successMessage = 'Subject added successfully!';
          // Reset the form after a successful API call
          this.addSubjectForm.reset();

          setTimeout(() => {
            this.clearSuccessMessage();
          }, 3000);
        },
        (error) => {
          console.error('API error:', error);
          // Handle error, e.g., show an error message
        }
      );
    } else {
      console.log('Form is invalid. Please check your input.');
      // Optionally, display an error message to the user
    }
  }

  clearSuccessMessage() {
    this.successMessage = null;
  }
}
