const express = require('express');
const { createLibro, getLibros } = require('./adapters/libroController');
const { createAutor, getAutores } = require('./adapters/autorController');

const router = express.Router();

router.post('/libros', createLibro);
router.get('/libros', getLibros);
router.post('/autores', createAutor);
router.get('/autores', getAutores);

module.exports = router;
