import { Component, OnInit } from '@angular/core';
import {jsPDF} from "jspdf";

@Component({
  selector: 'app-selection-menu',
  templateUrl: './selection-menu.component.html',
  styleUrls: ['./selection-menu.component.scss']
})
export class SelectionMenuComponent implements OnInit {

  nBMenuPerRow = new Array(4);
  constructor() { }

  ngOnInit(): void {
  }

}
