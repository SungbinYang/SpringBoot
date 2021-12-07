## SpringApplication 1부
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-spring-application.html#boot-features-spring-application
- 기본 로그 레벨 INFO
    * 뒤에 로깅 수업때 자세히 살펴볼 예정
- FailureAnalyzer
- 배너
    * banner.txt | gif | jpg | png
    * classpath 또는 spring.banner.location
    * ${spring-boot.version} 등의 변수를 사용할 수 있음.
    * Banner 클래스 구현하고 SpringApplication.setBanner()로 설정 가능.
    * 배너 끄는 방법
- SpringApplicationBuilder로 빌더 패턴 사용 가능

## Spring Application 2부
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-spring-application.html#boot-features-application-events-and-listeners
- ApplicationEvent 등록
  * ApplicationContext를 만들기 전에 사용하는 리스너는 @Bean으로 등록할 수 없다.
    * SpringApplication.addListners()
- WebApplicationType 설정
- 애플리케이션 아규먼트 사용하기
  * ApplicationArguments를 빈으로 등록해 주니까 가져다 쓰면 됨.
- 애플리케이션 실행한 뒤 뭔가 실행하고 싶을 때
  * ApplicationRunner (추천) 또는 CommandLineRunner
  * 순서 지정 가능 @Order

## 외부 설정 1부
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config
- 사용할 수 있는 외부 설정
  * properties
  * YAML
  * 환경 변수
  * 커맨드 라인 아규먼트
- 프로퍼티 우선 순위
  1. 유저 홈 디렉토리에 있는 spring-boot-dev-tools.properties
  2. 테스트에 있는 @TestPropertySource
  3. @SpringBootTest 애노테이션의 properties 애트리뷰트
  4. 커맨드 라인 아규먼트
  5. SPRING_APPLICATION_JSON (환경 변수 또는 시스템 프로티) 에 들어있는 프로퍼티
  6. ServletConfig 파라미터
  7. ServletContext 파라미터
  8. java:comp/env JNDI 애트리뷰트
  9. System.getProperties() 자바 시스템 프로퍼티
  10. OS 환경 변수
  11. RandomValuePropertySource
  12. JAR 밖에 있는 특정 프로파일용 application properties
  13. JAR 안에 있는 특정 프로파일용 application properties
  14. JAR 밖에 있는 application properties
  15. JAR 안에 있는 application properties
  16. @PropertySource
  17. 기본 프로퍼티 (SpringApplication.setDefaultProperties)
- application.properties 우선 순위 (높은게 낮은걸 덮어 씁니다.)
  * file:./config/
  * file:./
  * classpath:/config/
  * classpath:/
- 랜덤값 설정하기
  * ${random.*}
- 플레이스 홀더
  * name = sungbin
  * fullName = ${name} yang

## 외부 설정 2부
- 타입-세이프 프로퍼티 @ConfigurationProperties
  * 여러 프로퍼티를 묶어서 읽어올 수 있음
  * 빈으로 등록해서 다른 빈에 주입할 수 있음
    * @EnableConfigurationProperties
    * @Component
    * @Bean
  * 융통성 있는 바인딩
    * context-path (케밥)
    * context_path (언드스코어)
    * contextPath (캐멀)
    * CONTEXTPATH
  * 프로퍼티 타입 컨버전
    * @DurationUnit
  * 프로퍼티 값 검증
    * @Validated
    * JSR-303 (@NotNull, ...)
  * 메타 정보 생성
  * @Value
    * SpEL 을 사용할 수 있지만...
    * 위에 있는 기능들은 전부 사용 못합니다.