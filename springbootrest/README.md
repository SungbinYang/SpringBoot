## 스프링 REST 클라이언트: RestTemplate과 WebClient
- RestTemplate
    * Blocking I/O 기반의 Synchronous API 
    * RestTemplateAutoConfiguration
    * 프로젝트에 spring-web 모듈이 있다면 RestTemplateBuilder를 빈으로 등록해 줍니다.
    * https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#rest-client-access
- WebClient
    * Non-Blocking I/O 기반의 Asynchronous API
    * WebClientAutoConfiguration
    * 프로젝트에 spring-webflux 모듈이 있다면 WebClient.Builder를 빈으로 등록해 줍니다.
    * https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-client

## 스프링 REST 클라이언트: 커스터마이징
- RestTemplate
  * 기본으로 java.net.HttpURLConnection 사용.
  * 커스터마이징
    * 로컬 커스터마이징
    * 글로벌 커스터마이징
      * RestTemplateCustomizer
      * 빈 재정의
- WebClient
  * 기본으로 Reactor Netty의 HTTP 클라이언트 사용.
  * 커스터마이징
    * 로컬 커스터마이징
    * 글로벌 커스터마이징
      * WebClientCustomizer
      * 빈 재정의

## 그밖에 다양한 기술 연동
- 캐시
- 메시징
- Validation
- 이메일 전송
- JTA
- 스프링 인티그레이션
- 스프링 세션
- JMX
- 웹소켓
- 코틀린