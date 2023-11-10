import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PathService {
  private baseUrl = 'http://localhost:8080/api'; // Replace with your Spring Boot backend URL

  constructor(private http: HttpClient) {}

  getAllCities(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/cities`);
  }

  findShortestPath(cityIds: number[]): Observable<any[]> {
    return this.http.post<any[]>(`${this.baseUrl}/cities/shortest-path`, cityIds);
  }
}