import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getStudent(){
    return this.httpClient.get('http://localhost:8080/students/all').pipe(map(v => v))
  }

  updateStudent(id: any, student: any){
    return this.httpClient.put("http://localhost:8080/students/updateCDR/" + id,student);
  }

  setCDR(form : any){
    return this.httpClient.post("http://localhost:8080/cdr-giua-ki/add", form);
  }

  getGrade(){
    return this.httpClient.get('http://localhost:8080/grades/all');
  }

  updateGrade(id : any, diemGiuaKiCDR1_2 : any, diemGiuaKiCDR2_1 : any){
     const gradeFor = { diemGiuaKiCDR1_2 : diemGiuaKiCDR1_2, diemGiuaKiCDR2_1 : diemGiuaKiCDR2_1};
     return this.httpClient.put("http://localhost:8080/grades/update/" + id,gradeFor);
  }

  addSubject(form : any){
    return this.httpClient.post("http://localhost:8080/subjects/add", form);
  }

  getSubject(){
    return this.httpClient.get('http://localhost:8080/subjects/all');
  }

  deleteSubject(id : any){
    return this.httpClient.delete('http://localhost:8080/subjects/delete/' + id);
  }

}
