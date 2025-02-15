const CreateAutor = require('../use-cases/autor/CreateAutor');
const GetAutores = require('../use-cases/autor/GetAutores');
const autorRepository = require('../domain/repositories/AutorRepository');

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

// Se exporta utilizando CommonJS
module.exports = { createAutor, getAutores };
