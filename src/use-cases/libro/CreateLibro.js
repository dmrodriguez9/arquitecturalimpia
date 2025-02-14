const Libro = require('../../domain/entities/Libro');
module.exports = class CreateLibro {
    constructor(libroRepository) {
        this.libroRepository = libroRepository;
    }

    execute(data) {
        const libro = new Libro(Date.now(), data.titulo, data.autorId);
        return this.libroRepository.save(libro);
    }
};
