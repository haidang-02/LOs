import { Component } from '@angular/core';
import { ApiService } from '../Service/api.service';

@Component({
  selector: 'app-list-subjects',
  templateUrl: './list-subjects.component.html',
  styleUrls: ['./list-subjects.component.scss']
})
export class ListSubjectsComponent {
  subjects: any = [];


  constructor(private apiService: ApiService) {this.getSubject()}
  
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

  delete(id : any){
    this.apiService.deleteSubject(id).subscribe(
      (res) => {
        console.log('Subject deleted successfully:', res);
        // You may want to update the subjects array or perform other actions after deletion
        this.getSubject(); // Example: Refresh the subjects list after deletion
      },
      (err) => {
        console.error('Error deleting subject:', err);
      }
    );
  }

}
