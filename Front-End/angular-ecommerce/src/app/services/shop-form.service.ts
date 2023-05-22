import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShopFormService {

  constructor() { }

  getCreditCardMonths(startMont:number): Observable<number[]> {

    let data: number[] = [];
    //build an arry for month dropdown list
    //- start the current month loop until 

    for (let theMonth =startMont; theMonth<= 12 ; theMonth++) {
      data.push(theMonth);
  }
  return of(data);
 }

 getCreditCardYears(): Observable<number[]> {
  let data: number[] = [];

  //build an array for  "year" downlist list
  //- start at current year and loop for next 10 year

  const startYear: number = new Date().getFullYear();
  const endYear: number = startYear + 10 ;

  for (let theYear = startYear; theYear <= endYear ; theYear++) {
    data.push(theYear);
  }
  return of(data);
 }
}
