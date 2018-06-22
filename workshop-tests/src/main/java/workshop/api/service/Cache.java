package workshop.api.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class Cache {

	public boolean valid(String token) {
		boolean result = new Random(System.currentTimeMillis()).nextBoolean();
		return result;
	}
	
}
