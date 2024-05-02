pipeline{
    agent any
    environment{
        DIRECTORY_PATH="https://github.com/ishita230702/Jenkins_github.git"
        TESTING_ENVIRONMENT="test"
        PRODUCTION_ENVIRONMENT="ISHITA"
    }
    stages{
        stage('Build'){
            steps{
                echo "fetch the source code from ${DIRECTORY_PATH}"
                echo "Build the code using Maven"
            }
        }
    stage('Unit and Integration Tests') {
            steps {
                echo "Run unit tests using JUnit"
                echo "Run integration tests using Selenium"
            }
            post{
                success{
                     emailext(
                        to: 'ishu.g230702@gmail.com',
                        subject: 'Security Scan',
                        body: 'Security Scan Tests successfuly completed', 
                        attachLog: true
                    )
                }
                failure{
                    emailext(
                        to: 'ishu.g230702@gmail.com',
                        subject: 'Security Scan',
                        body: 'Security Scan Tests successfuly completed', 
                        attachLog: true
                    )
                }
            }
        }
        stage('Code Quality Check'){
            steps{
                echo "checking the quality of the code"
                echo "code analysis tool: SonarQube"
                echo "Done!!!"
            }
        stage('Security scan'){
            steps{
                echo "Analysing code..."
                echo "Security scan tool: Checkmarx"
            }
        }
            post{
                success{
                   emailext(
                        to: 'ishu.g230702@gmail.com',
                        subject: 'Security Scan',
                        body: 'Security Scan Tests successfuly completed', 
                        attachLog: true
                    )
                }
                failure{
                   emailext(
                        to: 'ishu.g230702@gmail.com',
                        subject: 'Security Scan',
                        body: 'Security Scan Tests successfuly completed', 
                        attachLog: true
                    )
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo "deploy the application t"
                echo"Deploy tool: AWS EC2"
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo "Run integration tests on the staging environment"
            }
        }
        stage('Deploy to Production'){
            steps{
                echo "Deployment to AWS EC2. Started and completed!"
            }
        }
    }
}    
