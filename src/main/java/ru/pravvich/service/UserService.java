package ru.pravvich.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.pravvich.domain.Role;
import ru.pravvich.domain.User;
import ru.pravvich.repository.RoleRepository;
import ru.pravvich.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Pavel Ravvich.
 * Created : 20.08.17.
 */
@Component
public class UserService implements UserDetailsService {

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final User user = userRepo.findByUsername(username);

        final Role role = roleRepo.findOne(user.getRoleId());

        final List<Role> authorities = new ArrayList<>();

        authorities.add(role);

        user.setAuthorities(authorities);

        return user;
    }
}
