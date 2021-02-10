import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PATIENT_PATH, UPDATE_ALLERGY_PATH } from '../src/app/util/paths';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) { }

  getPatientByEmail(email: string){
    return this.http.get(PATIENT_PATH + "/" + email);
  }

  updateAllergies(email: string, allergies: Observable<string>){
    return this.http.put(UPDATE_ALLERGY_PATH + '/' + email, allergies);
  }
}