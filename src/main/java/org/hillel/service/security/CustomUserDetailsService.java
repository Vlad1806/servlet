package org.hillel.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        final String sql = "SELECT password, active FROM client WHERE email = ?";
        final String sqlgetRoles = "Select authority from authorities where username = ?";
        Pair<String, Boolean> passwordAndActive = jdbcTemplate.queryForObject(sql,
                (row, iteration) -> Pair.of(row.getString(1), row.getBoolean(2)), email);

        List<String> authorities = jdbcTemplate.queryForList(sqlgetRoles, String.class, email);

        User.UserBuilder builder = User.builder();
        return builder.password(passwordAndActive.getFirst())
                .username(email)
                .disabled(!passwordAndActive.getSecond())
                .authorities(authorities.toArray(String[]::new)).build();
    }
}
