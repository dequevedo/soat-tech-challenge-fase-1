### Some features of this project

1. Hexagonal Architecture
2. Docker and Docker Compose

### Requirements to run this project locally

1. Java SDK 19
2. Docker
3. Docker Desktop
4. Kubernetes
5. (Optional) Beekeeper Studio or DBeaver

## How to run this project using Docker and Kubernetes

### Build the Docker Image

```sh
docker build -t tech-challenge-fase-1 .
```

### Apply all Application K8s Manifests

```sh
kubectl apply -f k8s/app/app-hpa.yaml
kubectl apply -f k8s/app/app-configmap.yaml
kubectl apply -f k8s/app/app-deployment.yaml
kubectl apply -f k8s/app/app-service.yaml
```

### Apply all Databse K8s Manifests

```sh
kubectl apply -f k8s/db/db-configmap.yaml
kubectl apply -f k8s/db/db-pv.yaml
kubectl apply -f k8s/db/db-pvc.yaml
kubectl apply -f k8s/db/db-deployment.yaml
kubectl apply -f k8s/db/db-service.yaml
```

### Verify if all pods are running

```sh
kubectl get pods
```

### Verify if all deployments are running

```sh
kubectl get deployments
```

### Verify if all services are running

```sh
kubectl get services
```

### Test the application

```sh
curl -X GET "localhost:30080/customers"
```

### Restart deployment in case of any mistake

```sh
kubectl rollout restart deployment poc-hexagonal-arch
```

Enjoy! API should be accessible on localhost:30080

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

```sh
kubectl apply -f k8s/debug-pod.yaml
```

```sh
kubectl exec -it debug-pod sh
```

```sh
nslookup db-service
```

### Install Kubernetes Metrics Server

Metrics server is needed in order to Horizontal Pod (HPA) Autoscaling to work properly

```sh
kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
```