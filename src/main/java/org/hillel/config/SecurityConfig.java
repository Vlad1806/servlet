package org.hillel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/tl/vehicles").hasRole("VIEW_VEHICLES")
                .antMatchers("/tl/vehicle/delete/*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/tl/vehicle/save").hasAnyRole( "VIEW_VEHICLES_ADD")
                .anyRequest().authenticated().and()
                .formLogin().defaultSuccessUrl("/tl/vehicles").and()
                .httpBasic(Customizer.withDefaults());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsServiceInDB(DataSource dataSource){
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//        if (!manager.userExists("admin")) {
//            manager.createUser(User.withUsername("admin").password("123").roles("ADMIN", "TICKET").build());
//        }
//        if (!manager.userExists("test")) {
//            manager.createUser(User.withUsername("test").password("test").authorities("ROLE_TICKET").build());
//        }
//        return manager;
//    }
//    @Bean
//    public UserDetailsService userDetailsServiceInMemory(){
//     return new InMemoryUserDetailsManager(
//             User.withUsername("admin").password("123").roles("ADMIN", "TICKET").build(),
//             User.withUsername("test").password("test").authorities("ROLE_TICKET").build()
//     );
//    }
}
