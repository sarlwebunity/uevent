namespace app.evenements {
    'use strict';
    import IPromise = angular.IPromise;

    export class Sortie {

        id: number;
        titre: string;
        date: Date;
        logo: Logo;
        nbParticipant: number;
        nbParticipantMax: number;
        organisateur: Utilisateur;
        ville: string;

        /* @ngInject */
        constructor(id:number, titre:string, date:Date, logo:Logo, nbParticipant:number, nbParticipantMax:number, organisateur:Utilisateur, ville:string) {
            this.id=id;
            this.titre=titre;
            this.logo=logo;
            this.date=date;
            this.nbParticipant=nbParticipant;
            this.nbParticipantMax=nbParticipantMax;
            this.organisateur=organisateur;
            this.ville=ville;
        }

    }
}
