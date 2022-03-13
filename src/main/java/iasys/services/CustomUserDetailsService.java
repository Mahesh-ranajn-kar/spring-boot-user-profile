package iasys.services;

import iasys.database.UserRepo;
import iasys.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println(email);
        User user = userRepo.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Email not found");
        }
        else {
            return new CustomUserDetails(user);
        }

    }
}
