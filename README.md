
# Generador de Fechas faltantes desafio uno

la app tiene la funcion de consultar en el generador de datos 
(facilitado desde https://github.com/lmptechconsult/Generador_Datos_Desafio_Uno)
se recomienda acceder y ejecutar para el correcto funcionamiento de la presente aplicacion

# Detalle de los sistemas
SpringFox-Swagger2 2.9.2 Java 8 Spring-Boot 2.6.7.RELEASE Maven 3

# Compilar y ejecutar el proyecto

Para copilar el proyecto se requiere Java y Maven instalado.
Para ejecutar el proyeto se requiere de tener el proyecto *ApiPeriodos* corriendo en el puerto 8080
Ingresar al directorio *DesafioUno* ejecutar el siguiente comando *maven*

```bash
mvn package
```
Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar .\desafiouno-0.0.1-SNAPSHOT.jar --server.port=8090
```

la app se inicia en el puerto 8090 para evitar modificar el proyecto que hace entrega de la informacion
Por lo tanto se requeriran de los puertos 8080 y 8090 para la ejecucion

# Visualizar Documentación y consumir la API
La documentación swagger del API (una vez que se levanta el API) queda disponible en

http://localhost:8090/swagger-ui.html

Para consumir el servicio se debe invocar la siguiente URL

curl -X GET --header 'Accept: application/json' 'http://localhost:8090/desafio_uno/fechasFaltantes'

# Ultimos detalles
se probó a realizar la implementación del desafio uno con localDate, sin embargo y por problemas con el rendimiento se realizo una modificacion que contempla el uso de variables como String para poder hacer un implementacion más ligera.

# ejemplo de respuesta
```bash
{
    "id":1,
    "fechaCreacion":"2000-08-01",
    "fechaFin":"2015-11-01",
    "fechas":[
        "2000-08-01",
        "2000-10-01",
        "2000-11-01",
        "2001-01-01",
        "2001-02-01",
        "2001-03-01",
        "2001-04-01",
        "2001-11-01",
        "2002-04-01",
        "2002-07-01",
        "2002-10-01",
        "2002-11-01",
        "2003-02-01",
        "2003-04-01",
        "2003-05-01",
        "2003-07-01",
        "2003-09-01",
        "2003-12-01",
        "2004-01-01",
        "2004-02-01",
        "2004-03-01",
        "2004-05-01",
        "2004-06-01",
        "2004-08-01",
        "2004-09-01",
        "2004-10-01",
        "2004-11-01",
        "2005-04-01",
        "2005-05-01",
        "2005-07-01",
        "2005-10-01",
        "2005-11-01",
        "2005-12-01",
        "2006-01-01",
        "2006-03-01",
        "2006-04-01",
        "2006-05-01",
        "2006-06-01",
        "2006-09-01",
        "2006-11-01",
        "2007-01-01",
        "2007-04-01",
        "2007-05-01",
        "2007-09-01",
        "2007-10-01",
        "2007-11-01",
        "2008-01-01",
        "2008-02-01",
        "2008-04-01",
        "2008-06-01",
        "2008-08-01",
        "2008-12-01",
        "2009-01-01",
        "2009-02-01",
        "2009-04-01",
        "2009-06-01",
        "2009-09-01",
        "2009-11-01",
        "2009-12-01",
        "2010-03-01",
        "2010-04-01",
        "2010-05-01",
        "2010-06-01",
        "2010-08-01",
        "2010-11-01",
        "2010-12-01",
        "2011-01-01",
        "2011-02-01",
        "2011-03-01",
        "2011-05-01",
        "2011-07-01",
        "2011-08-01",
        "2011-09-01",
        "2011-10-01",
        "2011-11-01",
        "2011-12-01",
        "2012-01-01",
        "2012-02-01",
        "2012-06-01",
        "2012-07-01",
        "2012-08-01",
        "2012-09-01",
        "2012-10-01",
        "2012-12-01",
        "2013-03-01",
        "2013-04-01",
        "2013-05-01",
        "2013-10-01",
        "2013-11-01",
        "2014-01-01",
        "2014-03-01",
        "2014-04-01",
        "2014-07-01",
        "2014-08-01",
        "2014-09-01",
        "2014-10-01",
        "2014-12-01",
        "2015-01-01",
        "2015-02-01",
        "2015-03-01",
        "2015-07-01",
        "2015-09-01",
        "2015-11-01"
    ],
    "fechasFaltantes":[
        "2000-09-01",
        "2000-12-01",
        "2001-05-01",
        "2001-06-01",
        "2001-07-01",
        "2001-08-01",
        "2001-09-01",
        "2001-10-01",
        "2001-12-01",
        "2002-01-01",
        "2002-02-01",
        "2002-03-01",
        "2002-05-01",
        "2002-06-01",
        "2002-08-01",
        "2002-09-01",
        "2002-12-01",
        "2003-01-01",
        "2003-03-01",
        "2003-06-01",
        "2003-08-01",
        "2003-10-01",
        "2003-11-01",
        "2004-04-01",
        "2004-07-01",
        "2004-12-01",
        "2005-01-01",
        "2005-02-01",
        "2005-03-01",
        "2005-06-01",
        "2005-08-01",
        "2005-09-01",
        "2006-02-01",
        "2006-07-01",
        "2006-08-01",
        "2006-10-01",
        "2006-12-01",
        "2007-02-01",
        "2007-03-01",
        "2007-06-01",
        "2007-07-01",
        "2007-08-01",
        "2007-12-01",
        "2008-03-01",
        "2008-05-01",
        "2008-07-01",
        "2008-09-01",
        "2008-10-01",
        "2008-11-01",
        "2009-03-01",
        "2009-05-01",
        "2009-07-01",
        "2009-08-01",
        "2009-10-01",
        "2010-01-01",
        "2010-02-01",
        "2010-07-01",
        "2010-09-01",
        "2010-10-01",
        "2011-04-01",
        "2011-06-01",
        "2012-03-01",
        "2012-04-01",
        "2012-05-01",
        "2012-11-01",
        "2013-01-01",
        "2013-02-01",
        "2013-06-01",
        "2013-07-01",
        "2013-08-01",
        "2013-09-01",
        "2013-12-01",
        "2014-02-01",
        "2014-05-01",
        "2014-06-01",
        "2014-11-01",
        "2015-04-01",
        "2015-05-01",
        "2015-06-01",
        "2015-08-01",
        "2015-10-01"
    ]
}
```
