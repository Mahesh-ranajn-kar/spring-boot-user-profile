package iasys.database;

import iasys.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u where u.email = :email")
    User findByEmail(@Param("email") String email);
}
