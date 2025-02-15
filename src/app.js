const express = require('express');
const routes = require('./routes');  // Usa './routes' sin la extensión .js

const app = express();

app.use(express.json());
app.use('/api', routes);

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`Servidor corriendo en http://localhost:${PORT}`));
