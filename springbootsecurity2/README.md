## 스프링 시큐리티: 시큐리티 설정 커스터마이징
1. 웹 시큐리티 설정

    ```java
    @Configuration
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests()
                    .antMatchers("/", "/hello").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .and()
                    .httpBasic();
        }
    
        @Bean
        public PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }
    }
    ```
   
2. UserDetailsServie 구현
3. PasswordEncoder 설정 및 사용