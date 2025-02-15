const { Pool } = require('pg');  // Usamos 'require' en lugar de 'import'

const pool = new Pool({
    host: 'localhost',
    port: 5432,
    user: 'postgres',
    password: 'admin',
    database: 'arquitecturalimpia',
});

// Cambiar 'export default' por 'module.exports'
module.exports = pool;
