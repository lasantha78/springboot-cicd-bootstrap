# springboot-cicd-bootstrap
This is a Jenkins based CI/CD template project for a Springboot application.

# To start Sonarqube server
docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 -v sonar-data:/opt/sonarqube/data -v sonar-extensions:/opt/sonarqube/extensions sonarqube:latest