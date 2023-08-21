# APLICACIONES DISTRIBUIDAS (HTTP, SOCKETS, HTML, JS,MAVEN, GIT)

Una aplicacion para consultar los datos de la pelicula de cine deseada. La busqueda se hace por titulo, utilizando el API "omdbapi.com" e implementando cache.

## Instrucciones para ejecutar

A continuacion, dejo respectivas instrucciones para correr el proyecto adecuadamente tras obtener la direccion a este repositorio GitHub. Igualmente, mas abajo dejare evidencia detallada para garantizar que se entienda su implementacion. La aplicacion debe usarse para fines de prueba y desarrollo.

### Requisitos previos

Para descargar la aplicacion, ya estando aqui, se necesita un equipo de computo con las siguientes caracteristicas:

```
- Java instalado

- Maven instalado

- JavaScript instalado

- Conexion a internet

- Explorador web

- (OPCIONAL) Personal API key Omdbapi

- (RECOMENDACION) Tener todo actualizado
```
Esta guia no incluye tutoria para la descarga e instalacion de los anteriores mencionados. Si no cuenta con algo, o no sabe, le recomiendo ver algun video en Youtube.

### Instalando

Paso a paso

```
1. Descargar el codigo: Bajar el .ZIP correspondiente al repositorio.

2. Extraer el contenido del archivo comprimido.

3. Abrir el Shell de su preferencia.

4. Desde el Shell, muevase a la ubicacion donde extrajo el archivo .ZIP (Deberia estar dentro de la carpeta llamada  "ARQUITECTURAS-EMPRESARIALES-TALLER-1-master").

5. Desde el Shell, escriba "mvn package" (este comando compila, construye y empaqueta el proyecto en un .JAR).

6. Desde el Shell, escriba "java -cp target/Taller1-1.0-SNAPSHOT.jar edu.escuelaing.app.App" para ejecutar la aplicacion.
   Deberia ver un mensaje diciendo "Listo para recibir... ".

7. Abra su explorador web de preferencia y busque en una pestaña incognita lo siguiente: "localhost:35001" (SIN LAS COMILLAS).

8. Entonces, tendra acceso a un software que le permite consultar toda la informacion de peliculas relacionada al cine.

9. Para hacerlo, debe buscar la pelicula que le interesa por su titulo original, el cual muy seguramente este escrito en ingles, y posteriormente debe pulsar sobre el
   boton "Submit" para enviar la solicitud al API de la pelicula que busca.
   En pantalla podra ver toda la informacion que el API pudo proveer sobre su eleccion.
```

Puede hacer cuantas consultas quiera. Para cerrar el servicio puede introducir en el campo de texto cualquier cadena que inicie con un espacio en blanco, por ejemplo " _", y el servidor se apagara enseguida. 

```
Una vez haya terminado, puede cerrar el servicio introduciendo en el campo de texto " _" y el servidor se apagara enseguida.

```

¡¡"Oppenheimer" salio apenas hace unas semanas a las salas de cine, pero la API ya puede obtener todos sus datos!!

## Ejecucion de las pruebas

La aplicacion cuenta con pruebas automaiza

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

