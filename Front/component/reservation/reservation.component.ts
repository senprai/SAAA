import { Component, OnInit } from '@angular/core';
import { QueueController } from 'src/app/service/controller/queue.controller/queue-controller';

import { Router } from '@angular/router';
import { FormatDate } from 'src/app/service/format/format-date';
import { CloseScrollStrategy } from '@angular/cdk/overlay';
import { LoginComponent } from '../login/login.component';


@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  static getServiceCen(): any {
    throw new Error("Method not implemented.");
  }
  private static queueId;
  private dateAppointment: string;
  private baseAmount: number;
  private baseCurrency: string;
  private distCurrency: string;
  serviceCenter: string;

  private currencyBaseList: Array<any>;
  private currencyDistList: Array<any>;
  private serviceList: Array<any>;

  constructor(
    private queueController: QueueController, 
    private router: Router,
    private formatDate: FormatDate) { 
      if(typeof LoginComponent.userName === 'undefined' || LoginComponent.userName == null ){
        this.router.navigate(['login'])
      }
    }


  ngOnInit() {
    this.getServiceCenters();
    this.getCurrencyBaseToList();
    this.getCurrencyDistToList();
  }

  getCurrencyBaseToList(): void {
    this.queueController.getCurrencyBaseList().subscribe(data => {
      this.currencyBaseList = data;
    });
  }
  
  test(data):void{
    console.log(data,this.formatDate.formatDate(this.dateAppointment));
  }

  getCurrencyDistToList(): void{
    this.queueController.getCurrencyBaseList().subscribe(data => {
      this.currencyDistList = data;
    });
  }
  getServiceCenters(): void {
    this.queueController.getServiceCenterList().subscribe(data => {
      this.serviceList = data;
    });
  }
 
  getServiceSelect(): string {
    return this.serviceCenter;
  }

  public static getQueueID(): number {
    return this.queueId;
  }

  createQueue() {
    this.queueController.postQueue(this.baseAmount,this.baseCurrency,this.distCurrency,this.formatDate.formatDate(this.dateAppointment),LoginComponent.userName,1).subscribe(data=>{
      console.log(data);
      ReservationComponent.queueId = data.queueID;
      this.router.navigate(['print-reserve']);
    },error=>{
      console.log(error);
    });
  }
  logout(){
    LoginComponent.userName = null;
    this.router.navigate(['login']);

  }

}

