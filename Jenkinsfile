pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps { checkout scm }
        }

        stage('Build') {
            steps {
                sh 'javac TodoApp.java TodoAppTest.java'
            }
        }

        stage('Test') {
            steps {
                echo "Running JUnit Tests"
                sh 'java org.junit.runner.JUnitCore TodoAppTest'
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
