import { Component, OnInit } from '@angular/core';
import {Rubrique} from "../../../_shared/entities/Rubrique";
import {RubriqueService} from "../../../_shared/services/rubrique.service";
import {JwtTokenService} from "../../../_shared/services/jwt-token.service";

@Component({
  selector: 'app-rubrique',
  templateUrl: './rubrique.component.html',
  styleUrls: ['./rubrique.component.scss'],
})
export class RubriqueComponent implements OnInit {
  rubriques: Rubrique[] = []
  nameIsSortedAsc: boolean = false
  constructor(
    private rubriqueService: RubriqueService,
    private tokenService: JwtTokenService
  ) {}

  ngOnInit(): void {
    this.getAllRubriques()
  }

  getAllRubriques() {
    this.rubriqueService.getAll().subscribe(res => {
      this.rubriques = res
    })
  }

  deleteRubrique(id: number) {
    this.rubriqueService.delete(id).subscribe(() => {
      this.ngOnInit()
    })
  }

  sortNameByAscOrder() {
    this.nameIsSortedAsc = !this.nameIsSortedAsc
    if(this.nameIsSortedAsc) {
      this.rubriques.sort((a,b) => a.libelle.localeCompare(b.libelle))
    } else {
      this.rubriques.sort((a,b) => b.libelle.localeCompare(a.libelle))
    }

  }
}
