import { Component, OnInit } from '@angular/core';
import { QueueController } from 'src/app/service/controller/queue.controller/queue-controller';
import { ReservationComponent } from 'src/app/component/reservation/reservation.component';
import { LoginComponent } from '../login/login.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-print-reserve',
  templateUrl: './print-reserve.component.html',
  styleUrls: ['./print-reserve.component.css']

})
export class PrintReserveComponent implements OnInit {
  dateAppointmentShow:string;
  dateOutShow:string;
  serviceCenShow:string;
  idQueueShow:number;
  nameMemberShow:string;
  emailUserShow:string;
  baseAmountShow:number;
  baseCurrencyShow:string;
  distCurrencyShow:string;
  serviceAddressShow:string;
  serviceTelShow:string;

  userName:string;

  constructor(
    private queueController:QueueController,
    private router:Router
    ) {
      if(typeof LoginComponent.userName === 'undefined' || LoginComponent.userName == null ){
        this.router.navigate(['login'])
      }
    }
    

  ngOnInit() {
    this.showQueueDetail();
    this.getServiceCen();
  }
  private showQueueDetail(){
    
    console.log("ID Queue : ",ReservationComponent.getQueueID());
    this.queueController.getQueue(ReservationComponent.getQueueID()).subscribe(data=>{
      this.userName = data.members.memUser +"";
      console.log("print success");
    },error=>{
      console.log("print error");
    });

   

    this.queueController.getQueueCurrencyByType(ReservationComponent.getQueueID(),"Base").subscribe(data=>{
      this.baseCurrencyShow = data.currency.currencyCode;

      // SET Detail

      this.dateAppointmentShow = data.queue.dateAppointment;
      this.dateOutShow = data.queue.dateQueue;  
      this.serviceCenShow = data.queue.serviceCenter.serviceCenName;
      this.serviceAddressShow = data.queue.serviceCenter.serviceCenAddress;
      this.serviceTelShow = data.queue.serviceCenter.serviceCenTel;
      this.idQueueShow = data.queue.queueID;
      this.baseAmountShow = data.queue.baseAmount;
      console.log(data.queue.members.memUser);
      console.log(this.userName)
      this.queueController.getProfileByUserName(data.queue.members.memUser).subscribe(data=>{
        this.nameMemberShow = data.name;
        this.emailUserShow = data.email;
      }); 
     
    });

  
    this.queueController.getQueueCurrencyByType(ReservationComponent.getQueueID(),"Dist").subscribe(data=>{
      this.distCurrencyShow = data.currency.currencyCode;
    })

  }

  private getServiceCen(){
    
      
  }
  logout(){
    LoginComponent.userName = null;
    this.router.navigate(['login']);

  }

  printReservation(reservePrint) {
    let printContents = document.getElementById(reservePrint).innerHTML;
    let originalContents = document.body.innerHTML;

    document.body.innerHTML = printContents;

    window.print();

    document.body.innerHTML = originalContents;
    document.close();
}

}

