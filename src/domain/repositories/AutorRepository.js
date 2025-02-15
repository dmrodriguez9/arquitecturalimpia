const pool = require('../../infrastructure/database.js');

class AutorRepository {
    async save(autor) {
        const query = 'INSERT INTO autores (nombre) VALUES ($1) RETURNING *';
        const values = [autor.nombre];
        const result = await pool.query(query, values);
        return result.rows[0]; // Devuelve el autor insertado
    }

    async findAll() {
        const result = await pool.query('SELECT * FROM autores');
        return result.rows; // Devuelve todos los autores
    }

    async findById(id) {
        const query = 'SELECT * FROM autores WHERE id = $1';
        const values = [id];
        const result = await pool.query(query, values);
        return result.rows[0] || null; // Devuelve el autor encontrado o null si no existe
    }

    async update(id, autor) {
        const query = 'UPDATE autores SET nombre = $1 WHERE id = $2 RETURNING *';
        const values = [autor.nombre, id];
        const result = await pool.query(query, values);
        return result.rows[0] || null; // Devuelve el autor actualizado o null si no existe
    }

    async delete(id) {
        const query = 'DELETE FROM autores WHERE id = $1 RETURNING *';
        const values = [id];
        const result = await pool.query(query, values);
        return result.rows[0] || null; // Devuelve el autor eliminado o null si no existe
    }
}

// Cambiar 'export default' por 'module.exports'
module.exports = new AutorRepository();
