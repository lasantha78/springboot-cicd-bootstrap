# springboot-cicd-bootstrap
Jenkins based CI/CD template project for a Spring Boot API.

This project targets Java 26 and Spring Boot 4.0.6.

CI/CD Steps are as follows
- Compile and run unit test code
- Analysis of the code via sonarqube server
- Build docker image and push it in to repository
- Deploy docker image as Kubernetes Deployment and expose as service (provision for automation with Ansible scripts are given here)

# Start Sonarqube server
docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 -v sonar-data:/opt/sonarqube/data -v sonar-extensions:/opt/sonarqube/extensions sonarqube:latest

# In the Jenkins server
1. Configure GitHub code repository as a multi-branch Pipeline
2. Use ssh keys to access Git hub code repository 
3. Configure Jenkins tools named `JDK26` and `maven-3.9.16`.
4. Following configurations has to be made as credentials.
	-   Sonarqube token
	-   Docker Hub password   

 
