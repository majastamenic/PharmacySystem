import { Injectable } from '@angular/core';
import { HOSPITAL_PATH } from '../util/paths';
import { HttpClient } from '@angular/common/http';
import { HospitalRegistrationDto } from '../component/hospital/model/hospital-model';

@Injectable({
  providedIn: 'root'
})
export class HospitalService{

  constructor(private httpClient: HttpClient){ }

  registration(hospital: HospitalRegistrationDto): any {
    return this.httpClient.post(HOSPITAL_PATH, hospital);
  }
}
