import { Injectable } from '@angular/core';

export interface Student {
  id: string;
  name: string;
  studentId: string;
  midTermGradeH10: string;
  midTermGradeH4: string;
  finalGradeH10: string;
  finalGradeH4: string;
  totalGrade: string;
}

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {
  private students = [];

  constructor() {
    
    this.students = [];
  }

  
}