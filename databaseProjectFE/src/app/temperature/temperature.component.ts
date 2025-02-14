import { Component, OnInit } from '@angular/core';
import { TemperatureService } from '../services/temperature.service';
import { Temperature } from '../model/temperature';



@Component({
  selector: 'app-temperature',
  templateUrl: './temperature.component.html',
  styleUrls: ['./temperature.component.css']
})
export class TemperatureComponent implements OnInit {
  rowData: Temperature[] = [];
  newTemp: number;
  data: any;
  options: any;
  timeValues: Date[] = [];
  tempValues: number[] = [];


  columnDefs = [
    { headerName: 'TemperatureValue', field: 'tempValue', sortable: true, enableRowGroup: true, resizable: true },
    { headerName: 'TimeValue', field: 'timeValue', sortable: true, enableRowGroup: true, resizable: true }
  ];


  constructor(private temperatureService: TemperatureService) {
  }

  ngOnInit() {
    this.getTemperatures();
    console.log(this.tempValues);
  }

  getTemperatures() {
    this.temperatureService.getTemperatureForUser().subscribe(response => {
      this.rowData = response;
      this.getValuesForChart();
      this.assignValuesToChart();
    })
  }

  getValuesForChart() {
    this.timeValues = [];
    this.tempValues = [];
    this.rowData.forEach(element => {
      this.timeValues.push(element.timeValue);
      this.tempValues.push(element.tempValue);
    });
  }

  assignValuesToChart() {
    this.data = {
      labels: this.timeValues,
      datasets: [
        {
          label: 'Temperatures Values',
          data: this.tempValues
        }
      ]
    }

    this.options = {
      title: {
        display: true,
        text: 'Graph',
        fontSize: 16
      },
      legend: {
        position: 'bottom'
      }
    };
  }

  onGridReady(params) {
    params.api.sizeColumnsToFit();
  }

  updateValues(){
    this.getTemperatures();
  }

  insertNewTemp(newTemp: number){
    this.newTemp = newTemp;
    console.log(this.newTemp);
    this.temperatureService.insertNewTemp(this.newTemp).subscribe(resp => {
      console.log(resp);
    });
  }


}
