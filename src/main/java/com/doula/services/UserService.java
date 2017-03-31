package com.doula.services;

import com.doula.models.User;

public interface UserService {
	
	
	
    void save(User user);

    
    
    User findByEmail(String email);
}