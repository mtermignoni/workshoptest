package workshop.api.service;

import feign.FeignException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import workshop.api.exception.InvalidTokenException;
import workshop.api.model.User;

@Service
public class FeignServiceTest {
	


	@Autowired
	CurrentUser currentUser;

	@Test
	public void deveTerSucesso() {

		String result = currentUser.getUserClient();

		//Assert.assertThat(result, "texto");
		Assert.assertNotNull(result);
	}


}
