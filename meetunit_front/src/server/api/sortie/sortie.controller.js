'use strict';

exports.getSortie = getSortie;
exports.getSorties = getSorties;

/**
 * Bouchon data pour graph
 * @param req
 * @param res
 * @param next
 */
var sorties = [
    {
        id: 1,
        titre: 'Concert Lindsey Stirling',
        dateDebut: new Date(2017,7,12,14,55),
        dateFin: new Date(2017,7,12,17,50),
        lieu: 'Toulouse',
        activite: {
            id: 1,
            logo: 'Concert',
        },
        nbParticipants: 4,
        nbParticipantsMax: 12,
        prix: 0,
        photo: 'https://i.ytimg.com/vi/aE2GCa-_nyU/maxresdefault.jpg',
        description: "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker.",
        organisateur: {
            id: 1,
            pseudo: 'Winni',
        },
        participants: [
            {
                id: 1,
                pseudo: 'Winni',
            },
            {
                id: 2,
                pseudo: 'PtiBscuit',
            },
            {
                id: 3,
                pseudo: 'Groeldor',
            },
        ]
    },
    {
        id: 2,
        titre: 'Jeux de société',
        dateDebut: new Date(),
        dateFin: new Date(),
        lieu: 'Toulouse',
        activite: {
            id: 1,
            logo: 'jeux',
        },
        nbParticipants: 4,
        nbParticipantsMax: 12,
        prix: 10,
        photo: 'http://www.blue.fr/jeux/img/de-societe.jpg',
        description: "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker.",
        organisateur: {
            id: 1,
            pseudo: 'Winni',
        },
        participants: [
            {
                id: 1,
                pseudo: 'Winni',
            },
            {
                id: 2,
                pseudo: 'PtiBscuit',
            },
            {
                id: 3,
                pseudo: 'Groeldor',
            },
        ]
    },
    {
        id: 3,
        titre: 'Soirée poker',
        dateDebut: new Date(),
        dateFin: new Date(),
        lieu: 'Toulouse',
        activite: {
            id: 1,
            logo: 'jeux',
        },
        nbParticipants: 4,
        nbParticipantsMax: 12,
        prix: 0,
        photo: '',
        description: '',
        organisateur: {
            id: 1,
            pseudo: 'Winni',
        },
        participants: [
            {
                id: 1,
                pseudo: 'Winni',
            },
            {
                id: 2,
                pseudo: 'PtiBscuit',
            },
            {
                id: 3,
                pseudo: 'Groeldor',
            },
        ]
    },
];
function getSortie(req, res, next) {
    /*res.status(401)
     .send({})
     .end();*/
    var sortie;

    getSortieById(req.param('id'));
    res.send(sortie);

    function getSortieById(id) {
        //On parcours chaque sortie
        return sorties.forEach(getSortie(id));

        function getSortie(id) {

            return function (sort) {
                if (id != '' && typeof(id) != 'undefined') {
                    if (sort.id == id) {
                        sortie = sort;
                    }
                }
            }
        }
    }
}

function getSorties(req, res, next) {
    /*res.status(401)
     .send({})
     .end();*/

    res.send(sorties);
}
