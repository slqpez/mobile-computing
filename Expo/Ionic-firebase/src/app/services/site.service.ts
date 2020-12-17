import { Injectable } from '@angular/core';
import {AngularFirestore, AngularFirestoreCollection} from '@angular/fire/firestore';
import { ActionSequence } from 'protractor';
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {SiteI} from "../models/site.interface"

@Injectable({
  providedIn: 'root'
})
export class SiteService {
    private sitesCollection: AngularFirestoreCollection<SiteI>;
    private sites: Observable<SiteI[]>;

  constructor(db:AngularFirestore) {
    this.sitesCollection = db.collection<SiteI>("sites");
    this.sites = this.sitesCollection.snapshotChanges().pipe(map(
      actions => {
        return actions.map(action =>{
          const data = action.payload.doc.data();
          const id = action.payload.doc.id;
          return {id, ...data};
        });
      }
    ))
   }

  getSites(){
  return this.sites;
  }

  getSite(id: string){
    return this.sitesCollection.doc<SiteI>(id).valueChanges();
  }

  updateSite(site:SiteI, id:string){
  return this.sitesCollection.doc(id).update(site); 
  }

  addSite(site: SiteI){
    return this.sitesCollection.add(site)
  }

  deleteSite(id:string){
    return this.sitesCollection.doc(id).delete();
  }

}
