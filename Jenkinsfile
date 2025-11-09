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

        stage('Clean') {
            steps {
                bat '.\\gradlew.bat clean'
            }
        }

        stage('Tests') {
            steps {
                bat '.\\gradlew.bat test'
            }
        }

        stage('Serenity Reports') {
            steps {
                bat '.\\gradlew.bat aggregate'
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

    post {
        always {
            archiveArtifacts artifacts: 'target/site/serenity/**/*',
                            onlyIfSuccessful: false
        }
    }
}