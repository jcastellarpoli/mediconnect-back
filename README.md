# back-centroMedico
Backend para centro medico Gerencia de proyectos

# Uso
Tener una db en mysql , se puede generar con el siguiente script:
```
CREATE DATABASE citasmedicas;
USE citasmedicas;

CREATE TABLE persona(
    id INT NOT NULL AUTO_INCREMENT,
    nombres VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    tipo_documento CHAR(3) NOT NULL,
    numero_documento INT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE doctor(
    id INT NOT NULL AUTO_INCREMENT,
    especialidad VARCHAR(45),
    nombres VARCHAR(45),
    apellidos VARCHAR(45),
    doctorcol VARCHAR(45),
    PRIMARY KEY(id)
)

CREATE TABLE cita(
    id INT NOT NULL AUTO_INCREMENT,
    fecha_hora datetime NOT NULL,
    tipo_cita VARCHAR(50) NOT NULL,
    doctor_id INT NOT NULL,
    persona_id INT NOT NULL,
    FOREIGN KEY(persona_id) REFERENCES persona(id),
    FOREIGN KEY(doctor_id) REFERENCES doctor(id)
);
```
Luego de esto se puede añadir registros a cada tabla como por ejemplo:
## Ejemplo insertar paciente

```
INSERT INTO persona(nombres,apellido,tipo_documento,numero_documento) VALUES
('Yonathan','Montilla','CC',12345);
```
##  Ejemplo insertar medico
```
INSERT INTO doctor(especialidad,nombres,apellido) VALUES
('Medicina General','Pedro','Gonzalez');
```
## Ejemplo insertar cita
```
INSERT INTO cita(fecha_hora,tipo_cita,doctor_id,paciente_id) VALUES
('2023-09-24 08:00:00','odontologia general',1,1);
```
# Pruebas
Para poder probar las peticiones se puede descargar el [archivo](https://github.com/black-warthex/back-centroMedico/blob/54a6e15343dbdcdce36f4a6d0716766a39b20f73/citasmedicas.postman_collection.json) e importar en postman:

