import CreateAutor from '../use-cases/autor/CreateAutor.js';
import GetAutores from '../use-cases/autor/GetAutores.js';
import autorRepository from '../domain/repositories/AutorRepository.js';

const createAutor = async (req, res) => {
    try {
        const useCase = new CreateAutor(autorRepository);
        const autor = await useCase.execute(req.body);
        res.status(201).json(autor);
    } catch (error) {
        res.status(500).json({ message: 'Error al crear el autor', error: error.message });
    }
};

const getAutores = async (req, res) => {
    try {
        const useCase = new GetAutores(autorRepository);
        const autores = await useCase.execute();
        res.json(autores);
    } catch (error) {
        res.status(500).json({ message: 'Error al obtener los autores', error: error.message });
    }
};

export { createAutor, getAutores };
