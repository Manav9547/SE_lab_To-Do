
-----------------------------------------------------------
 TO-DO LIST CLI APPLICATION - CI/CD With Jenkins & Docker
-----------------------------------------------------------

This repository contains a Java Command-Line To-Do Application,
automated end-to-end using Jenkins CI/CD, JUnit, Docker and DockerHub.

Every time code is pushed to GitHub, Jenkins automatically executes:

  1. Pulls source code from GitHub
  2. Builds Java program using javac
  3. Runs JUnit test cases
  4. Builds Docker image
  5. Pushes image to DockerHub

-----------------------------------------------------------
TECHNOLOGY STACK
-----------------------------------------------------------
Java                    - Application logic
JUnit                   - Automated testing
Jenkins                 - CI/CD pipeline
GitHub                  - Source repository
Docker                  - Container packaging
DockerHub               - Image hosting registry

-----------------------------------------------------------
RUN LOCALLY (WITHOUT DOCKER)
-----------------------------------------------------------
javac TodoApp.java
java TodoApp

-----------------------------------------------------------
RUN USING DOCKER
-----------------------------------------------------------
Pull image from DockerHub:
docker pull <your-dockerhub-username>/todo-cli:latest

Run container:
docker run -it <your-dockerhub-username>/todo-cli:latest

-----------------------------------------------------------
JENKINS PIPELINE WORKFLOW
-----------------------------------------------------------
Git push --> Jenkins Trigger --> Code Checkout
--> Java Build --> JUnit Test --> Docker Image Build
--> Push to DockerHub --> Ready to Run Anywhere

Declarative Pipeline Script Used:

pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps { checkout scm }
        }

        stage('Build') {
            steps { sh 'javac -cp /usr/share/java/junit4.jar TodoApp.java TodoAppTest.java' }
        }

        stage('Test') {
            steps {
                echo 'Running JUnit Tests...'
                sh 'java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore TodoAppTest'
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Building Docker Image...'
                sh 'docker build -t todoapp-jenkins .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub',
                                                 usernameVariable: 'DOCKER_USER',
                                                 passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker tag todoapp-jenkins $DOCKER_USER/todo-cli:latest
                        docker push $DOCKER_USER/todo-cli:latest
                    '''
                }
            }
        }
    }
}

-----------------------------------------------------------
APPLICATION FEATURES
-----------------------------------------------------------
[✔] Add Tasks
[✔] View Tasks
[✔] Delete Tasks
[✔] Clear All Tasks
[✔] Works in Docker Container
[✔] Fully Automated CI/CD Deployment

-----------------------------------------------------------
SCREENSHOTS REQUIRED FOR SUBMISSION
-----------------------------------------------------------
(1) Jenkins Build Console Output
(2) JUnit Test Output
(3) Docker Image Build Success
(4) DockerHub Repository Listing
(5) Running Container Output

-----------------------------------------------------------
AUTHOR
-----------------------------------------------------------
Name        : Manav Jindal
GitHub      : github.com/Manav9547
DockerHub   : dockerhub.com/u/manavimt2023535

===========================================================
