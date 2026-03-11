@Library("Shared") _
pipeline{
    agent any
    stages{
        stage("Hello"){
            steps{
                script{
                    hello()
                }
            }
        }
        stage("Code"){
            steps{
                echo 'This is cloning the code'
                git url: "https://github.com/LondheShubham153/django-notes-app.git", branch: "main"
                echo 'Code cloning successful'
            }
        }
        stage("Build"){
            steps{
                echo 'This is building the code'
                bat 'docker build -t notes-app:latest .'
            }
        }
        stage("Test"){
            steps{
                echo 'This is Testing the code'
            }
        }
        stage("Push to Docker Hub"){
            steps{
                echo 'This is Pushing the code'
                withCredentials([usernamePassword(
                    'credentialsId':"dockerHubCred",
                    passwordVariable:"dockerHubPass",
                    usernameVariable:"dockerHubUser")]){
                bat 'docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}'
                bat 'docker image tag notes-app:latest ${env.dockerHubUser}/notes-app:latest'
                bat 'docker push ${env.dockerHubUser}/notes-app:latest'
                }
            }
        }
        stage("Deploy"){
            steps{
                echo 'This is deploying the code'
                bat 'docker run -d -p 8000:8000 notes-app:latest'
                bat 'docker compose up -d'
            }
        }
    }
}