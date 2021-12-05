## 내장 웹 서버 응용: 컨테이너와 서버 포트
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-embedded-web-servers.html
- 다른 서블릿 컨테이너로 변경
- 웹 서버 사용 하지 않기
- 포트
    * server.port
    * 랜덤 포트
    * ApplicationListner<ServletWebServerInitializedEvent> : 서버의 정보를 활용할수 있음