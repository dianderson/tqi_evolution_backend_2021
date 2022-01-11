# TQI Evolution 2022 - Back-end

## Projeto criado para o processo seletivo

O projeto foi criado utilizando [spring](https://start.spring.io) na versão 2.6.2 que era a estável mais recente e java 17

## As dependencias utilizadas foram.

```.xml
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>0.9.1</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

## Endpoints

- METHOD - "endpoint URI" - properties type - properties - return

- POST - "/customer/create" - RequestBody - CustomerRequest - CustomerResponse
- POST - "/auth" - RequestBody - LoginRequest - access token
- POST - "/loan/request" - RequestBody - LoanRequest - LoanResponse
- GET - "/loan" - no request properties -  - List of LoanResponse
- GET - "/loan/{id}" - PathVariable - id - LoanDetailedResponse

## Foi montado um diagrama de entidade relacionamento

![Entidades](https://raw.githubusercontent.com/dianderson/tqi_evolution_backend_2021/master/images/TQI%20-%20Frame%202.jpg)

![DTO - Request](https://raw.githubusercontent.com/dianderson/tqi_evolution_backend_2021/master/images/TQI%20-%20Frame%203.jpg)

![DTO - Response](https://raw.githubusercontent.com/dianderson/tqi_evolution_backend_2021/master/images/TQI%20-%20Frame%204.jpg)