package workshop.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import workshop.api.exception.InvalidTokenException;
import workshop.api.model.User;
import workshop.api.service.CurrentUser;

@RestController("user")
public class UserResource {

	@Autowired
	CurrentUser currentUser;

	@RequestMapping
	public ResponseEntity<User> get(@RequestParam(value = "token", defaultValue = "") String token) {

		if (token == null || token.isEmpty()) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}

		try {
			return new ResponseEntity<User>(currentUser.getUserByToken(token), HttpStatus.OK);
		} catch (InvalidTokenException e) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}

	}

}
