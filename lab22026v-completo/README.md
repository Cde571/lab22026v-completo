# LAB2026V - Pipeline CI/CD con Spring Boot

Proyecto base para laboratorio de CI/CD con la siguiente estructura:

- **Repositorio GitHub**
- **GitHub Actions**
- **JUnit 5**
- **JaCoCo**
- **SonarCloud**
- **Maven**
- **Docker**
- **AWS ECR** (opcional, mediante secrets)

## Estructura

```text
lab22026v-completo/
├── .github/workflows/build.yml
├── src/main/java/com/udea/lab2026v
│   ├── Application.java
│   ├── controller/DataController.java
│   ├── service/DataService.java
│   └── dto/ApiMessageDTO.java
├── src/test/java/com/udea/lab2026v/controller/DataControllerTest.java
├── src/main/resources/application.properties
├── Dockerfile
├── pom.xml
└── README.md
```

## Endpoints disponibles

- `GET /` → health check
- `GET /version` → versión
- `GET /nations` → datos falsos de países
- `GET /currencies` → datos falsos de monedas
- `GET /aviation` → datos falsos de aviación

## Cómo ejecutarlo localmente

### Requisitos
- Java 17
- Maven
- Docker (opcional, para la imagen)

### Ejecutar en terminal
```bash
mvn clean spring-boot:run
```

### Probar endpoints
- http://localhost:8080/
- http://localhost:8080/version
- http://localhost:8080/nations
- http://localhost:8080/currencies
- http://localhost:8080/aviation

## Ejecutar pruebas
```bash
mvn test
```

## Generar cobertura JaCoCo
```bash
mvn clean verify
```

Reporte generado en:
```text
target/site/jacoco/index.html
```

## Construir JAR
```bash
mvn clean package
```

## Construir imagen Docker
```bash
docker build -t lab2026v:latest .
```

## Ejecutar contenedor Docker
```bash
docker run -p 8080:8080 lab2026v:latest
```

## Configuración de SonarCloud
Debes crear los secrets en GitHub:

- `SONAR_TOKEN`
- `AWS_ACCESS_KEY_ID`
- `AWS_SECRET_ACCESS_KEY`
- `ECR_REPOSITORY`

Además, actualiza en `pom.xml`:
- `sonar.organization`
- `sonar.projectKey`

## Qué cubre este laboratorio
1. Commits al repositorio
2. Ejecución de pruebas automáticas
3. Cobertura con JaCoCo
4. Análisis de calidad con SonarCloud
5. Empaquetado con Maven
6. Construcción de imagen Docker
7. Push a AWS ECR
