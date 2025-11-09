pipeline {
    agent any

    tools {
        jdk 'JDK-21'
    }

    stages {
        stage('Checkout') {
            steps {
                // CAMBIA 'master' POR 'main'
                git branch: 'main',
                    url: 'https://github.com/vandres777/Serenity_gradle1'
            }
        }

        stage('Clean') {
            steps {
                sh './gradlew clean'
            }
        }

        stage('Tests') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Serenity Reports') {
            steps {
                sh './gradlew aggregate'
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Serenity BDD Report'
                ]
            }
        }
    }
}