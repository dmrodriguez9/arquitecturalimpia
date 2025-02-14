import CreateLibro from '../use-cases/libro/CreateLibro.js';
import GetLibros from '../use-cases/libro/GetLibros.js';
import libroRepository from '../domain/repositories/LibroRepository.js';

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

export { createLibro, getLibros };
