import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { Injectable } from "@angular/core";
@Injectable()
export class QueueController {
    constructor(private httpClient:HttpClient) { 
 
    }
   
    public getCurrencyBaseList():Observable<any> {
        return this.httpClient.get("//localhost:8080/currency");
      }
    
      public getServiceCenterList():Observable<any>{
        return this.httpClient.get("//localhost:8080/service-center");
      }
      public getCurrencys():Observable<any>{
      
        return this.httpClient.get('//localhost:8080/currency');
        
      }
      public getProfileByUserName(userName:string):Observable<any>{
        return this.httpClient.get('//localhost:8080/queue/user-profile/'+ userName);
      }
    
      public postQueue(baseAmount:number, baseCurrency:string, distCurrency:string, dateAppointment:string, memberID:string, serviceCenID:number ):Observable<any>{
        return this.httpClient.post("//localhost:8080/queue/"+baseCurrency+"/"+distCurrency+"/"+serviceCenID+"/"+memberID,{
          "dateAppointment" : dateAppointment,
          "baseAmount" : baseAmount
        });
      }

      public getQueueCurrencyByType(queueID:number, type:string):Observable<any>{
        return this.httpClient.get("//localhost:8080/queue/currency-type/"+queueID+"/"+type);
      }
    
      public getQueue(queueID:number):Observable<any>{
        return this.httpClient.get("//localhost:8080/queue/"+queueID);
      }
}
