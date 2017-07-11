package tiy.com.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
        		.authorizeRequests()
	                .antMatchers("/**").permitAll()
	                .anyRequest().authenticated()
//	                .and() //aggregates the rules // don't need .formLogin for APIs
//                .formLogin()
//	                .loginPage("/login")
//	                .permitAll()
	                .and()
                .logout()
                	.permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("john").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("kayla").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("brian").password("password").roles("USER");
    }
}
