# Respueestaa Desafio 3 
#Prueba6

Este proyecto expone un API REST se conecta a otra API REST y entrega la siguiente información:

NOTA DE LA SOLUCION: Técnicamente para el conector a la api-periodos debiese haberse creado con un jar distinto que haga de conector, sin embargo, este fue programado simplemente
en un package distinto para mantener sencilla la prueba.

NOTA 1: Como pre-requisito se debe estar ejecutando la API api-periodos-1.0.0. 
NOTA 2: Se debe configurar en el archivo application.properties, ubicado en los resources del proyecto SpringBootRestApiTestPrevired los siguientes configs (Vienen configurados):

api-periodos-server=http://localhost:
api-periodos-port=8080
api-periodos-periodos=/periodos/api

*id*: identificador
*fechaCreacion*: Fecha de inicio de la secuencia
*fechaFin*: Fecha de fin de la secuencia
*fechas*: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin”
*fechasFaltantes*: Lista de fechas que faltan en la lista de fechas.
Ejemplo.
```json
{
    "id": 1,
    "fechaCreacion": "1994-03-01",
    "fechaFin": "2017-02-01",
    "fechas": [
        "1994-03-01",
        "1994-05-01",
        "1994-07-01",
        "1994-08-01",
        "1994-10-01",
        "1995-02-01",
        "1995-05-01",
        "1995-09-01",
        "1995-10-01",
        "1996-07-01",
        "1997-03-01",
        "1997-07-01",
        "1997-09-01",
        "1998-04-01",
        "1998-05-01",
        "1998-10-01",
        "1999-02-01",
        "1999-03-01",
        "1999-04-01",
        "1999-05-01",
        "1999-07-01",
        "1999-11-01",
        "1999-12-01",
        "2000-05-01",
        "2000-06-01",
        "2000-07-01",
        "2000-11-01",
        "2001-01-01",
        "2001-04-01",
        "2001-05-01",
        "2001-09-01",
        "2001-11-01",
        "2002-02-01",
        "2002-04-01",
        "2002-10-01",
        "2002-11-01",
        "2003-03-01",
        "2003-04-01",
        "2003-05-01",
        "2003-06-01",
        "2004-01-01",
        "2004-04-01",
        "2004-12-01",
        "2005-04-01",
        "2005-05-01",
        "2005-07-01",
        "2005-11-01",
        "2005-12-01",
        "2006-01-01",
        "2006-05-01",
        "2006-11-01",
        "2006-12-01",
        "2007-05-01",
        "2007-07-01",
        "2007-08-01",
        "2008-01-01",
        "2008-03-01",
        "2008-05-01",
        "2008-06-01",
        "2008-07-01",
        "2008-09-01",
        "2008-12-01",
        "2009-01-01",
        "2009-02-01",
        "2009-03-01",
        "2009-08-01",
        "2009-12-01",
        "2010-01-01",
        "2010-05-01",
        "2010-07-01",
        "2010-08-01",
        "2010-09-01",
        "2010-10-01",
        "2010-11-01",
        "2011-03-01",
        "2011-06-01",
        "2011-07-01",
        "2011-09-01",
        "2011-10-01",
        "2012-01-01",
        "2012-03-01",
        "2012-10-01",
        "2012-12-01",
        "2013-02-01",
        "2013-06-01",
        "2013-11-01",
        "2014-02-01",
        "2014-03-01",
        "2014-04-01",
        "2014-10-01",
        "2014-12-01",
        "2015-05-01",
        "2015-06-01",
        "2015-08-01",
        "2015-10-01",
        "2016-02-01",
        "2016-04-01",
        "2016-05-01"
    ],
    "fechasFaltantes": [
        "1994-04-01",
        "1994-06-01",
        "1994-09-01",
        "1994-11-01",
        "1994-12-01",
        "1995-01-01",
        "1995-03-01",
        "1995-04-01",
        "1995-06-01",
        "1995-07-01",
        "1995-08-01",
        "1995-11-01",
        "1995-12-01",
        "1996-01-01",
        "1996-02-01",
        "1996-03-01",
        "1996-04-01",
        "1996-05-01",
        "1996-06-01",
        "1996-08-01",
        "1996-09-01",
        "1996-10-01",
        "1996-11-01",
        "1996-12-01",
        "1997-01-01",
        "1997-02-01",
        "1997-04-01",
        "1997-05-01",
        "1997-06-01",
        "1997-08-01",
        "1997-10-01",
        "1997-11-01",
        "1997-12-01",
        "1998-01-01",
        "1998-02-01",
        "1998-03-01",
        "1998-06-01",
        "1998-07-01",
        "1998-08-01",
        "1998-09-01",
        "1998-11-01",
        "1998-12-01",
        "1999-01-01",
        "1999-06-01",
        "1999-08-01",
        "1999-09-01",
        "1999-10-01",
        "2000-01-01",
        "2000-02-01",
        "2000-03-01",
        "2000-04-01",
        "2000-08-01",
        "2000-09-01",
        "2000-10-01",
        "2000-12-01",
        "2001-02-01",
        "2001-03-01",
        "2001-06-01",
        "2001-07-01",
        "2001-08-01",
        "2001-10-01",
        "2001-12-01",
        "2002-01-01",
        "2002-03-01",
        "2002-05-01",
        "2002-06-01",
        "2002-07-01",
        "2002-08-01",
        "2002-09-01",
        "2002-12-01",
        "2003-01-01",
        "2003-02-01",
        "2003-07-01",
        "2003-08-01",
        "2003-09-01",
        "2003-10-01",
        "2003-11-01",
        "2003-12-01",
        "2004-02-01",
        "2004-03-01",
        "2004-05-01",
        "2004-06-01",
        "2004-07-01",
        "2004-08-01",
        "2004-09-01",
        "2004-10-01",
        "2004-11-01",
        "2005-01-01",
        "2005-02-01",
        "2005-03-01",
        "2005-06-01",
        "2005-08-01",
        "2005-09-01",
        "2005-10-01",
        "2006-02-01",
        "2006-03-01",
        "2006-04-01",
        "2006-06-01",
        "2006-07-01",
        "2006-08-01",
        "2006-09-01",
        "2006-10-01",
        "2007-01-01",
        "2007-02-01",
        "2007-03-01",
        "2007-04-01",
        "2007-06-01",
        "2007-09-01",
        "2007-10-01",
        "2007-11-01",
        "2007-12-01",
        "2008-02-01",
        "2008-04-01",
        "2008-08-01",
        "2008-10-01",
        "2008-11-01",
        "2009-04-01",
        "2009-05-01",
        "2009-06-01",
        "2009-07-01",
        "2009-09-01",
        "2009-10-01",
        "2009-11-01",
        "2010-02-01",
        "2010-03-01",
        "2010-04-01",
        "2010-06-01",
        "2010-12-01",
        "2011-01-01",
        "2011-02-01",
        "2011-04-01",
        "2011-05-01",
        "2011-08-01",
        "2011-11-01",
        "2011-12-01",
        "2012-02-01",
        "2012-04-01",
        "2012-05-01",
        "2012-06-01",
        "2012-07-01",
        "2012-08-01",
        "2012-09-01",
        "2012-11-01",
        "2013-01-01",
        "2013-03-01",
        "2013-04-01",
        "2013-05-01",
        "2013-07-01",
        "2013-08-01",
        "2013-09-01",
        "2013-10-01",
        "2013-12-01",
        "2014-01-01",
        "2014-05-01",
        "2014-06-01",
        "2014-07-01",
        "2014-08-01",
        "2014-09-01",
        "2014-11-01",
        "2015-01-01",
        "2015-02-01",
        "2015-03-01",
        "2015-04-01",
        "2015-07-01",
        "2015-09-01",
        "2015-11-01",
        "2015-12-01",
        "2016-01-01",
        "2016-03-01",
        "2016-06-01",
        "2016-07-01",
        "2016-08-01",
        "2016-09-01",
        "2016-10-01",
        "2016-11-01",
        "2016-12-01",
        "2017-01-01",
        "2017-02-01"
    ]
}
```
# Compilar y ejecutar el proyecto

Para copilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio *SpringBootRestApiTestPrevired* ejecutar el siguiente comando *maven*

```bash
mvn package
```

Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar .\SpringBootRestApiTestPrevired-1.0.0.jar
```
*Nota*:
Debe estar disponible el puerto *8180* en el PC donde se ejecute esta API

# Probar

La documentación swagger del API (una vez que se levanta el API) queda disponible en

http://127.0.0.1:8180/periodos/swagger-ui.html#/

Para consumir el servicio se debe invocar la siguiente URL

```bash
curl -X GET --header 'Accept: application/json' 'http://localhost:8180/periodos/api'
```

# Probar con otros clientes

Se puede utilizar SOAP UI o POSTMAN para el envío de la petición del tipo GET configurado el request con los headers 'Accept: application/json'

URL: http://localhost:8180/periodos/api


