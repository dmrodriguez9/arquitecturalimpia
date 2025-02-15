const CreateLibro = require('../use-cases/libro/CreateLibro');
const GetLibros = require('../use-cases/libro/GetLibros');
const libroRepository = require('../domain/repositories/LibroRepository');

const createLibro = async (req, res) => {
    try {
        const useCase = new CreateLibro(libroRepository);
        const libro = await useCase.execute(req.body);
        res.status(201).json(libro);
    } catch (error) {
        res.status(500).json({ message: 'Error al crear el libro', error: error.message });
    }
};

const getLibros = async (req, res) => {
    try {
        const useCase = new GetLibros(libroRepository);
        const libros = await useCase.execute();
        res.json(libros);
    } catch (error) {
        res.status(500).json({ message: 'Error al obtener los libros', error: error.message });
    }
};

module.exports = { createLibro, getLibros };  // Exportación con CommonJS
