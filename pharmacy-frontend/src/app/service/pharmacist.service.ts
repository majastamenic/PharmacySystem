import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PHARMACISTSBYPHARMACY_PATH, PHARMACIST_REGISTRATION_PATH, PHARMACY_PATH, FREE_PHARMACIST_PATH, PHARMACIST_VACATION_CHECK_PATH, DELETEPHARMACIST_PATH} from '../util/paths';
import { Observable } from 'rxjs';
import { DateTime } from 'src/app/model/examination';


@Injectable({
  providedIn: 'root'
})
export class PharmacistService {

  constructor(private httpClient: HttpClient) { }

  public createPharmacist(pharmacist:any, adminEmail:string): Observable<any>{
    return this.httpClient.post(PHARMACIST_REGISTRATION_PATH + '/' + adminEmail, pharmacist );
  }
  getAll(): Observable<any>{
    return this.httpClient.get(PHARMACY_PATH);
  }

  getPharmacistsByPharmacyId(name: string):any{
    return this.httpClient.get(PHARMACISTSBYPHARMACY_PATH + '/' + name)
  }

  getFreePharmacistOnDate(pharmacyName: string, date: DateTime) : any{
    return this.httpClient.put(FREE_PHARMACIST_PATH + '?pharmacy=' + pharmacyName, date);
  }

  scheduleVacationTerm(vacation: any, email: any){
    return this.httpClient.post(PHARMACIST_VACATION_CHECK_PATH + '/' + email, vacation);
  }

  deletePharmacist(email: string, adminEmail: string):any{
    return this.httpClient.put(DELETEPHARMACIST_PATH + '/' + email + '/'+ adminEmail, null);
  }

  findByNameAndSurname(name: string, surname:string, pharmacyName:string):any{
    return this.httpClient.get(PHARMACISTSBYPHARMACY_PATH + '/' + name + '/' + surname + '/' + pharmacyName)
  }
}
