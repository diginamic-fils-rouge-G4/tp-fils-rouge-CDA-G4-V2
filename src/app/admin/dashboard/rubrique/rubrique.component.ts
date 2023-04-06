import { AfterViewInit, Component, ElementRef, OnInit } from '@angular/core';
import { DataTable } from 'simple-datatables';
import { Style } from 'src/app/_shared/class/Style';

@Component({
  selector: 'app-rubrique',
  templateUrl: './rubrique.component.html',
  styleUrls: ['./rubrique.component.scss'],
})
export class RubriqueComponent implements OnInit, AfterViewInit {
  rubrique = [
    { nom: 'general' },
    { nom: 'la santé publique' },
    { nom: 'biodiversité' },
    { nom: 'ecologie' },
    { nom: 'rechauffement' },
    { nom: 'protaction' },
    { nom: 'gaming' },
    { nom: 'avent' },
  ];

  constructor(private elRef: ElementRef) {}

  ngOnInit(): void {}

  ngAfterViewInit(): void {
    const datatable = new DataTable('#table', {
      searchable: true,
      fixedHeight: false,
      labels: {
        placeholder: 'Recherchez',
        perPage: '{select} données par page',
        noRows: 'Aucune donnée',
        info: 'De {start} à {end} sur {rows} données',
      },
      sortable: false,
    });
    const style = new Style(this.elRef);
    style.dataTableTopAndBottom('.dataTable-top');
    style.dataTableTopAndBottom('.dataTable-bottom');
    style.pagination();
    style.input();
    datatable.on('datatable.search', () => {
      style.pagination();
    });
    datatable.on('datatable.page', () => {
      style.pagination();
    });
  }
}
