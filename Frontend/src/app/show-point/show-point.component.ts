import { Component } from '@angular/core';
import { ApiService } from '../Service/api.service';
import { StudentServiceService } from '../Service/student-service.service';

@Component({
  selector: 'app-show-point',
  templateUrl: './show-point.component.html',
  styleUrls: ['./show-point.component.scss']
})
export class ShowPointComponent {
  grades: any = [];
  students: any = [];
  isModalOpen: boolean = false;
  totalStudents : number = 0;
  subjects : any = []
  selectedSubject: number = 1;


  category1AchievedPercentage : any
  category2AchievedPercentage : any

  category1AchievedCount: number = 0;
  category1NotAchievedCount: number = 0;
  category2AchievedCount: number = 0;
  category2NotAchievedCount: number = 0;

  constructor(
    private studentService: StudentServiceService,
    private apiService: ApiService,
  ) {}

  ngOnInit() {
    this.getGrade();
    this.getSubject();


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
}
