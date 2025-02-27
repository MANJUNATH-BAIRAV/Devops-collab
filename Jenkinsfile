pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                bat 'git clone https://github.com/your-repo/your-project.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Docker Build') {
            steps {
                bat 'docker build -t your-image-name .'
            }
        }
        stage('Docker Run') {
            steps {
                bat 'docker run -d -p 8080:8080 your-image-name'
            }
        }
    }
}
