package edu.mum.apms.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import edu.mum.apms.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	private static final int TOKEN_VALIDITY_SECONDS = 86400; // 1 day
	
	@Autowired
    private UserDetailsService userDetailsService;

	@Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;
    
    @Autowired
    private CustomAuthentication cauth;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//      auth.jdbcAuthentication().dataSource(dataSource)
//		     .usersByUsernameQuery(
//		      "select email ,password from user where username=?")
//		     .authoritiesByUsernameQuery(
//		      "select id, role from user_role where username=?");
//    } 
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        String errorMsg = "Error";
        String accessDeniedMsg = "Access Denied!";
        
        http.authorizeRequests()
		.antMatchers("/", "/resources/**", "/register","/authenticate","/projects","/projects/**","/**")
		.permitAll()
    	//.antMatchers("/projects").hasRole("SCRUMMASTER")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.successHandler(cauth)
		.loginPage("/")
		.permitAll()
		.and()
		.logout()
		.deleteCookies("remember-me")
		.permitAll()
		.and()
		.rememberMe()
		.tokenValiditySeconds(TOKEN_VALIDITY_SECONDS);
        
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/", "/authenticate").permitAll()
//                .anyRequest().authenticated();
//        http.formLogin().loginPage("/").usernameParameter("email").passwordParameter("password");
//		http.formLogin().defaultSuccessUrl("/").failureUrl("/"+errorMsg);
//		http.logout().logoutSuccessUrl("/");
//		http.exceptionHandling().accessDeniedPage("/"+accessDeniedMsg);
//		http.authorizeRequests().antMatchers("/").permitAll();
//		http.authorizeRequests().antMatchers("/register").permitAll();	
//		http.authorizeRequests().antMatchers("/authenticate").permitAll();		
		
		http
        .authorizeRequests()
        	.antMatchers("/projects/manage").hasAnyRole("ANONYMOUS","ROLE_ANONYMOUS")
//    		.antMatchers("/authenticate").access("hasRole('ROLE_SCRUMMASTER')")
//    		.antMatchers("/order/all*").access("hasRole('ROLE_ADMIN')")
//    		.antMatchers("/person/all").access("hasRole('ROLE_ADMIN')")
//    		.antMatchers("/person/**").access("hasRole('ROLE_USER')")
//            .antMatchers("/static/**", "/", "/home", "/index", "/css/**", "/fonts/**", "/js/**", "/images/**", "**/favicon.ico").permitAll()
//            .antMatchers("/static/**", "/css/**", "/fonts/**", "/js/**", "/images/**", "**/favicon.ico").anonymous()
            ;//
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/easypiechart/**", "/bootstrap-3.0.3/**" , "/js/**", "/images/**");
	}

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
        auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery);
    }

}
