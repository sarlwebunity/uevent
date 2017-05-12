'use strict';

exports.getUser = getUser;
exports.getUsers = getUsers;

/**
 * Bouchon data pour graph
 * @param req
 * @param res
 * @param next
 */
var users = [
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
];

function getUser(req, res, next) {
    /*res.status(401)
     .send({})
     .end();*/
    var user;

    getUserById(req.param('id'));
    res.send(user);

    function getUserById(id) {
        //On parcours chaque sortie
        return users.forEach(getUser(id));

        function getUser(id) {

            return function (ut) {
                if (id != '' && typeof(id) != 'undefined') {
                    if (ut.id == id) {
                        user = ut;
                    }
                }
            }
        }
    }
}

function getUsers(req, res, next) {
    /*res.status(401)
     .send({})
     .end();*/

    res.send(users);
}
