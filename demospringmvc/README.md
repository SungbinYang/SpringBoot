## 스프링 웹 MVC 1부: 소개
- 스프링 웹 MVC
    * https://docs.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/web.html#spring-web
- 스프링 부트 MVC
    * 자동 설정으로 제공하는 여러 기본 기능
- 스프링 MVC 확장
    * @Configuration + WebMvcConfigurer
- 스프링 MVC 재정의
    * @Configuration + @EnableWebMvc

## 스프링 웹 MVC: HttpMessageConverters
- https://docs.spring.io/spring-framework/docs/5.0.7.RELEASE/spring-framework-reference/web.html#mvc-config-message-converters
- HTTP 요청 본문을 객체로 변경하거나, 객체를 HTTP 응답 본문으로 변경할 때 사용.
  * {“username”:”sungbin”, “password”:”1234”} <-> User
    * @ReuqestBody
    * @ResponseBody

## 스프링 웹 MVC: ViewResolver
- 스프링 부트
  * 뷰 리졸버 설정 제공
  * HttpMessageConvertersAutoConfiguration
- XML 메시지 컨버터 추가하기
  
  ```xml
  <dependency>
   <groupId>com.fasterxml.jackson.dataformat</groupId>
   <artifactId>jackson-dataformat-xml</artifactId>
  </dependency>
  ```

## 스프링 웹 MVC: 정적 리소스 지원
- 정적 리소스 맵핑 “/**”
  * 기본 리소스 위치
    * classpath:/static
    * classpath:/public
    * classpath:/resources/
    * classpath:/META-INF/resources
    * 예) “/hello.html” => /static/hello.html
    * spring.mvc.static-path-pattern: 맵핑 설정 변경 가능
    * spring.mvc.static-locations: 리소스 찾을 위치 변경 가능
  * Last-Modified 헤더를 보고 304 응답을 보냄.
  * ResourceHttpRequestHandler가 처리함.
    * WebMvcConfigurer의 addRersourceHandlers로 커스터마이징 할 수 있음
    
  ```java
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
     registry.addResourceHandler("/m/**")
             .addResourceLocations("classpath:/m/")
             .setCachePeriod(20);
  }
  ```

## 스프링 웹 MVC: 웹JAR
- 웹JAR 맵핑 “/webjars/**” 
  * 버전 생략하고 사용하려면
    * webjars-locator-core 의존성 추가

  ```html
  <script src="/webjars/jquery/dist/jquery.min.js"></script>
  <script>
     $(function() {
         console.log("ready!");
     });
  </script>
  ```

## 스프링 웹 MVC: index 페이지와 파비콘
- 웰컴 페이지
  * index.html 찾아 보고 있으면 제공.
  * index.템플릿 찾아 보고 있으면 제공.
  * 둘 다 없으면 에러 페이지.
- 파비콘
  * favicon.ico
  * 파이콘 만들기 https://favicon.io/
  * 파비콘이 안 바뀔 때?
    * https://stackoverflow.com/questions/2208933/how-do-i-force-a-favicon-refresh