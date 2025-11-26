pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps { checkout scm }
        }

    stage('Build') {
        steps {
            sh 'javac -cp /usr/share/java/junit4.jar TodoApp.java TodoAppTest.java'
        }
    }

    stage('Test') {
        steps {
            echo "Running JUnit Tests..."
            sh 'java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore TodoAppTest'
        }
    }


        stage('Docker Build') {
            when { expression { currentBuild.result == null } }   // only if tests passed
            steps {
                echo "Building Docker Image..."
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
                docker tag todoapp-jenkins $DOCKER_USER/imt2023535-todo-cli:latest
                docker push $DOCKER_USER/imt2023535-todo-cli:latest
            '''
        }
    }
}

}
}
