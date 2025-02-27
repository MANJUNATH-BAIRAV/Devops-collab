pipeline {
    agent any

    environment {
        GIT_CREDENTIALS_ID = 'git-credentials'  // Make sure this matches the ID in Jenkins Credentials
        IMAGE_NAME = 'devops-collab-app'
        DOCKER_HUB_USER = 'your-docker-hub-username'  // Replace with your DockerHub username
    }

    stages {
        stage('Clone Repository') {
            steps {
                script {
                    checkout([$class: 'GitSCM', 
                        branches: [[name: '*/main']], 
                        userRemoteConfigs: [[
                            url: 'https://github.com/MANJUNATH-BAIRAV/Devops-collab.git',
                            credentialsId: "${GIT_CREDENTIALS_ID}"
                        ]]
                    ])
                }
            }
        }

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
                    sh 'mvn test'
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
        success {
            echo "Pipeline execution completed successfully!"
        }
        failure {
            echo "Pipeline failed. Check logs for details."
        }
    }
}
