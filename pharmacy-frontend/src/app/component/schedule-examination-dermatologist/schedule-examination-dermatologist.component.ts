import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-schedule-examination-dermatologist',
  templateUrl: './schedule-examination-dermatologist.component.html',
  styleUrls: ['./schedule-examination-dermatologist.component.css']
})
export class ScheduleExaminationDermatologistComponent implements OnInit {

  loggedUser: any = sessionStorage.getItem('user');
  loggedUserRole: any = sessionStorage.getItem('role');

  pathParam: any;
  model: any;
  startTime = { hour: 13, minute: 30 };
  endTime = { hour: this.startTime.hour, minute: this.startTime.minute};
  minuteStep = 30;

  examination: any = { oldExam: {id:''}, schedule: {startDate:'', endDate:'', startTime:'', endTime:''}};

  constructor( private router: Router,
    private _ActivatedRoute: ActivatedRoute, private toastrService: ToastrService) { 
    if(!this.loggedUser){
      this.router.navigate(['login']);
      toastrService.info('Please login first!');
    }
  }

  ngOnInit(): void {
    if(this.loggedUserRole == 'DERMATOLOGIST'){
      this.examination.user = this.loggedUser;

      this._ActivatedRoute.paramMap.subscribe(params =>{
        this.pathParam = params.get('pathParam');
      })
    }else{
      this.router.navigate(['home']);
      this.toastrService.error('You do not have rights to access this page!');
    }
  }


  schedule() {
    /*const counseling = {
      schedule: {
        startDate: `${this.model.year}-${this.model.month}-${this.model.day}`,
        endDate: `${this.model.year}-${this.model.month}-${this.model.day}`,
        startTime: `${this.startTime.hour}:${this.startTime.minute}:00`,
        endTime: `${this.endTime.hour}:${this.endTime.minute}:00`
      }, 
      patientEmail: this.pathParam,
      pharmacistEmail: this.loggedUser
    }*/

    /*this.counselingService.createCounselingByPharmacist(counseling).subscribe(data => {
      console.log(data);
      this.toastrService.success('Counseling is scheduled.');
      this.router.navigate(['home'])
    }, error => {
      this.toastrService.error('Required term is occupied.');
    });*/
  }

}
