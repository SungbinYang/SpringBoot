## 의존성 관리 이해
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-dependency-management
  * Java 1.8 as the default compiler level.
  * UTF-8 source encoding.
  * Compilation with -parameters.
  * A dependency management section, inherited from the spring-boot-dependencies POM, that manages the versions of common dependencies. This dependency management lets you omit <version> tags for those dependencies when used in your own POM.
  * An execution of the repackage goal with a repackage execution id.
  * Sensible resource filtering.
  * Sensible plugin configuration (Git commit ID, and shade).
  * Sensible resource filtering for application.properties and application.yml including profile-specific files (for example, application-dev.properties and application-dev.yml)

> 스프링부트가 의존성 관리를 해주기때문에 우리가 직접 관리해야 할 의존성의 수가 줄어든다.
> 즉, 우리의 일이 줄어드는것이다. 직접 전부 관리하면 spring버전이나 그 외 서드파티 라이브러리 버전을 올릴 시,
> 의존성들과 호환이 맞는지 일일이 비교를 해야한다. 이런 불편함을 스프링부트는 덜어주었다.
