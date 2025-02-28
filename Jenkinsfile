pipeline {
    agent any

    environment {
        IMAGE_NAME = 'devops-collab-app'
        DOCKER_HUB_USER = 'your-docker-hub-username' // Update this
    }

    stages {
        // Remove explicit "Clone Repository" stage - Jenkins automatically checks out SCM

        stage('Build Maven Project') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Run Unit Tests') {
            steps {
                script {
                    sh 'mvn test' // Runs both compile and tests
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest ."
                }
            }
        }

        stage('Push Docker Image') {
            environment {
                DOCKER_HUB_PASSWORD = credentials('docker-hub-credentials') // Add credentials in Jenkins
            }
            steps {
                script {
                    sh "echo '${DOCKER_HUB_PASSWORD}' | docker login -u '${DOCKER_HUB_USER}' --password-stdin"
                    sh "docker push ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest"
                }
            }
        }

        stage('Deploy Container') {
            steps {
                script {
                    sh "docker run -d -p 8080:8080 --name devops-container ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest"
                }
            }
        }
    }

    post {
        always {
            cleanWs() // Clean workspace after build
        }
    }
}
