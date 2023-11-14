import { Component } from '@angular/core';
import { Student } from '../Service/student-service.service';
import { StudentServiceService } from '../Service/student-service.service';
import { ApiService } from '../Service/api.service'
import { Observable } from 'rxjs';
import * as XLSX from 'xlsx';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';




@Component({
  selector: 'app-point',
  templateUrl: './point.component.html',
  styleUrls: ['./point.component.scss']
})
export class PointComponent {
  grades: any = [];
  students: any = [];
  isModalOpen: boolean = false;
  totalStudents : number = 0;
  subjects : any = []
  selectedSubject: number = 1;

  myForm: FormGroup = new FormGroup({});

  category1AchievedPercentage : any
  category2AchievedPercentage : any

  category1AchievedCount: number = 0;
  category1NotAchievedCount: number = 0;
  category2AchievedCount: number = 0;
  category2NotAchievedCount: number = 0;


  constructor(
    private studentService: StudentServiceService,
    private apiService: ApiService,
    private fb: FormBuilder,
  ) {}

  ngOnInit() {
    this.getGrade();
    this.getSubject();

    this.myForm = this.fb.group({
      name: ['', Validators.required], // Add other form controls with their initial values and validators
      studentCode: ['', Validators.required],
      diemGiuaKiCDR1_2: [''],
      diemGiuaKiCDR2_1: [''],
      diemGiuaKiCDR1_2H10: [''],
      diemGiuaKiCDR2_1H10: [''],
      // ... add more controls as needed
    });
  }


  getGrade() {
    this.apiService.getGrade().subscribe(
      (res) => {
        this.grades = res;
        console.log(this.grades)
        this.totalStudents = this.grades.length;
        this.cacularPercent();

      },
      (err) => {
        console.log(err);
      }
    );
  }

  onUpdate() {
    const invalidGrade = this.grades.some((grade: { diemGiuaKiCDR1_2: number; diemGiuaKiCDR2_1: number; }) => {
      return grade.diemGiuaKiCDR1_2 > 5 || grade.diemGiuaKiCDR2_1 > 5;
    });

    if (invalidGrade) {
      alert('Invalid input. Point cannot be greater than 5.');
      return;
    }
    for (let grade of this.grades) {
      this.apiService.updateGrade(grade.id, grade.diemGiuaKiCDR1_2, grade.diemGiuaKiCDR2_1).subscribe(
        response => {

          console.log('Grade updated successfully:', response);
        }, error => {

          console.error('Error updating grade:', error);;
        })

    }

    this.getGrade();
  }

  cacularPercent() {
    console.log(this.grades)

    for (let grade of this.grades) {
      if (grade.mucDatCDR1_2 == 1) {
        this.category1AchievedCount++;
      } else {
        this.category1NotAchievedCount++;
      }

      if (grade.mucDatCDR2_1 == 1) {
        this.category2AchievedCount++;
      } else {
        this.category2NotAchievedCount++;
      }
    console.log("category1AchievedPercentage: " + this.category1AchievedCount);

    }
    this.category1AchievedPercentage = (this.category1AchievedCount / this.totalStudents) * 100;
    this.category2AchievedPercentage = (this.category2AchievedCount / this.totalStudents) * 100;


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

  onSubjectChange() {
    if (this.selectedSubject == 2) {
      // Check if the selectedSubject is different from the initialSubject
        // Reset your form or perform any other necessary actions
        this.resetForm();
    }

  }

  resetForm() {
    // Reset the values in your form or initialize them as needed
    for(let grade of this.grades){
      grade.diemGiuaKiCDR1_2 = null;
      grade.diemGiuaKiCDR2_1 = null;
      grade.diemGiuaKiCDR1_2H10 = null;
      grade.diemGiuaKiCDR2_1H10 = null;
      grade.diemGiuaKi = null;
      grade.mucDatCDR1_2 = null;
      grade.mucDatCDR2_1 = null;
    }
    // Add more reset logic as needed
  
  }


  

  onFileChange(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.readExcel(file);
    }
  }
  readExcel(file: File) {
    const reader: FileReader = new FileReader();
  
    reader.onload = (e: any) => {
      const data: ArrayBuffer = e.target.result;
      const workbook: XLSX.WorkBook = XLSX.read(data, { type: 'array' });
  
      // Assuming you have a single sheet in your Excel file
      const sheetName = workbook.SheetNames[0];
      const worksheet: XLSX.WorkSheet = workbook.Sheets[sheetName];
  
      // Convert worksheet data to JSON
      const jsonData: any[] = XLSX.utils.sheet_to_json(worksheet, { raw: true });
  
      // Use jsonData to populate your form or process the data
      console.log(jsonData);
    };
  
    reader.readAsArrayBuffer(file);
  }
  populateForm(jsonData: any[]) {
    // Assuming jsonData has the necessary structure to match your form fields
  
    // Assuming jsonData is an array of objects where each object represents a student
    // You may need to adjust this based on the actual structure of your jsonData
  
    if (jsonData && jsonData.length > 0) {
      // Assuming the first item in the array contains the data for the first student
      const firstStudentData = jsonData[0];
  
      // Update form controls with the data
      this.myForm.patchValue({
        name: firstStudentData.name,
        studentCode: firstStudentData.studentCode,
        diemGiuaKiCDR1_2: firstStudentData.diemGiuaKiCDR1_2,
        diemGiuaKiCDR2_1: firstStudentData.diemGiuaKiCDR2_1,
        diemGiuaKi: firstStudentData.diemGiuaKi,
        diemGiuaKiCDR1_2H10: firstStudentData.diemGiuaKiCDR1_2H10,
        diemGiuaKiCDR2_1H10: firstStudentData.diemGiuaKiCDR2_1H10,
        // Add more lines to update other controls based on your form structure
      });
    }
  }
  

}
