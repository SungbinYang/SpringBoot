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