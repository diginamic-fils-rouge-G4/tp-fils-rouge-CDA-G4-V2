import { AfterViewInit, Component, ElementRef, OnInit } from '@angular/core';
import { DataTable } from 'simple-datatables';
import { Utilisateur } from '../../../_shared/entities/Utilisateur';
import { UtilisteurService } from '../../../_shared/services/utilisteur.service';
import { Style } from 'src/app/_shared/class/Style';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'],
})
export class UserComponent implements OnInit, AfterViewInit {
  utilisateurs: Utilisateur[] = [];

  constructor(
    private elRef: ElementRef,
    private utilisateurService: UtilisteurService
  ) {}

  ngOnInit(): void {}

  getAllUtilisateurs() {
    this.utilisateurService.getAll().subscribe((res) => {
      this.utilisateurs = res;
    });
  }

  deleteUtilisateur(id: number) {
    this.utilisateurService.delete(id).subscribe(() => {
      window.location.reload();
    });
  }

  ngAfterViewInit() {
    this.getAllUtilisateurs();

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
      data: this.utilisateurs,
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
