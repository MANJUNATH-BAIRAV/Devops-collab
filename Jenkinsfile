pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                bat 'git clone https://github.com/MANJUNATH-BAIRAV/Devops-collab.git'
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
                bat 'docker build -t devops-collab-image .'
            }
        }
        stage('Docker Run') {
            steps {
                bat 'docker run -d -p 8080:8080 devops-collab-image'
            }
        }
    }
}
