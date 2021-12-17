## 스프링 데이터: 스프링 데이터 JPA 소개
- ORM(Object-Relational Mapping)과 JPA (Java Persistence API)
    * 객체와 릴레이션을 맵핑할 때 발생하는 개념적 불일치를 해결하는 프레임워크
    * http://hibernate.org/orm/what-is-an-orm/
    * JPA: ORM을 위한 자바 (EE) 표준
- 스프링 데이터 JPA
    * Repository 빈 자동 생성
    * 쿼리 메소드 자동 구현
    * @EnableJpaRepositories (스프링 부트가 자동으로 설정 해줌.)
    * SDJ -> JPA -> Hibernate -> Datasource

## 스프링 데이터: Spring-Data-JPA 연동
- 스프링 데이터 JPA 의존성 추가

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

- 스프링 데이터 JPA 사용하기
  * @Entity 클래스 만들기
  * Repository 만들기
- 스프링 데이터 리파지토리 테스트 만들기
  * H2 DB를 테스트 의존성에 추가하기
  * @DataJpaTest (슬라이스 테스트) 작성

## 스프링 데이터: 데이터베이스 초기화
- JPA를 사용한 데이터베이스 초기화
  * spring.jpa.hibernate.ddl-auto
  * spring.jpa.generate-dll=true로 설정 해줘야 동작함.
- SQL 스크립트를 사용한 데이터베이스 초기화
  * schema.sql 또는 schema-${platform}.sql
  * data.sql 또는 data-${platform}.sql
  * ${platform} 값은 spring.datasource.platform 으로 설정 가능.

## 스프링 데이터: 데이터베이스 마이그레이션
- Flyway와 Liquibase가 대표적인데, 지금은 Flyway를 사용하겠습니다.
- https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup
- 의존성 추가
  * org.flywaydb:flyway-core
  * 버전은 5.2.4
- 마이그레이션 디렉토리
  * db/migration 또는 db/migration/{vendor}
  * spring.flyway.locations로 변경 가능
- 마이그레이션 파일 이름
  * V숫자__이름.sql
  * V는 꼭 대문자로.
  * 숫자는 순차적으로 (타임스탬프 권장)
  * 숫자와 이름 사이에 언더바 두 개.
  * 이름은 가능한 서술적으로.