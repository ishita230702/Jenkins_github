pipeline{
    agent any
    environment{
        DIRECTORY_PATH="path"
        TESTING_ENVIRONMENT="test"
        PRODUCTION_ENVIRONMENT="ISHITA"
    }
    stages{
        stage('Build'){
            steps{
                echo "fetch the source code from ${DIRECTORY_PATH}"
                echo "compile the code and generate any necessary artifacts"
            }
            post{
                success{
                    mail to:"ishu.g230702@gmail.com",
                        subject:"Build Status email",
                        body:"Build was successful!"
                }
            }
        }
        stage('Test'){
            steps{
                echo "unit tests"
                echo "integration tests"
            }
        }
        stage('Code Quality Check'){
            steps{
                 echo "check the quality of the code"
            }
        }
        stage('Deploy'){
            steps{
                echo "deploy the application to ${TESTING_ENVIRONMENT}"
            }
        }
        stage('Approval'){
            steps{
                echo "Approval Begins"
                sleep(time:10, unit: 'SECONDS')
                echo "Approval Ended"
            }
        }
        stage('Deploy to Production'){
            steps{
                echo "Deployment to ${PRODUCTION_ENVIRONMENT} Started and completed!"
            }
        }        
    }    
}
