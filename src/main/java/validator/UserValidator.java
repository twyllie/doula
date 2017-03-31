package validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.doula.models.User;
import com.doula.services.UserService;

@Component
public class UserValidator implements Validator {
	
	
	
    @Autowired
    private UserService userService;

    
    
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    
    
    @Override
    public void validate(Object o, Errors errors) {    	
    	
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getEmail().length() < 6 || user.getEmail().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPwHash().length() < 8 || user.getPwHash().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

    }
    
    
    
    
    public boolean validateEmail(String email){
    	
    	if(!User.isValidEmail(email)){
			return false;
		}
    	return true;
    }
    
    
    
    public boolean validatePassword(String password){
    	if(!User.isValidPassword(password)){
			return false;
		}
    	return true;
    }
    
    
    
    public boolean isDuplicate(String email){
    	if(userService.findByEmail(email) != null){
			return false;
		}
    	return true;
    	
    }
}