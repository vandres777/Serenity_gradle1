# Proyecto de Automatización de Pruebas con Serenity BDD y Gradle

Este es un proyecto de ejemplo para la automatización de pruebas de interfaz de usuario (UI) web utilizando Serenity BDD, Java y Gradle.

Este proyecto de demostración automatiza pruebas para el sitio web DuckDuckGo. Utiliza el patrón Screenplay para simular a un usuario buscando términos y verificando los resultados, mostrando las capacidades de Serenity BDD para generar informes de prueba claros y detallados.

## Tecnologías Utilizadas

*   **Java:** Lenguaje de programación principal.
*   **Gradle:** Herramienta de automatización de compilación.
*   **Serenity BDD:** Framework de pruebas para escribir pruebas de aceptación y regresión automatizadas de alta calidad.
*   **JUnit 5:** Framework de pruebas para ejecutar las pruebas.

## Prerrequisitos

*   JDK 11 o superior.

2.  **Compila el proyecto:**
    El wrapper de Gradle (`gradlew`) descargará la versión correcta de Gradle y todas las dependencias necesarias la primera vez que ejecutes una tarea.

## Ejecutar las Pruebas

Para ejecutar las pruebas de Serenity, abre una terminal en el directorio raíz del proyecto y utiliza el siguiente comando:


Ejecuta las pruebas sin generar informes:

	./gradlew clean test  

Ejecuta las pruebas y genera los informes de Serenity (por defecto se ejecuta en google chrome):

	./gradlew clean test aggregate 

Puedes especificar el navegador en el que deseas ejecutar las pruebas utilizando la propiedad `-Denvironment`. Los valores posibles son `chrome` y `edge`. Por ejemplo:
    
    ./gradlew clean test -Denvironment=chrome

    ./gradlew clean test -Denvironment=edge

    gradle clean test -Ddriver=firefox


## Ver los Informes de Pruebas

Después de que las pruebas se hayan ejecutado, Serenity BDD genera un informe de prueba detallado y vivo.

Puedes encontrar el informe abriendo el siguiente archivo en tu navegador web:
`target/site/serenity/index.html`

Este informe proporciona un desglose de los resultados de las pruebas, incluyendo los pasos ejecutados, capturas de pantalla y el resultado de cada prueba.

## Navegador Utilizado

El navegador configurado para las pruebas es Google Chrome. 
Desde artchivo `serenity.conf` puedes cambiar la configuración para que este pueda ejecutarse en modo headless o en otro navegador compatible.


## Configuración de archivo serenity.conf

El archivo `serenity.conf` es el fichero de configuración principal que utiliza el formato HOCON. En este proyecto, define aspectos cruciales para la ejecución de las pruebas, tales como:
*   El navegador a utilizar (Chrome) y sus configuraciones específicas (argumentos de inicio, modo headless, etc.).
*   La URL base del entorno de pruebas (https://duckduckgo.com).
*   Tiempos de espera (timeouts) para la interacción con elementos web.
*   Comportamiento de Serenity, como la toma de capturas de pantalla y el nivel de detalle de los logs.

## Configuración de archivo serenity.properties

El archivo `serenity.properties` se utiliza para personalizar los metadatos del informe de pruebas de Serenity. En este proyecto, se emplea para añadir campos personalizados al reporte, como la versión de la aplicación, el ambiente (QA), el squad y el usuario que ejecuta las pruebas, enriqueciendo así la información de cada ejecución.

## Estructura del Proyecto

```
src
├───main      # Código fuente de la aplicación (si aplica)
└───test
    ├───java
    │   └───com
    │       └───example
    │           ├───config      # Clases de configuración (ej. WebDriver)
    │           ├───runners     # Clases "Runner" para ejecutar las pruebas
    │           ├───tasks       # Tareas del patrón Screenplay
    │           └───ui          # Elementos de la interfaz de usuario (Page Objects)
    └───resources
        ├───serenity.conf # Configuración principal de Serenity
        └───features      # Archivos de características de Cucumber (si se usan)
```