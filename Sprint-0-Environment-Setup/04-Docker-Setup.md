# Docker Setup

## Objective

This document describes the Docker setup process used for the FinEdge Bank QA Project. Docker was configured to run Apache Fineract and its supporting services in isolated containers.

---

# Why Docker?

Docker allows multiple services required by the banking application to run consistently without manually installing each service on the local machine.

Docker was used to start:

- Apache Fineract
- PostgreSQL Database
- Grafana
- Prometheus
- Tempo
- Supporting backend services

---

# Docker Desktop Installation

## Software

| Item | Value |
|------|-------|
| Software | Docker Desktop |
| Purpose | Container Platform |
| Status | ✅ Installed |

---

# Docker Configuration

The following configuration was completed:

- Docker Desktop Installed
- WSL Integration Enabled
- Docker Engine Running Successfully
- Required Images Downloaded
- Required Containers Created

---

# Docker Commands Used

## Verify Docker Installation

```bash
docker --version
```

---

## Check Running Containers

```bash
docker ps
```

---

## Check All Containers

```bash
docker ps -a
```

---

## List Docker Images

```bash
docker images
```

---

## Start Docker Compose

```bash
docker compose up
```

---

## Start in Detached Mode

```bash
docker compose up -d
```

---

## Stop Containers

```bash
docker compose down
```

---

## View Container Logs

```bash
docker logs <container-name>
```

---

# Containers Started Successfully

The following containers were started during project setup:

- Apache Fineract
- PostgreSQL
- Grafana
- Prometheus
- Tempo

---

# Verification

Docker setup was verified by:

- Docker Desktop Running
- Containers Started Successfully
- Backend Accessible
- Database Connected
- No Critical Container Errors

---

# Issues Encountered

During Docker setup, the following issues were encountered:

- Docker installation location planning
- WSL configuration
- Docker service startup
- Initial container download time
- Backend startup verification

---

# Resolution

The issues were resolved by:

- Verifying Docker installation
- Configuring WSL correctly
- Restarting Docker Desktop when required
- Waiting for all containers to initialize
- Verifying container status using Docker commands

---

# Outcome

Docker was successfully configured for the FinEdge Bank QA Project.

All required containers started successfully, providing the backend infrastructure required for application testing.
