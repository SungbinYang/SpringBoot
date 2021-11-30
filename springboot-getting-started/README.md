## 스프링 부트 소개
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-introducing-spring-boot
    * Provide a radically faster and widely accessible getting-started experience for all Spring development.
    * Be opinionated out of the box but get out of the way quickly as requirements start to diverge from the defaults.
    * Provide a range of non-functional features that are common to large classes of projects (such as embedded servers, security, metrics, health checks, and externalized configuration).
    * Absolutely no code generation and no requirement for XML configuration.

## 스프링 부트 시작하기
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-maven-installation
  - 메이븐 pom.xml에 parent, dependency, plugin 설정.
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
  
        <groupId>me.sungbin</groupId>
        <artifactId>springboot-getting-started</artifactId>
        <version>1.0-SNAPSHOT</version>
  
        <properties>
            <maven.compiler.source>17</maven.compiler.source>
            <maven.compiler.target>17</maven.compiler.target>
        </properties>
  
        <parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.6.1</version>
        </parent>
  
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>
        </dependencies>
  
        <build>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                </plugin>
            </plugins>
        </build>
    </project>
    ```
## 스프링 부트 프로젝트 생성기
- https://start.spring.io/

![](./img01.png)