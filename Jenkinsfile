pipeline {
    agent any

    tools {
        maven 'maven3916'
    }

    environment {
        ARTIFACT = 'target/payment-2.7.jar'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/payment-2.7.jar', fingerprint: true
            }
        }

        stage('Approval') {
            when {
                branch 'main'
            }
            steps {
                input message: 'Approve production deployment?', ok: 'Deploy'
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                bat 'bash deploy.sh "%ARTIFACT%"'
            }
        }
    }

    post {

        always {
            junit 'target/surefire-reports/*.xml'
            cleanWs()
        }

        success {
            echo 'Pipeline completed successfully'
        }

        failure {
            echo 'Pipeline failed'
        }

        aborted {
            echo 'Pipeline was aborted'
        }
    }
}