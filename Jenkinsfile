pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo "Compiling Java code..."
                sh 'javac TodoApp.java'
            }
        }
        stage('Test (Automated)') {
            steps {
                echo "Running with pre-defined input..."
                sh 'echo "1\n5" | java TodoApp'
            }
        }
        stage('Done') {
            steps {
                echo "Pipeline completed ✔"
            }
        }
    }
}
