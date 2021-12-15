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