pipeline {
  agent any
  environment {
  	  SONARQUBE_URL     = 'http://localhost:9000'
      SONARQUBE_KEY     = credentials('sonar-key')
      REPOSITORY = 'lasanthar78/springboot-cicd-bootstrap'
      DOCKER_USER_NAME = 'lasanthar78'
      DOCKER_PASSWORD = credentials('dockerpassword')
      VERSION = 'latest'  	  
  }
  tools {
  	  jdk	'JDK11'
      maven 'maven-3.8.3'
  }
  
  stages {  	    	  
      stage('compile') {
         steps {
         sh 'mvn clean package'             
         }
      }                 
      stage('analysis') {
      	when {
        	branch 'main'  
      	}
        steps {        	
        		sh 'mvn clean verify sonar:sonar -Dsonar.host.url=$SONARQUBE_URL -Dsonar.login=$SONARQUBE_KEY'                                                       
        }
      }                 
      stage('container build and push') {
      	when {
        	branch 'main'  
      	}
         steps {         	
         		sh 'docker build . -t $REPOSITORY:$VERSION'
				sh 'echo "$DOCKER_PASSWORD" | docker login --username $DOCKER_USER_NAME --password-stdin'				
				sh 'docker push $REPOSITORY:$VERSION'
         }
      }      
      stage('deploy dev server') {
      	when {
        	branch 'main'  
      	}
         steps { 	
         		sh 'kubectl apply -f configs/kube/springboot-cicd-api-config.yml'
				sh 'kubectl apply -f configs/kube/springboot-cicd-api.yml'
				sh 'kubectl apply -f configs/kube/springboot-cicd-service.yml'
         }
      }      
      
      stage('ansible test') {
      	when {
        	branch 'main'  
      	}
         steps {
				sh 'python -m pip install --upgrade pip'				
				sh 'cd configs/playbooks && if [ -d "venv" ]; then rm -Rf venv; fi && virtualenv venv && . venv/bin/activate && pip install -r requirements.txt && ansible-playbook simple.yml'								
         }
      }
  }  
}
