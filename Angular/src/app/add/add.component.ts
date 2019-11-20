import { Component, OnInit } from '@angular/core';
import { VendorContactDetails } from '../vendorcontactDetails';
import { MainServiceService } from '../main-service.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

  vendorDetail=new VendorContactDetails();

  constructor(private _mainservice:MainServiceService) { }

  ngOnInit() {
    this.getVendorById();
  }

  private reset()
  {
    this.vendorDetail.vName=null;
    this.vendorDetail.vAddress=null;
    this.vendorDetail.vLocation=null;
    this.vendorDetail.pincode=null;
    this.vendorDetail.email=null;
    this.vendorDetail.department=null;
    this.vendorDetail.phone=null;
    this.vendorDetail.cName=null;
    this.vendorDetail.vService=null;

  }

  add():void{
    console.log(this.vendorDetail);
    this. _mainservice.add(this.vendorDetail).subscribe((response)=>
    {
      console.log(response);
      this.reset();
    },(error)=>{
      console.log(error);
    }
    );
  }
getVendorById(): void{
  this._mainservice.getVendorDetailsById().subscribe((Data)=>
  {
    this.vendorDetail=Data,
    console.log(Data);
  },(error)=>{
    console.log(error);
  }
  );
}

}
