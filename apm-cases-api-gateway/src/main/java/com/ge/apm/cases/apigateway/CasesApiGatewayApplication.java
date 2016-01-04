package com.ge.apm.cases.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class CasesApiGatewayApplication  {

    public static void main(String[] args) {
        SpringApplication.run(CasesApiGatewayApplication.class, args);
    }

//    @Configuration
//    protected static class SecurityConfiguration extends OAuth2SsoConfigurerAdapter {
//
//        @Override
//        public void match(OAuth2SsoConfigurer.RequestMatchers matchers) {
//            matchers.anyRequest();
//        }
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http.logout().and().antMatcher("/**").authorizeRequests()
//                    .antMatchers("/index.html", "/home.html", "/", "/login", "/beans").permitAll()
//                    .antMatchers(HttpMethod.GET, "/recommendations/**","/reviews/**","/people/**","/movie/**","/catalog/**","/likes/**").permitAll()
//                    .anyRequest().authenticated().and().csrf()
//                    .csrfTokenRepository(csrfTokenRepository()).and()
//                    .addFilterBefore(new RequestContextFilter(), HeaderWriterFilter.class)
//                    .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
//        }
//
//        private Filter csrfHeaderFilter() {
//            return new OncePerRequestFilter() {
//                @Override
//                protected void doFilterInternal(HttpServletRequest request,
//                                                HttpServletResponse response, FilterChain filterChain)
//                        throws ServletException, IOException {
//                    CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
//                            .getName());
//                    if (csrf != null) {
//                        Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
//                        String token = csrf.getToken();
//                        if (cookie == null || token != null
//                                && !token.equals(cookie.getValue())) {
//                            cookie = new Cookie("XSRF-TOKEN", token);
//                            cookie.setPath("/");
//                            response.addCookie(cookie);
//                        }
//                    }
//                    filterChain.doFilter(request, response);
//                }
//            };
//        }
//
//        private CsrfTokenRepository csrfTokenRepository() {
//            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//            repository.setHeaderName("X-XSRF-TOKEN");
//            return repository;
//        }
//
//    }
}
