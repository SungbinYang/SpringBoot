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