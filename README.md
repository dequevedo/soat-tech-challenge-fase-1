### About
This is a personal project that I created in order to improve my skills. It is a backend for an App that can integrate with OpenAI and perform a series of tasks.

### ✅ Some features of this project
1. Hexagonal Architecture
2. Docker and Docker Compose
3. OpenAI integration

### Requirements to run this project locally
1. Java SDK 19
2. Docker

### Running Docker containers
1. Access the folder where docker-compose.yml is located
2. Run the command:
```
docker compose up -d 
```

### Connecting to Postgres using PGAdmin
1. Access PGAdmin on any web browser using the address: http://localhost:5050/
2. Create a server with the following configuration:
```
Name: Any Name
Host name/address: host.docker.internal
Port: 5432
Username: postgres
Password: changeme
```

### 💡 Testing Spring Batch by importing a local .csv file
In order to test the spring batch using a local file, I included a python script 
that generates Characters and stores them into a .csv file which can be imported by the application.

### 💡 Testing Spring Batch by importing a file from Bucket S3
In order to test the spring batch using S3, ... WIP

### Recommended IntelliJ Plugins
1. Lombok
2. Restful Api Tool