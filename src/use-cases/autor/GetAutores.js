module.exports = class GetAutores {
    constructor(autorRepository) {
        this.autorRepository = autorRepository;
    }

    execute() {
        return this.autorRepository.findAll();
    }
};
