## 테스트
- 시작은 일단 spring-boot-starter-test를 추가하는 것 부터
    * test 스콥으로 추가.
- @SpringBootTest
    * @RunWith(SpringRunner.class)랑 같이 써야 함. (JUnit 4 기반에서만)
    * 빈 설정 파일은 설정을 안해주나? 알아서 찾습니다. (@SpringBootApplication)
    * webEnvironment
        * MOCK: mock servlet environment. 내장 톰캣 구동 안 함.
        * RANDON_PORT, DEFINED_PORT: 내장 톰캣 사용 함.
        * NONE: 서블릿 환경 제공 안 함.
- @MockBean
    * ApplicationContext에 들어있는 빈을 Mock으로 만든 객체로 교체 함.
    * 모든 @Test 마다 자동으로 리셋.
- 슬라이스 테스트
    * 레이어 별로 잘라서 테스트하고 싶을 때
    * @JsonTest
    * @WebMvcTest
    * @WebFluxTest
    * @DataJpaTest

## 테스트 유틸
- OutputCapture : 테스트 콘솔 로그들을 캡쳐하여 테스트 할수있는 기능 (Junit4)
- CapturedOutput과 @ExtendWith(OutputCaptureExtension.class) : Junit5부터 사용

## Spring-Boot-Devtools
- 캐시 설정을 개발 환경에 맞게 변경.
- 클래스패스에 있는 파일이 변경 될 때마다 자동으로 재시작.
    * 직접 껐다 켜는거 (cold starts)보다 빠른다. 왜?
    * 릴로딩 보다는 느리다. (JRebel 같은건 아님)
    * 리스타트 하고 싶지 않은 리소스는? spring.devtools.restart.exclude
    * 리스타트 기능 끄려면? spring.devtools.restart.enabled = false
- 라이브 릴로드? 리스타트 했을 때 브라우저 자동 리프레시 하는 기능
    * 브라우저 플러그인 설치해야 함.
    * 라이브 릴로드 서버 끄려면? spring.devtools.liveload.enabled = false
- 글로벌 설정
    * ~/.spring-boot-devtools.properties