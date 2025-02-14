const Autor = require('../../domain/entities/Autor');
module.exports = class CreateAutor {
    constructor(autorRepository) {
        this.autorRepository = autorRepository;
    }

    execute(data) {
        const autor = new Autor(Date.now(), data.nombre);
        return this.autorRepository.save(autor);
    }
};
