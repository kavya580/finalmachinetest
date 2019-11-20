import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../main-service.service';
import { VendorContactDetails } from '../vendorcontactDetails';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {

  popoverMessage="Do you want to disable?"
  details:VendorContactDetails[];
  vendorContactDetail=new VendorContactDetails();
  

  constructor(private _mainservice:MainServiceService) { }

  ngOnInit() {
    this.getVendorDetails();
  
  }

  //method for getting vendor+ its contact details
  getVendorDetails(): void{
    this._mainservice.getVendorDetails().subscribe((Data)=>
    {
      this.details=Data,
      console.log(Data);
    },(error)=>{
      console.log(error);
    }
    );
  }

  //search 
  search(searchString:string){
    if(searchString!=null){
    this._mainservice.search(searchString).subscribe((Data)=>
    {
      this.details=Data,
     console.log(Data);
  },(error)=>{
      console.log(error);
    }
    );
  }else{
    this.getVendorDetails();
  }
}
//disable
disable(vId:number):void{
  this. _mainservice.disable(this.vendorContactDetail,vId).subscribe((response)=>
  {
    console.log(response);
  this.getVendorDetails();
  },(error)=>{
    console.log(error);
  }
  );
}

edit(vId:number)
{
  this._mainservice.edit(vId);
}


}
