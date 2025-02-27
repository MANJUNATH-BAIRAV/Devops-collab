pipeline {
    agent any

    environment {
        GIT_CREDENTIALS_ID = 'your-credential-id'  // Replace with your Jenkins credentials ID
        DOCKER_IMAGE = 'devops-collab:latest'
    }

    stages {
        stage('Clone Repository') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${GIT_CREDENTIALS_ID}", usernameVariable: 'GIT_USER', passwordVariable: 'GIT_PASS')]) {
                    sh 'git clone https://${GIT_USER}:${GIT_PASS}@github.com/MANJUNATH-BAIRAV/Devops-collab.git'
                }
            }
        }

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE} .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo ${DOCKER_PASS} | docker login -u ${DOCKER_USER} --password-stdin'
                    sh 'docker tag ${DOCKER_IMAGE} ${DOCKER_USER}/${DOCKER_IMAGE}'
                    sh 'docker push ${DOCKER_USER}/${DOCKER_IMAGE}'
                }
            }
        }

        stage('Deploy Container') {
            steps {
                sh 'docker run -d -p 8080:8080 ${DOCKER_IMAGE}'
            }
        }
    }

    post {
        always {
            echo 'Pipeline Execution Completed'
        }
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check logs for details.'
        }
    }
}
