# Automation Example TYBA

    Proyecto creado teniendo en cuenta el ejemplo enviado por Tyba, teniendo en cuenta las especificaciones dadas y los
    requerimientos solicitados por el cliente se realiza la implementación con la herramienta de automatización Serenity
    ya que nos permite implementar test tanto de FrontEnd como BackEnd.

    Se realiza la implementación utilizando un patron de diseño ScreenPlay y Builder los cuales nos facilitan tanto la 
    ejecución como la codificación del mismo. 

    El test implementado se encarga de ejecutar los pasos:
    - Abrir el navegador y redireccionar a la página ejemplo
    - Redireccionar al formulario de registro
    - Llenar formulario y validar que el usuario se mantenga en sesión
    - Redireccionar a la sección de articulos populares y agregar tres items
    - Ingresar al carro y validar que los items se encuentren asociados correctamente
    - Acceder y finalizar el pago validando montos

## Comando para ejecutar test con gradle

    Ejecute desde un terminal:

    gradlew clean test smoke
    gradlew clean test 

## Si se quiere ejecutar por tags puede utilizar

    gradlew clean test -Dtags='smoke'

## Enviar navegador para ejecutar

    Por defecto el driver viene configurado para ejecutar en chrome, pero si se quiere cambiar de navegador 
    se puede hacer con el comando
        
    gradlew clean test -Dwebdriver.driver=firefox


## Enviar comando para ejecutar en servidor remoto

    ./gradlew clean test -Dtags='smoke' -Dwebdriver.remote.url=http://host:4444/wd/hub 
    -Dwebdriver.remote.driver=chrome


## Reporte de ejecución

    Para visualizar el reporte generado se puede acceder a la ruta dentro del proyecto `target/site/serenity` 
    archivo index.html

## Librerías principales utilizadas

    - Serenity 3.2.5
    - Selenium 4.1.4
    - JUnit 5.9.0
    - RestAssured 5.1.1
    - Lombok 1.18.24
    
