// utilisé la logique du ngoninit pour rappel une fonction qui vue off
import { Component, OnInit ,ElementRef ,AfterViewInit} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {RubriqueService} from "../../../_shared/services/rubrique.service";
import {Rubrique} from "../../../_shared/entities/Rubrique";
import {RubriqueDTO, RubriqueUpdateDTO} from "../../../_shared/dto/forum-dto";
import {JwtTokenService} from "../../../_shared/services/jwt-token.service";

@Component({
  selector: 'app-rubrique',
  templateUrl: './rubrique.component.html',
  styleUrls: ['./rubrique.component.scss']
})
export class RubriqueComponent implements OnInit {

  selectedId: any;

  rubriques: Rubrique[] =[]

  addClass: boolean = false;
  editModal: boolean = false;

  modifiedrebriqueId!:number;
  modifiedrebriqueName!:string;
  isAdmin: boolean = false

  form = new FormGroup({
    libelle: new FormControl('',Validators.minLength(2))
  });

  rubrique: RubriqueDTO = {}

  constructor(
    private elementRef: ElementRef,
    private rubriqueService: RubriqueService,
    private tokenService: JwtTokenService
    )
  { }

  ngOnInit(): void {
    this.getAllRubriques()
    this.isAdmin = this.tokenService.isAdmin(this.tokenService.getToken() as string)
    this.addClass = false;
    this.editModal = false;
  };


  openVerticale(e:Event,id:number){
    this.closeAllVerticaleButGivenId(id);
    this.selectedId = id
    const navRubrique: any = document.getElementById("rub"+id);
    const icon: any = document.getElementById("icon"+id);
    const xicon: any = document.getElementById("Xicon"+id);

    xicon.classList.remove('d-none')
    navRubrique.classList.toggle('d-none')
    navRubrique.classList.toggle('nav-rubrique-visible')
    icon.classList.toggle('fa-ellipsis-vertical')
    icon.classList.toggle('invisible')

  }

  closeAllVerticaleButGivenId(id:number){
    for (let index = 0; index < this.rubriques.length; index++) {
      if (this.rubriques[index].id != id){
        const navRubrique: any = document.getElementById("rub"+this.rubriques[index].id);
        const icon: any = document.getElementById("icon"+this.rubriques[index].id);
        const xicon: any = document.getElementById("Xicon"+this.rubriques[index].id);

        xicon.classList.add('d-none')
        navRubrique.classList.add('d-none')
        navRubrique.classList.remove('nav-rubrique-visible')
        icon.classList.add('fa-ellipsis-vertical')
        icon.classList.remove('invisible')
      }
    }
  }

  closeVerticale(id:number){

    console.log(id);

    this.selectedId = id
    const navRubrique: any = document.getElementById("rub"+id);
    const icon: any = document.getElementById("icon"+id);
    const xicon: any = document.getElementById("Xicon"+id);

    navRubrique.classList.add('d-none')
    navRubrique.classList.toggle('nav-rubrique-visible')
    icon.classList.add('fa-ellipsis-vertical')
    icon.classList.remove('d-none')
    xicon.classList.add('d-none')
  }

  onClickChangeAddModalVisibility() {
    this.addClass = !this.addClass;
  }

  closeChangeEditModalVisibility() {
    this.editModal = false;
  }



  openChangeEditModalVisibility(id:number) {
    this.editModal = true;

    for (let index = 0; index < this.rubriques.length; index++) {
      if (this.rubriques[index].id == id){
        this.modifiedrebriqueId = this.rubriques[index].id ;
        this.modifiedrebriqueName = this.rubriques[index].libelle;
      }
    }
  }



  getAllRubriques() {
    this.rubriqueService.getAll().subscribe(res => {
      this.rubriques = res
      console.log(this.rubriques)
    })
  }
  createRubrique() {
    if(this.form.valid) {
      this.rubrique.libelle = this.form.value.libelle
      this.rubriqueService.create(this.rubrique).subscribe(() => {
        this.ngOnInit()
      })
    }
  }

  deleteRubrique(id: number) {
    this.rubriqueService.delete(id).subscribe(() => {
      this.ngOnInit()
    })
  }

  updateRubrique() {

    if(this.form.valid) {

      let rubriqueToEdit: RubriqueUpdateDTO = {}

      rubriqueToEdit.id = this.modifiedrebriqueId
      rubriqueToEdit.libelle = this.form.value.libelle

      this.rubriqueService.update(rubriqueToEdit).subscribe(() => {
        this.ngOnInit()
      })
    }
    this.closeChangeEditModalVisibility()
  }
}
