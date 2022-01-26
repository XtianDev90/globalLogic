# GlobalLogic Ejercicio JAVA

_Ejercicio BCI para registrar un usuario, obtener un id de tipo UUDI y obtener un usuario por su codigo UUDI_

## Comenzando 

_Descargar proyecto desde repositorio_

```
$ git clone https://github.com/XtianDev90/globalLogic.git
$ cd globalLogic/
$ cd globalLogic/
```
_Luego para compilar desde una ventana de comando en la carpeta del proyecto_

```
$ gradle build
```

_Arrancamos la aplicacion en la carpeta que se genera el Jar_

```
$ cd build/libs
$ java -jar .\globalLogic-0.0.1-SNAPSHOT.jar
```

### Pre-requisitos 

_Programas y versiones_

```
Postman
Java 8
Gradle 7.3.3
Spring Tool Suite 4
H2
Lombok
```

### Ejecucion 

_En la carpeta Documentos se encuentra la coleccion para las pruebas de la API_

```
globalLogic.postman_collection
```

_La coleccion tiene los request para "sign-up" y "login", ademas de 2 endpoint de prueba "hello" y "users"_
_Tambien se puede ejecutar en una ventana de comando_

```
curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"Admin\",\"email\":\"Prueba@Dominio.cl\",\"password\":\"a2asfGfdfdf4\",\"phones\": [{\"number\":974524787,\"citycode\":11,\"contrycode\":\"13\"}]}" "http://localhost:8080/api/v1/sign-up"
```
_Resultado_

```
{"id":"943b15e6-a4d8-4afa-baba-a973031bb0e5","name":"ADMIN","email":"PRUEBA@DOMINIO.CL","password":"a2asfGfdfdf4","phones":[{"idPhone":33,"number":974524787,"citycode":11,"contrycode":"13"}],"created":"2022-01-25T20:47:46.05","lastLogin":"2022-01-25T20:47:46.05","token":"Falta implementar generador de token JWT","active":false}
```

_Despues de crear el registro se puede consultar con el UUDI que retorno "id":"943b15e6-a4d8-4afa-baba-a973031bb0e5"_
```
curl -X GET -H "Content-Type:application/json"  "http://localhost:8080/api/v1/login/943b15e6-a4d8-4afa-baba-a973031bb0e5"
```
_Resultado_

```
{"id":"943b15e6-a4d8-4afa-baba-a973031bb0e5","name":"ADMIN","email":"PRUEBA@DOMINIO.CL","password":"a2asfGfdfdf4","phones":[{"idPhone":33,"number":974524787,"citycode":11,"contrycode":"13"}],"created":"2022-01-25T20:47:46.05","lastLogin":"2022-01-25T20:47:46.05","token":"Falta implementar generador de token JWT","active":false}
```

## Ejecutando las pruebas 

_Explica como ejecutar las pruebas automatizadas para este sistema_
