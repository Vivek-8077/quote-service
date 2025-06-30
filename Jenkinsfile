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
                sh '''
                    echo "Stopping existing container if any..."
                    docker rm -f quote-service-container || true

                    echo "Running new container..."
                    docker run -d --name quote-service-container -p 8081:8081 quote-service:latest

                    echo "Waiting for app to start..."
                    sleep 10

                    echo "Testing app endpoint:"
                    curl -f http://localhost:8081 || exit 1
                '''
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished!'
        }
    }
}

