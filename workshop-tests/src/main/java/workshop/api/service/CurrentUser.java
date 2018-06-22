package workshop.api.service;

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
