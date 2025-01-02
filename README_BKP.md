### Some features of this project

1. Hexagonal Architecture
2. Docker and Docker Compose

### Requirements to run this project locally

1. Java SDK 19
2. Docker
3. Docker Desktop
4. Kubernetes
5. (Optional) Beekeeper Studio or DBeaver

### How to run this project using Docker and Kubernetes

1. (Windows only) Make sure you are inside WSL terminal
2. In the same folder as the Dockerfile, run the command: 
```sh
docker build -t tech-challenge-fase-1 .
```
```sh
kubectl apply -f k8s/app/app-configmap.yaml
kubectl apply -f k8s/app/app-deployment.yaml
kubectl apply -f k8s/app/app-service.yaml
```
```sh
kubectl rollout restart deployment poc-hexagonal-arch
```
```sh
kubectl apply -f k8s/db/db-configmap.yaml
kubectl apply -f k8s/db/db-pv.yaml
kubectl apply -f k8s/db/db-pvc.yaml
kubectl apply -f k8s/db/db-deployment.yaml
kubectl apply -f k8s/db/db-service.yaml
```
```sh
kubectl get pods
```
```sh
kubectl get deployments
```
```sh
kubectl get services
```
4. List all containers with ```docker ps``` and make sure these 3 are up and running: poc-hexagonal-container,
   pgadmin_container, postgres_container
5. Enjoy! API should be accessible on localhost:8080

### Running Docker containers

1. Access the folder where docker-compose.yml is located
2. Run the command:

```
docker compose up -d 
```

### Accessing OpenAPI/Swagger

1. Open the url on your web browser: ```http://localhost:8080/swagger-ui/index.html```

### Connecting to Postgres using PGAdmin

1. Access PGAdmin on any web browser using the address: http://localhost:5050/
2. If this is the first time, set a master password, such as: master
3. Create a server with the following configuration:

```
Name: Any Name
Host name/address: host.docker.internal
Port: 5432
Username: postgres
Password: changeme
```

### Recommended IntelliJ Plugins

1. Lombok
2. Restful Api Tool

### Reverting Flyway Migrations

Flyway allows you to reverse applied migrations using the `undo` command. How to Use:

1. **Undo Scripts:**
    - For each migration (`V__`), create a corresponding undo script (`U__`).
    - Example: For `V2__create_table.sql`, create `U2__undo_create_table.sql` to reverse it.

2. **Run Undo:**
   ```bash
   flyway undo

### Debug pod
kubectl apply -f k8s/debug-pod.yaml

kubectl exec -it debug-pod sh

nslookup db-service