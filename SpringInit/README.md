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

## 프로파일
- @Profile 애노테이션은 어디에?
  * @Configuration
  * @Component
- 어떤 프로파일을 활성화 할 것인가?
  * spring.profiles.active
- 어떤 프로파일을 추가할 것인가?
  * spring.profiles.include (spring boot 2.4버전 이전)
  * spring.profiles.group."myprofile" (spring boot 2.4버전 이후)
- 프로파일용 프로퍼티
  * application-{profile}.properties

## 스프링 부트 기본 로거 설정
- 로깅 퍼사드 VS 로거
  * 로깅 퍼사드: Commons Logging, SLF4j
  * 로거: JUL, Log4J2, Logback
- 스프링 5에 로거 관련 변경 사항
  * https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/overview.html#overview-logging
  * Spring-JCL
    * Commons Logging -> SLF4j or Log4j2
    * pom.xml에 exclusion 안해도 됨.
- 스프링 부트 로깅
  * 기본 포맷
  * --debug (일부 핵심 라이브러리만 디버깅 모드로)
  * --trace (전부 다 디버깅 모드로)
  * 컬러 출력: spring.output.ansi.enabled
  * 파일 출력: logging.file.name 또는 logging.file.path
  * 로그 레벨 조정: logging.level.패지키 = 로그 레벨

## 로깅 : 커스터마이징
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html
- 커스텀 로그 설정 파일 사용하기
  * Logback: logback-spring.xml
  * Log4J2: log4j2-spring.xml
  * JUL (비추): logging.properties
  * Logback extension
    * 프로파일 <springProfile name=”프로파일”>
    * Environment 프로퍼티 <springProperty>
- 로거를 Log4j2로 변경하기
  * https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html#howto-configure-log4j-for-logging