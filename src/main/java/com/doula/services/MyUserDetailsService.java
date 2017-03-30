import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doula.models.User;
import com.doula.models.dao.UserDao;

@Service
public class MyUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserDao userDao;
 
    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new MyUserPrincipal(user);
    }
}