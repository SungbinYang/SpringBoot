## 스프링 웹 MVC: Thymeleaf
- 스프링 부트가 자동 설정을 지원하는 템플릿 엔진
    * FreeMarker
    * Groovy
    * Thymeleaf
    * Mustache
- JSP를 권장하지 않는 이유
    * JAR 패키징 할 때는 동작하지 않고, WAR 패키징 해야 함.
    * Undertow는 JSP를 지원하지 않음.
    * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-jsp-limitations
- Thymeleaf 사용하기
    * https://www.thymeleaf.org/
    * https://www.thymeleaf.org/doc/articles/standarddialect5minutes.html
    * 의존성 추가: spring-boot-starter-thymeleaf
    * 템플릿 파일 위치: /src/main/resources/template/
    * 예제: https://github.com/thymeleaf/thymeleafexamples-stsm/blob/3.0-master/src/main/webapp/WEB-INF/templates/seedstartermng.html

## 스프링 웹 MVC: HtmlUnit
- HTML 템플릿 뷰 테스트를 보다 전문적으로 하자.
  * http://htmlunit.sourceforge.net/
  * http://htmlunit.sourceforge.net/gettingStarted.html
  * 의존성 추가

  ```xml
  <dependency>
     <groupId>org.seleniumhq.selenium</groupId>
     <artifactId>htmlunit-driver</artifactId>
     <scope>test</scope>
  </dependency>
  <dependency>
     <groupId>net.sourceforge.htmlunit</groupId>
     <artifactId>htmlunit</artifactId>
     <scope>test</scope>
  </dependency>
  ```
  
  * @Autowire WebClient  