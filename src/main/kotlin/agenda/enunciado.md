## 5.3 Refuerzo y ampliación en POO y uso de Colleciones

* Crear un programa para gestionar una agenda de contactos. El funcionamiento será el siguiente:

- El programa pedirá introducir algo por teclado:
  o Si se introduce un número de teléfono comprobará si existe, si es así mostrará a quién pertenece. Si no existe pedirá el nombre del contacto para darlo de alta.

* Si se introduce un contacto debe comprobar si existe, si es así mostrará el número de teléfono. Si no existe pedirá el número de teléfono para darlo de alta.

- Debe reconocer números de teléfono con espacios entre los dígitos o no y con el símbolo + al principio para indicar prefijo de país.
- Los nombres deben comenzar por letras y pueden contener números y caracteres especiales imprimibles.

- Comandos especiales:
  * adios: Sale del programa
  * listado: Muestra el listado completo de contactos ordenados por nombre
  * filtra texto_a_buscar: Muestra el listado de los contactos que contengan texto_a_buscar o “Ningún
  contacto” si no hubiera ninguno.

- Se deben crear funciones cuando sea adecuado (por ejemplo, comprobar si existe un contacto en la agenda, comprobar si un texto puede ser un número de teléfono, etc).