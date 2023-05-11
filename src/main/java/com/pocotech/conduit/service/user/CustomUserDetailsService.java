package com.pocotech.conduit.service.user;

import com.pocotech.conduit.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.selectByEmail(email)
                .map(record -> new User(record.getUsername(), record.getPassword(), Collections.emptyList()))
                .orElseThrow(() -> new UsernameNotFoundException("User is not found: " + email));
    }
}
