module.exports = class GetLibros {
    constructor(libroRepository) {
        this.libroRepository = libroRepository;
    }

    execute() {
        return this.libroRepository.findAll();
    }
};
