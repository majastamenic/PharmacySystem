import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginUserDto, PasswordChangeDto, PharmacyAdminDto, UserRegistrationDto } from '../model/user-model';
import { LOGIN_PATH, PATIENT_PATH,  PATIENT_VALID_PATH, DERMATOLOGIST_PATH, PHARMACY_ADMIN_PATH, SUPPLIER_PATH, USER_PATH, SYSTEM_ADMIN_PATH, PASSWORD_USER_PATH, INFO_PATH, UPDATE_USER_PATH} from '../util/paths';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  login(user: LoginUserDto): any {
    return this.httpClient.post(LOGIN_PATH, user);
  }

  registration(user: UserRegistrationDto): any {
    return this.httpClient.post(PATIENT_PATH, user);
  }

  saveUser(user: UserRegistrationDto): any{
    return this.httpClient.post(USER_PATH, user);
  }

  changePassword(user: UserRegistrationDto): any{
    return this.httpClient.put(PASSWORD_USER_PATH, user);
  }

  registrationDermatologist(user: UserRegistrationDto): any {
    return this.httpClient.post(DERMATOLOGIST_PATH, user);
  }

  registrationpharmacyAdmin(admin: PharmacyAdminDto): any{
    return this.httpClient.post(PHARMACY_ADMIN_PATH, admin);
  }

  registrationSupplier(user: UserRegistrationDto): any{
    return this.httpClient.post(SUPPLIER_PATH, user);
  }

  registrationSystemAdmin(user: UserRegistrationDto): any{
    return this.httpClient.post(SYSTEM_ADMIN_PATH, user);
  }

  isUserLogin(){
    let user = sessionStorage.getItem('user');
    return !(user == null)
  }

  isPharmacist(){
    return (sessionStorage.getItem("role") == 'PHARMACIST');
  }

  isDermatologist(){
    return (sessionStorage.getItem("role") == 'DERMATOLOGIST');
  }

  isPharmacyAdmin(){
    return (sessionStorage.getItem('role') == 'PHARMACY_ADMIN');
  }

  isPatient(){
    return (sessionStorage.getItem('role') == 'PATIENT');
  }

  isAdmin(){
    return (sessionStorage.getItem('role') == 'ADMIN');
  }

  isSupplier(){
    return (sessionStorage.getItem('role') == 'SUPPLIER');
  }

  logOut(){
    sessionStorage.removeItem('user');
    sessionStorage.removeItem('role');
  }


  getUserByEmail(email:string){
    return this.httpClient.get(INFO_PATH + '/' + email);
  }

  updateUser(user: any){
    return this.httpClient.put(UPDATE_USER_PATH, user);
  }

  updatePassword(userEmail: string, passwordDto: PasswordChangeDto){
    return this.httpClient.put(USER_PATH + "/updatePassword", {
      email: userEmail,
      oldPass: passwordDto.oldPassword,
      newPass: passwordDto.newPassword,
      newPassRepeat: passwordDto.newPasswordRepeat
    });
  }

}
