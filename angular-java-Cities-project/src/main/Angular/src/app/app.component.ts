import { Component, OnInit } from '@angular/core';
import { PathService } from './path.service';

@Component({
  selector: 'app-path',
  templateUrl: './path.component.html',
  styleUrls: ['./path.component.css']
})
export class PathComponent implements OnInit {
  cities: any[] = [];
  selectedCityIds: number[] = [];
  shortestPath: any[] = [];

  constructor(private pathService: PathService) { }

  ngOnInit(): void {
    this.loadCities();
  }

  loadCities(): void {
    this.pathService.getAllCities().subscribe(
      data => {
        this.cities = data;
      },
      error => {
        console.error('Error fetching cities:', error);
      }
    );
  }

  findShortestPath(): void {
    if (this.selectedCityIds.length < 2) {
      alert('Select at least two cities.');
      return;
    }

    this.pathService.findShortestPath(this.selectedCityIds).subscribe(
      data => {
        this.shortestPath = data;
      },
      error => {
        console.error('Error finding shortest path:', error);
      }
    );
  }
}