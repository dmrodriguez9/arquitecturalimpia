-- para crear la tabla "autores"
CREATE TABLE autores (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- para crear la tabla "libros"
CREATE TABLE libros (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor_id INT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES autores(id)
);
