pipeline {
    agent any

    tools {
        jdk 'JDK-21'
    }

    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge', 'chrome-headless', 'firefox-headless', 'edge-headless'],
            description: 'Selecciona el navegador para las pruebas',
            defaultValue: 'chrome-headless'
        )
    }

    environment {
        BROWSER = "${params.BROWSER}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/vandres777/Serenity_gradle1.git' // Using the project's Git URL
            }
        }

        stage('Tests') {
            steps {
                script {
                    // Construir parámetros para Serenity BDD
                    def gradleParams = "-Dserenity.browser.webdriver=${params.BROWSER}"

                    bat ".\\gradlew.bat clean test aggregate --no-daemon ${gradleParams}"
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/site/serenity/**/*'
            junit '**/target/site/serenity/*.xml' // Keeping the original JUnit report path
        }
    }
}