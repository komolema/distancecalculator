import { Component } from '@angular/core';
import {ApiService} from './api.service';
import {ApiResult} from './api/ApiResult';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'distance-angular';

  averageSpeed: number;
  toCityCode: string;
  fromCityCode: string;

  apiResult: ApiResult;

  constructor(private apiService: ApiService) {}

  calculateDistance() {
    this.apiService.calculateDistance(this.fromCityCode, this.toCityCode, this.averageSpeed)
      .subscribe((apiResult: ApiResult) => {
      this.apiResult = apiResult;
      console.log(apiResult);
    });
  }
}
