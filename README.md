# TallerJDBC

Crear una base de datos con la tabla estudiantes, esa tabla tiene los siguientes campos:

1. id de tipo numeric y va se auto numérico y llave primaria
2. campo nombre, apellido en strings
3. campo correo que debe ser único (no puede existir el correo 2 veces)
4. campo edad de tipo numérico
5. campo estado civil que usara una numeración Enum (SOLTERO, CASADO, VIUDO, UNION_LIBRE, DIVORCIADO)

Realizar el CRUD de la tabla: crear, actualizar, eliminar y consultar todos los estudiantes y consultar el estudiante por el correo
electronico.

Realizar un Menu con las siguientes opciones:

1. Insertar Estudiante
2. Actualizar Estudiante (solo se puede actualizar nombre, apellido, edad y estado civil)
3. Eliminar Estudiante
4. Consultar todos los estudiantes (imprimir todos los campos)
5. Consultar Estudiante por email
6. Salir del programa
