package iasys.services;

import iasys.database.UserRepo;
import iasys.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomePageService {

    @Autowired
    private UserRepo userRepo;

    public boolean saveUser(User user){
        try {
            userRepo.save(user);
            return true;
        }catch (Exception e){
           return false;
        }
    }
}
