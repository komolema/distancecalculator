import {City} from './City';

export class ApiBody {
  fromCity: City;
  toCity: City;
  distance: number;
  duration: string;
  numberOfStops: number;
  durationOfStops: number;
}
