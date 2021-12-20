## 스프링 부트 Actuator: Spring-Boot-Admin
- https://github.com/codecentric/spring-boot-admin
- 스프링 부트 Actuator UI 제공
- 어드민 서버 설정

    ```xml
    <dependency>
        <groupId>de.codecentric</groupId>
        <artifactId>spring-boot-admin-starter-server</artifactId>
        <version>2.5.4</version>
    </dependency>
    ```
  
    * @EnableAdminServer
- 클라이언트 설정

    ```xml
    <dependency>
        <groupId>de.codecentric</groupId>
        <artifactId>spring-boot-admin-starter-client</artifactId>
        <version>2.5.4</version>
    </dependency>
    ```
  
    * spring.boot.admin.client.url=http://localhost:8080
    * management.endpoints.web.exposure.include=*