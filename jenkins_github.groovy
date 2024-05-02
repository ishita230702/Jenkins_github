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
    }
    stage('Unit and Integration Tests') {
        steps {
            echo "Run unit tests using JUnit"
            echo "Run integration tests using Selenium"
        }
        post{
            success{
                mail to:"ishu.g230702@gmail.com",
                subject:"Unit and Integration Test Status email",
                body:"Unit and Integration tests stage was successful!"
            }
            failure{
                mail to:"ishu.g230702@gmail.com",
                subject:"Unit and Integration Test Status email",
                body:"Unit and Integration tests stage FAILURE!"
            }
        }
    }
    
    stage('Security scan'){
        steps{
            echo "Analysing code..."
            echo "Security scan tool: Checkmarx"
        }
        post{
            success{
                mail to:"ishu.g230702@gmail.com",
                subject:"Security scan Status email",
                body:"Security Scan stage was successful!"
            }
            failure{
                mail to:"ishu.g230702@gmail.com",
                subject:"Security scan Status email",
                body:"Security Scan stage FAILURE!"
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
