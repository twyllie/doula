package com.doula.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.doula.models.User;
import com.doula.models.dao.RoleDao;
import com.doula.models.dao.UserDao;

@Service
public class MyUserService implements UserService{
	
	
	
    @Autowired
    private UserDao userDao;
    
    
    
    @Autowired
    private RoleDao roleDao;
    
    
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    

    @Override
    public void save(User user) {
        user.setPwHash(bCryptPasswordEncoder.encode(user.getPwHash()));
        user.setRoles(new HashSet<>(roleDao.findAll()));
        userDao.save(user);
    }
    
    

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}