import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActionsBenefitsComponent } from './component/actions-benefits/actions-benefits.component';
import { HomeComponent } from './component/home/home.component';
import { HospitalComponent } from './component/hospital/hospital.component';
import { MedicineComponent } from './component/medicine/medicine.component';
import { EPrescriptionComponent } from './component/prescription/e-prescription/e-prescription.component';
import { UploadQRComponent } from './component/prescription/upload-qr/upload-qr.component';
import { LoginComponent } from './component/user/login/login.component';
import { RegistrationComponent } from './component/user/registration/registration.component';
import { AddMedicinesComponent } from './system-admin/add-medicines/add-medicines.component';
import { AddPharmacyComponent } from './system-admin/add-pharmacy/add-pharmacy.component';
import { RegDermatologistComponent } from './system-admin/reg-dermatologist/reg-dermatologist.component';
import { SystemAdminComponent } from './system-admin/system-admin.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'user', component: RegistrationComponent},
  {path: 'hospital', component: HospitalComponent},
  {path: 'actions', component: ActionsBenefitsComponent},
  {path: 'medicine', component: MedicineComponent},
  {path: 'uploadQR', component: UploadQRComponent},
  { path: 'ePrescription', component: EPrescriptionComponent },
  {path: 'system-admin', component: SystemAdminComponent,
    children : [
      { path: 'addMedicines', component: AddMedicinesComponent},
      { path: 'addPharmacy', component: AddPharmacyComponent},
      { path: 'regDermatologist', component: RegDermatologistComponent}
    ]
  }, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
