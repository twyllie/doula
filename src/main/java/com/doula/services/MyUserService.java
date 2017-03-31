package com.doula.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doula.models.Role;
import com.doula.models.User;
import com.doula.models.dao.PlanDao;
import com.doula.models.dao.RoleDao;
import com.doula.models.dao.UserDao;

@Service
public class MyUserService implements UserService{
	
	
	
    @Autowired
    private UserDao userDao;
    
    
    
    @Autowired
    private PlanDao planDao;
    
    
    
    @Autowired
    private RoleDao roleDao;
    
    
    

    @Override
    public void save(User user, boolean admin) {
    	
    	if(admin){
    		Set<Role> roles = new HashSet<>();
    		Role adminR = this.createRoleIfNotFound("ROLE_ADMIN");
    		Role userR = this.createRoleIfNotFound("ROLE_USER");
    		roles.add(adminR);
    		roles.add(userR);
    		user.setRoles(roles);
    		planDao.save(user.getPlan());
            userDao.save(user);
            return;
    		
    	}else{
    		Set<Role> roles = new HashSet<>();
    		Role userR = this.createRoleIfNotFound("ROLE_USER");
    		roles.add(userR);
    		user.setRoles(roles);
            planDao.save(user.getPlan());
            userDao.save(user);
            return;
    	}  
    }
    
    

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
    
    private Role createRoleIfNotFound(String name) {
    	  
    	        Role role = roleDao.findByName(name);
    	        if (role == null) {
    	            role = new Role(name);
    	            roleDao.save(role);
    	        }
    	        return role;
    	    }
}