'use strict';

var express = require('express');
var controller = require('./sortie.controller.js');

var router = express.Router();

router.get('/:id', controller.getSortie);
router.get('/', controller.getSorties);

module.exports = router;
