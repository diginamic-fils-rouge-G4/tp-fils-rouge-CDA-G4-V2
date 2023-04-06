import { AfterViewInit, Component, ElementRef, OnInit } from '@angular/core';
import { DataTable } from 'simple-datatables';
import { Utilisateur } from '../../../_shared/entities/Utilisateur';
import { UtilisteurService } from '../../../_shared/services/utilisteur.service';
import { Style } from 'src/app/_shared/class/Style';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  utilisateurs: Utilisateur[] = [];
  nameIsSortedAsc: boolean = false
  firstnameIsSortedAsc: boolean = false
  roleIsSortedAsc: boolean = false

  formFilter = new FormGroup({
    search: new FormControl('', [Validators.required])
  })
  constructor(
    private elRef: ElementRef,
    private utilisateurService: UtilisteurService
  ) {}

  ngOnInit(): void {
    this.getAllUtilisateurs();
  }

  getAllUtilisateurs() {
    this.utilisateurService.getAll().subscribe(res => {
      this.utilisateurs = res.filter(user => user.role !== "ROLE_ADMIN");
    });
  }

  sortNameByAscOrder() {
    this.nameIsSortedAsc = !this.nameIsSortedAsc
    if(this.nameIsSortedAsc) {
      this.utilisateurs.sort((a,b) => a.nom.localeCompare(b.nom))
    } else {
      this.utilisateurs.sort((a,b) => b.nom.localeCompare(a.nom))
    }

  }
  sortFirstNameByAscOrder() {
    this.firstnameIsSortedAsc = !this.firstnameIsSortedAsc
    if(this.firstnameIsSortedAsc) {
      this.utilisateurs.sort((a,b) => a.prenom.localeCompare(b.prenom))
    } else {
      this.utilisateurs.sort((a,b) => b.prenom.localeCompare(a.prenom))
    }
  }

  sortRoleByAscOrder() {
    this.roleIsSortedAsc = !this.roleIsSortedAsc
    if(this.roleIsSortedAsc) {
      this.utilisateurs.sort((a,b) => a.role.localeCompare(b.role))
    } else {
      this.utilisateurs.sort((a,b) => b.role.localeCompare(a.role))
    }
  }

  deleteUtilisateur(id: number) {
    this.utilisateurService.delete(id).subscribe(() => {
      this.ngOnInit()
    });
  }
}
