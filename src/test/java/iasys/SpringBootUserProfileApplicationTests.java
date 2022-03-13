package iasys;

import iasys.database.UserRepo;
import iasys.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootUserProfileApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {



	}

	@Test
	public void findEmail(){
		String email = "tanu@gmail.com";
		User user = userRepo.findByEmail(email);
		System.out.println(user);

		assertThat(user).isNotNull();
	}

}
