CREATE DATABASE appointments; --- Creación de una base de datos
use appointments; 
CREATE USER 'appointmetUser'@'%' IDENTIFIED BY 'appointment1234'; --- Crear usuario para la base de datos recien creada
GRANT ALL ON appointments.* TO 'appointmetUser'@'%'; --- Darle todos los privilegios al usuario recien creado