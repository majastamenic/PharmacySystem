import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MedicinePharmacy } from 'src/app/model/medicinePharmacy';
import { MedicinePharmacyService } from 'src/app/service/medicine-pharmacy.service';

@Component({
  selector: 'app-all-medications',
  templateUrl: './all-medications.component.html',
  styleUrls: ['./all-medications.component.css']
})
export class AllMedicationsComponent implements OnInit {

  id : any;
  medicine : MedicinePharmacy[]=[];
  pharmacyName:any;
  loggedUser: any = sessionStorage.getItem('user');
  constructor(private medicinePharmacyService : MedicinePharmacyService,private router: Router, private toastrService: ToastrService,private _ActivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.pharmacyName = params.get('pharmacyName');
    });
    if(this.loggedUser){
    this.medicinePharmacyService.getByPharmacy(this.pharmacyName).subscribe((data: MedicinePharmacy[]) => {
      this.medicine = data;
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    })}
    else{
      this.router.navigate(['login']);
      this.toastrService.info('Please log in first.');
    }
  }

  define(medicationName:"", medicationId:0, i:number){
    this.medicinePharmacyService.deleteFromPharmacy(medicationName,medicationId,this.loggedUser).subscribe((data: any) => {
      this.toastrService.success('Medicine deleted!');
      window.location.reload();
    }, (error: { status: number; error: { message: string | undefined; }; }) => {
      if(error.status == 400)
        this.toastrService.warning(error.error.message);
      else
        this.toastrService.error("Server error: can't delete medication!");
    })
  }
}