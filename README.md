
# Project Title

A brief description of what this project does and who it's for


# 🚀Proyecto de Automatización de Pruebas con Serenity BDD y Gradle

Este es un proyecto de ejemplo para la automatización de pruebas de interfaz de usuario (UI) web utilizando Serenity BDD, Java y Gradle.

Este proyecto de demostración automatiza pruebas para el sitio web DuckDuckGo. Utiliza el patrón Screenplay para simular a un usuario buscando términos y verificando los resultados, mostrando las capacidades de Serenity BDD para generar informes de prueba claros y detallados.

## Tecnologías Utilizadas

*   **Java:** Lenguaje de programación principal.
*   **Gradle:** Herramienta de automatización de compilación.
*   **Serenity BDD:** Framework de pruebas para escribir pruebas de aceptación y regresión automatizadas de alta calidad.
*   **JUnit 5:** Framework de pruebas para ejecutar las pruebas.

## Prerrequisitos

*  JDK 11 o superior.
*  Gradle instalado (opcional, ya que el proyecto incluye el wrapper de Gradle).
*  Navegador Google Chrome instalado (u otro navegador compatible si se configura).
*  IDE recomendado: IntelliJ IDEA, Eclipse o cualquier editor de texto.

## Ejecutar todo el proyecto

Para ejecutar las pruebas de Serenity, abre una terminal en el directorio raíz del proyecto y aplica algunos de los siguientes comandos de termnal.


Ejecuta las pruebas y genera los informes de Serenity (por defecto se ejecuta en Google Chrome):

	./gradlew clean test aggregate 

## Ejecutar el proyecto seleccionando el navegador (modo visible)

Puedes especificar el navegador en el que deseas ejecutar las pruebas utilizando la propiedad `-Denvironment`.

Google Chrome:

    ./gradlew clean test -Denvironment=chrome

Edge:

    ./gradlew clean test -Denvironment=edge

Firefox:

    gradle clean test -Ddriver=firefox

## Ejecutar el proyecto seleccionando el navegador (modo headless)

Google Chrome:

    ./gradlew clean test -Denvironment=chrome-headless

Edge:

    ./gradlew clean test -Denvironment=edge-headless

Firefox

EN CURSO.....


## Ejecutar el proyecto seleccionando una clase específica

Puedes ejecutar una clase de prueba específica utilizando la opción `--tests` seguida del nombre completo de la clase.
Por ejemplo, para ejecutar la clase `DuckDuckGoSearchTest`, puedes usar uno de los siguientes comandos:

Para ejecutar la clase en navegador Google Chrome:

    ./gradlew.bat clean test --tests "com.example.runners.DuckDuckGoSearchTest" -Denvironment=chrome

Para ejecutar la clase en navegador edge:

    ./gradlew.bat clean test --tests "com.example.runners.DuckDuckGoSearchTest" -Denvironment=edge

Para ejecutar la clase en navegador firefox:

    ./gradlew clean test --tests "com.example.runners.DuckDuckGoSearchTest" -Ddriver=firefox

Usando alguno de estos comandos el reporte de Serenity se generará y solo mostrará lo correspondiente a esta clase.

## Ver los Informes de Pruebas

Después de que las pruebas se hayan ejecutado, Serenity BDD genera un informe de prueba detallado y vivo.

Puedes encontrar el informe abriendo el siguiente archivo en tu navegador web:
`target/site/serenity/index.html`

Este informe proporciona un desglose de los resultados de las pruebas, incluyendo los pasos ejecutados, capturas de pantalla y el resultado de cada prueba.


## Configuración de archivo serenity.conf

El archivo `serenity.conf` es el fichero de configuración principal que utiliza el formato HOCON. En este proyecto, define aspectos cruciales para la ejecución de las pruebas, tales como:
*   El navegador a utilizar (Chrome) y sus configuraciones específicas (argumentos de inicio, modo headless, etc.).
*   Multi-navegador: Chrome, Edge, Firefox
*   Multi-modalidad: Normal y Headless
*   Navegación privada: Incógnito/InPrivate
*   Configuración CI-ready: No-sandbox, disable-dev-shm-usage
*   Reportes detallados: Screenshots automáticos
*   La URL base del entorno de pruebas (https://duckduckgo.com).
*   Tiempos de espera (timeouts) para la interacción con elementos web.


## Configuración de archivo serenity.properties

El archivo `serenity.properties` se utiliza para personalizar los metadatos del informe de pruebas de Serenity. En este proyecto, se emplea para añadir campos personalizados al reporte, como la versión de la aplicación, el ambiente (QA), el squad y el usuario que ejecuta las pruebas, enriqueciendo así la información de cada ejecución.

## Configuración de archivo Dockerfile

El archivo `Dockerfile` permite empaquetar la aplicación y sus dependencias en un contenedor Docker, lo que facilita la ejecución de las pruebas en cualquier entorno de forma consistente y aislada.

A continuación, se presenta un ejemplo de `Dockerfile` para este proyecto, que incluye la instalación de Google Chrome, necesario para las pruebas de UI.

```dockerfile
# Usa una imagen base de OpenJDK para Java 17
# openjdk:17-jdk-slim es una imagen ligera que incluye el JDK necesario.
FROM openjdk:17-jdk-slim

# Instala Google Chrome y dependencias necesarias para su ejecución.
# Esto es crucial para ejecutar pruebas de interfaz de usuario (UI) con Serenity BDD.
# Se utiliza 'google-chrome-stable' para asegurar una versión estable del navegador.
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    google-chrome-stable \
    --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*

# Establece el directorio de trabajo dentro del contenedor.
# Aquí es donde se copiarán los archivos del proyecto.
WORKDIR /app

# Copia los archivos del wrapper de Gradle.
# Esto permite que Gradle se ejecute dentro del contenedor sin necesidad de instalarlo globalmente.
COPY gradlew .
COPY gradle gradle

# Copia el resto de los archivos del proyecto al directorio de trabajo.
COPY . .

# Da permisos de ejecución al script del wrapper de Gradle.
RUN chmod +x gradlew

# Define el comando por defecto que se ejecutará cuando el contenedor se inicie.
# Este comando limpiará el proyecto, ejecutará todas las pruebas y generará los informes de Serenity.
# Por defecto, las pruebas se ejecutarán en Chrome (según la configuración de serenity.conf).
# Para ejecutar en modo headless, puedes añadir -Dheadless=true si tu configuración lo soporta.
CMD ["./gradlew", "clean", "test", "aggregate"]

# Para construir la imagen Docker, navega a la raíz del proyecto y ejecuta:
# docker build -t serenity-gradle-tests .

# Para ejecutar las pruebas en un contenedor Docker:
# docker run serenity-gradle-tests

# Opcional: Si quieres acceder a los informes de Serenity generados, puedes montar un volumen:
# docker run -v $(pwd)/serenity-reports:/app/target/site/serenity serenity-gradle-tests
# Esto copiará los informes a una carpeta 'serenity-reports' en tu máquina local.
```

## Ejecutar el proyecto usando Docker

Puedes especificar el navegador en el que deseas ejecutar las pruebas utilizando la propiedad `-Denvironment`.

1. Reconstruye la imagen:


    docker build -t serenity-tests .

2. Ejecuta el contenedor para ver el contenido del script:


    docker run --rm serenity-tests


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