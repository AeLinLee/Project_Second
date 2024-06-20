package com.exam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterChainConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		//커스터마이징 처리
		
		//1. 불필요한 인증 제거
		http.authorizeRequests()
		    .antMatchers("/login","/mypage","/cartList","/main","/goodsRetrieve","/signup", "/webjars/**","/images/**","/idCheck","/update").permitAll()
		    .anyRequest()
		    .authenticated();
		
		//2.로그인 관련 작업
		http.csrf().disable();
		
		http.formLogin()    // 사용자가 만든 로그인화면으로 인증처리 하겠음.
		    .loginPage("/login")  //로그인 페이지로 갈 수 있는 요청맵핑값  <a href="login">로그인
		    .loginProcessingUrl("/auth")   //로그인폼에 있는 액션값
		    .usernameParameter("userid")    //<input name="userid">
	        .passwordParameter("passwd")        //<input name="passwd">
	        .failureForwardUrl("/login_fail")       //로그인 실패시 리다이렉트되는 요청맵핑값
//	        .successForwardUrl("/login_success");      
	        .defaultSuccessUrl("/main",true);        //로그인 성공시 리다이렉트되는 요청맵핑값
		
		
		//3. csrf 비활성화
		
		
		//4. 로그아웃 관련 작업
		http.logout()
		    .logoutUrl("/logout")   //security 가 자동으로 로그아웃 처리해주는 요청맵핑값
		    .logoutSuccessUrl("/main");    //로그아웃 성공시 리다이렉트되는 요청맵핑값
	        
		    return http.build();
	}
}
