import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ApiResult} from './api/ApiResult';
import {City} from './api/City';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  DISTANCE_CALCULATOR_SERVER_URL = 'http://127.0.0.1:8080';

  constructor(private httpClient: HttpClient) {
  }

  calculateDistance(fromCityCode: string, toCityCode: string, averageSpeed: number): Observable<ApiResult> {
    const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin' : 'http://127.0.0.1:8080'
        })
      };
    const url = `${this.DISTANCE_CALCULATOR_SERVER_URL}/distance/calculate-distance/${fromCityCode}/${toCityCode}/${averageSpeed}`;
    console.log(`Calling calculate distance rest service:${url}`);
    return this.httpClient.get<ApiResult>(
      url,
      httpOptions
    );
  }
}
