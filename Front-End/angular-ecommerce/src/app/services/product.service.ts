import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  getListProduct() {
    throw new Error('Method not implemented.');
  }

  private baseUrl = 'http://localhost:6060/api/products';
  constructor(private httpClient: HttpClient) { }

  getProductList(): Observable<Product[]> {
     return this.httpClient.get<GetResponse>(this.baseUrl)
                .pipe(map(response => response._embedded.products)
      );
    }
}

interface GetResponse {
  _embedded: {
    products:Product[];
  }
}
  