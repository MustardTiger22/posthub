package com.tai.vikopru.service;

import com.tai.vikopru.dao.RoleDAO;
import com.tai.vikopru.dao.UserDAO;
import com.tai.vikopru.entity.Role;
import com.tai.vikopru.entity.User;
import com.tai.vikopru.validation.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDAO userDao;

    @Autowired
    private RoleDAO roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public User findByUserName(String userName) {
        // check the database if the user already exists
        return userDao.findByUserName(userName);
    }

    @Transactional
    public void save(CrmUser crmUser) {
        User user = new User();
        // assign user details to the user object
        user.setUsername(crmUser.getUserName());
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
        user.setFirstName(crmUser.getFirstName());
        user.setLastName(crmUser.getLastName());
        user.setEmail(crmUser.getEmail());

        // give user default role of "employee"
        user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_EMPLOYEE")));

        // save user in the database
        userDao.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
