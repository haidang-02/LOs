import { Component } from '@angular/core';
import { ApiService } from '../Service/api.service';

interface SectionData {
  name: string;
  maxScore: number;
}


@Component({
  selector: 'app-max-scrore-cdr',
  templateUrl: './max-scrore-cdr.component.html',
  styleUrls: ['./max-scrore-cdr.component.scss']
})
export class MaxScroreCDRComponent {

  successMessage: string | null = null;

  subjects: any = []
  selectedSubject: number = 1;

  numSections: number = 2;
  sections: number[] = [];
  maxScores: number[] = [];
  formData: { sections: SectionData[] } = { sections: [] };

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.getSubject();
    this.updateSections();
  }

  onSubmit() {
    this.formData.sections.forEach((section: SectionData) => {
      this.apiService.setCDR(section).subscribe(
        (response) => {
          console.log('API response for section ' + section.name + ':', response);
          this.successMessage = 'Successfully!';
          setTimeout(() => {
            this.clearSuccessMessage();
          }, 3000);
        },
        (error) => {
          console.error('Error for section ' + section.name + ':', error);
        });
      console.log(section)
    });
  }

  updateSections() {
    this.sections = Array.from({ length: this.numSections }, (_, i) => i + 1);
    this.maxScores = Array(this.numSections).fill(0);
    this.formData.sections = Array.from({ length: this.numSections }, (_, i) => ({
      name: `Phần ${i + 1}`,
      maxScore: 0,
    })) as SectionData[];
  }

  getSubject() {
    this.apiService.getSubject().subscribe(
      (res) => {
        this.subjects = res;
        console.log(this.subjects)
      },
      (err) => {
        console.log(err);
      }
    );
  }

  clearSuccessMessage() {
    this.successMessage = null;
  }
}
