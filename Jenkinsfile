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
                echo "Compiling Java program..."
                sh 'javac TodoApp.java'
            }
        }

        stage('Run') {
            steps {
                echo "Running Java To-Do Application..."
                sh 'java TodoApp'
            }
        }

        stage('Done') {
            steps {
                echo "Build & Run completed successfully! ✔"
            }
        }
    }
}
