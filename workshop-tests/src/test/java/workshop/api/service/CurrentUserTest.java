package workshop.api.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import workshop.api.exception.InvalidTokenException;
import workshop.api.model.User;
import workshop.api.service.Cache;
import workshop.api.service.CurrentUser;

@RunWith(MockitoJUnitRunner.class)
public class CurrentUserTest {

	// O que acontece se tirar esse @Mock? Porquê?
	@Mock
	Cache cache;

	@InjectMocks
	CurrentUser currentUser;

	@Before
	public void setUp() {
		
		// Precisa disso? Porquê?
		MockitoAnnotations.initMocks(this);
		
		when(cache.valid(Mockito.any(String.class))).thenReturn(true);
		
		// O que acontece se tirar essa parte? Porquê?
		ReflectionTestUtils.setField(currentUser, "uniqueUserName", "test fake user");
		
	}

	@Test
	public void getCurrentUser() throws InvalidTokenException {

		User user = currentUser.getUserByToken("12312321");

		assertNotNull(user);
		assertNotNull(user.getName());
		assertNotNull(user.getEmail());
		assertNotNull(user.getPassword());

	}

}
