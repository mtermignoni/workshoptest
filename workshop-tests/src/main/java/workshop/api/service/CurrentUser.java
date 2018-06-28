package workshop.api.service;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import workshop.api.exception.InvalidTokenException;
import workshop.api.model.User;

@Service
public class CurrentUser {
	
	@Value("${uniqueUserName}")
	private String uniqueUserName;
	
	@Autowired
	Cache cache;

	@Autowired
	UserClient userClient;

	public String getUserClient() {
		try {
			userClient.getResponseJsonSuccess();
			return "-OK- RETORNO!!!";
		} catch(FeignException e) {
			return "-OFF- RETORNO!!!";
		}
	}

		public User getUserByToken(String token) throws InvalidTokenException {
		
		if (!cache.valid(token)) {
			throw new InvalidTokenException();
		}

		return User.builder()
				.email("email@email.com")
				.name(uniqueUserName)
				.password("12321321312").build();
	}
	
}
