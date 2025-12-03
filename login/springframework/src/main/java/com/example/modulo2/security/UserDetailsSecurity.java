package com.example.modulo2.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.modulo2.entities.User;
import com.example.modulo2.repository.UserRepository;

@Component
public class UserDetailsSecurity implements UserDetailsService {

    private final UserRepository userRepository;
    public UserDetailsSecurity(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("Username incorreto"));

        return new LoginUserDetails(user);
    }
}
