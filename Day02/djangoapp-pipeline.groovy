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
                script{
                    clone("https://github.com/Vedangi1810/django-notes-app.git","main")
                }
            }
        }
        stage("Build"){
            steps{
                script{
                    build("notes-app","latest")
                }
            }
        }
        stage("Test"){
            steps{
                echo 'This is Testing the code'
            }
        }
        stage("Push to Docker Hub"){
        steps{
            script{
                push(
                    imageName: 'notes-app',
                    imageTag: 'latest'
                )
            }
                }
            }
        stage("Deploy"){
            steps{
                echo 'This is deploying the code'
                bat 'docker rm -f db_cont || true' 
                bat 'docker compose down && docker compose up -d'
            }
        }
    }
}