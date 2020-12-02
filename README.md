[![codecov](https://codecov.io/gh/jorgerolon1998/MercadoLibre/branch/master/graph/badge.svg)](https://codecov.io/gh/jorgerolon1998/MercadoLibre)
# Challenge: Api Rest Detector de Mutantes

API Rest para detectar si un humano es mutante o no en base a su DNA. 

_________________________________________________

## Uso de API

### Servicio que detecta si es un mutante o no: 

Recibe como parámetro una secuencia de ADN, representada por un array de strings, y responde si la misma pertenece, o no, a un mutante. Se almacena la secuencia consultada en una base de datos, con el propósito de obtener estadísticas. 

- **URL:**

- **Method:** POST

- **Body:** JSON ADN:

  * Recordar que cada string debe tener la misma longitud que el array al que pertenece es decir que la secuencia solo puede ser NxN. Además la secuencia solo puede contener los siguentes caracteres; A, T, C, G. Caso contrario fallará y se vera en el detalle la razon del problema


  ```javascript
  {"dna": [[string], [string], [string], ...]}
  ```
  Ejemplo:

  ```javascript
  {"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}
  ``` 
 - **Respuestas Posibles:** 
  
    - 200: El humano es mutante. 
    - 403: El humano no es mutante.
    - 400: Input incorrecto. 
    

### Servicio que devuelve la estadisticas de mutantes:

Devuelve estadísticas en base a las secuencias de ADN que han sido consultadas. 

- **URL:**

- **Method:** GET

- **Respuesta:** 

  ```javascript
  {
    "count_mutant_dna": [number],
    "count_human_dna": [number],
    "ratio": [number]
  }
  ```
  **Donde [number] es el valor de los resultados**
_________________________________________________

## Uso de Proyecto Para Colaboradores

## Herramientas necesarias:

GIT

Maven

Java (1.8)

Eclipse (opcional)

## Descargando el repositorio:

git clone https://github.com/jorgerolon1998/MercadoLibre.git

## Para ejecutar la aplicacion utilizando Maven:

mvn clean install (instalar dependencias)

mvn spring-boot:run (levantar aplicacion, revisar que el puerto 8080 no este siendo usado)

Proyecto:

Es una api rest desarrollada con spring boot. Tiene su base de datos embebida.

Link de collection Postman https://www.getpostman.com/collections/e7335d9ce8205e5db3b2



