pipeline {
    agent any

    environment {
        MAVEN_HOME = '/usr/share/maven'
        PATH = "${env.MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Vivek-8077/quote-service.git', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t quote-service:latest .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker run -d -p 8081:8081 quote-service:latest'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished!'
        }
    }
}

