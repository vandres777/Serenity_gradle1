pipeline {
    agent any

    tools {
        jdk 'JDK-21'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/vandres777/Serenity_gradle1.git'
            }
        }

        stage('Build and Test') {
            steps {
                bat '.\\gradlew.bat clean test aggregate --no-daemon'
            }
        }
    }

    post {
        always {
            // Publicar reporte HTML de Serenity
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/site/serenity',
                reportFiles: 'index.html',
                reportName: 'Serenity BDD Reports'
            ])

            // Publicar resultados JUnit
            junit '**/target/site/serenity/*.xml'

            // Archivar artifacts
            archiveArtifacts artifacts: 'target/site/serenity/**/*'
        }
    }
}