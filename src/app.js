import express from 'express';
import cors from 'cors';
import routes from 'routes.js'; // Asegúrate de que 'routes.js' esté en la misma carpeta o ajusta la ruta

const app = express();
app.use(cors());
app.use(express.json());

app.use('/api', routes);

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`Servidor corriendo en http://localhost:${PORT}`));
