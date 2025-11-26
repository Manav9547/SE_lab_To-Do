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
    }
}
