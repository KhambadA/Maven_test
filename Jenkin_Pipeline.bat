pipeline{
	agent any
	
	stages{
	     stage('Compile Stage'){
		
		steps{
			withMaven(maven:'maven_3.5.4'){
			sh 'mvn clean compile'
				}
			}
		}
	
	    stage('Testing Stage'){
		
		steps{
			withMaven(maven:'in golbal tool config'){
			sh 'mvn test'
						}
				}
			}
	   stage('Deploy Stage'){
		
		steps{
			withMaven(maven:'in golbal tool config'){
			sh 'mvn deploy' 
						}
				}
		}
	}
} 


