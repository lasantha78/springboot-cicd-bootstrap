# springboot-cicd-bootstrap
Jenkins based CI/CD template project for a Springboot API. 

Steps are as follows
- Compile and run unit test code
- Analysis of the code via sonarqube server
- Build docker image and push it in to repository
- Deploy docker image as kuberenetes Deployment and expose as service (provision for automation with Ansible scripts are given here)

# Start Sonarqube server
docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 -v sonar-data:/opt/sonarqube/data -v sonar-extensions:/opt/sonarqube/extensions sonarqube:latest

# In the Jenkins server
1. Configure GitHub code repository as multi-branch Pipeline
2. Use ssh keys to access Git hub code repository 
3. Following configurations has to be made as credentials.
	-   Sonarqube token
	-   Docker Hub password   

 
