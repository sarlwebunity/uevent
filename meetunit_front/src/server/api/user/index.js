'use strict';

var express = require('express');
var controller = require('./user.controller.js');

var router = express.Router();

router.get('/:id', controller.getUser);
router.get('/', controller.getUsers);

module.exports = router;
