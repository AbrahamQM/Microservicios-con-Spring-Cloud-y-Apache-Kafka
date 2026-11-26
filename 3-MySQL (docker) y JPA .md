\--------------------------------------------------------------------------------------------

\--------------INSTALACION DE MYSQL Y EJECUCION DE CONTENEDOR---------------

\--------------------------------------------------------------------------------------------



\-- descargamos la imagen con 

*docker pull  mysql:latest*



\--INSTANCIACIÓN CONTENEDOR PERSONALZADO 

\---detached, nombre de la imagen "mysql",

\--- reiniciar siempre, puerto 3306, 

\---Variables de entorno (credenciales)

\---imagen y versión específica de imagen



*docker run -d --name mysql `*

*--restart always -p 3306 `*

*-e MYSQL\_ROOT\_PASSWORD=pass1234 `*

*-e MYSQL\_ROOT\_USER=db\_spring\_kafka `*

*mysql:latest*



\---Devuelve el identificador de la instancia

*58a17e7f9aba0315c81e4fbecb1497abec95f04e94a8e390d37dea1be91796aa*





