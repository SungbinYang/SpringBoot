## 내장 웹 서버 응용: 컨테이너와 서버 포트
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-embedded-web-servers.html
- 다른 서블릿 컨테이너로 변경
- 웹 서버 사용 하지 않기
- 포트
    * server.port
    * 랜덤 포트
    * ApplicationListner<ServletWebServerInitializedEvent> : 서버의 정보를 활용할수 있음

## 내장 웹 서버 응용 : HTTPS와 HTTP2
- https://opentutorials.org/course/228/4894
- https://gist.github.com/keesun/f93f0b83d7232137283450e08a53c4fd
- HTTPS 설정하기
  * 키스토어 만들기
  * HTTP는 못쓰네?
- HTTP 커넥터는 코딩으로 설정하기
  * https://github.com/spring-projects/spring-boot/tree/v2.0.3.RELEASE/spring-boot-samples/spring-boot-sample-tomcat-multi-connectors
- HTTP2 설정
  * server.http2.enable
  * 사용하는 서블릿 컨테이너 마다 다름.

## 톰캣 HTTP2
- JDK9와 Tomcat 9+ 추천
- 그 이하는 아래 링크 참고
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-embedded-web-servers.html#howto-configure-http2-tomcat

## 독립적으로 실행 가능한 JAR
- https://docs.spring.io/spring-boot/docs/current/reference/html/executable-jar.html
- “그러고 보니 JAR 파일 하나로 실행할 수 있네?”
  * mvn package를 하면 실행 가능한 JAR 파일 “하나가" 생성 됨.
  * spring-maven-plugin이 해주는 일 (패키징)
  * 과거 “uber” jar 를 사용
    * 모든 클래스 (의존성 및 애플리케이션)를 하나로 압축하는 방법
    * 뭐가 어디에서 온건지 알 수가 없음
      * 무슨 라이브러리를 쓰는건지..
    * 내용은 다르지만 이름이 같은 파일은 또 어떻게?
  * 스프링 부트의 전략
    * 내장 JAR : 기본적으로 자바에는 내장 JAR를 로딩하는 표준적인 방법이 없음.
    * 애플리케이션 클래스와 라이브러리 위치 구분
    * org.springframework.boot.loader.jar.JarFile을 사용해서 내장 JAR를 읽는다.
    * org.springframework.boot.loader.Launcher를 사용해서 실행한다.

## 스프링 부트 활용 소개

| 스프링 부트 핵심 기능 |각종 기술 연동|
|------|---|
| SpringApplication |스프링 웹 MVC|
| 외부 설정 |스프링 데이터|
| 프로파일 |스프링 시큐리티|
| 로깅 |REST API 클라이언트|
| 테스트 |테스트2|
| Spring-Dev-Tools |다루지 않은 내용들|