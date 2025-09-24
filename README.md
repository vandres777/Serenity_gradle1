# Proyecto de Automatización de Pruebas con Serenity BDD y Gradle

Este es un proyecto de ejemplo para la automatización de pruebas de interfaz de usuario (UI) web utilizando Serenity BDD, Java y Gradle.

El proyecto está configurado para ejecutar pruebas de ejemplo que demuestran las características de Serenity BDD, incluyendo el patrón Screenplay.

## Tecnologías Utilizadas

*   **Java:** Lenguaje de programación principal.
*   **Gradle:** Herramienta de automatización de compilación.
*   **Serenity BDD:** Framework de pruebas para escribir pruebas de aceptación y regresión automatizadas de alta calidad.
*   **JUnit 5:** Framework de pruebas para ejecutar las pruebas.

## Prerrequisitos

*   JDK 11 o superior.
*   Git (opcional, para clonar el repositorio).


2.  **Compila el proyecto:**
    El wrapper de Gradle (`gradlew`) descargará la versión correcta de Gradle y todas las dependencias necesarias la primera vez que ejecutes una tarea.

## Ejecutar las Pruebas

Para ejecutar las pruebas de Serenity, abre una terminal en el directorio raíz del proyecto y utiliza el siguiente comando:


Ejecuta las pruebas sin generar informes:

	./gradlew clean test  

Ejecuta las pruebas y genera los informes de Serenity:

	./gradlew clean test aggregate 

Este comando realizará las siguientes acciones:
*   `clean`: Limpia los resultados de compilaciones anteriores.
*   `test`: Compila el código fuente y ejecuta las pruebas automatizadas.

## Ver los Informes de Pruebas

Después de que las pruebas se hayan ejecutado, Serenity BDD genera un informe de prueba detallado y vivo.

Puedes encontrar el informe abriendo el siguiente archivo en tu navegador web:
`target/site/serenity/index.html`

Este informe proporciona un desglose de los resultados de las pruebas, incluyendo los pasos ejecutados, capturas de pantalla y el resultado de cada prueba.

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