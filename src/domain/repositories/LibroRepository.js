import pool from '../../infrastructure/database.js';

class LibroRepository {
    async save(libro) {
        const query = 'INSERT INTO libros (titulo, autor_id) VALUES ($1, $2) RETURNING *';
        const values = [libro.titulo, libro.autorId];
        const result = await pool.query(query, values);
        return result.rows[0];
    }

    async findAll() {
        const result = await pool.query('SELECT * FROM libros');
        return result.rows;
    }
}

export default new LibroRepository();

