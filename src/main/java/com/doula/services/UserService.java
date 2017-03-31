package com.doula.services;

import com.doula.models.User;

public interface UserService {
	
	
	
    void save(User user, boolean admin);

    
    
    User findByEmail(String email);
}