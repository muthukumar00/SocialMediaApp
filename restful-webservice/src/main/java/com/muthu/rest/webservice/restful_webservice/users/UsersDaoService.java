package com.muthu.rest.webservice.restful_webservice.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UsersDaoService {

	
	private static List<Users> users = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		users.add(new Users(userCount++, "Muthu", LocalDate.now().minusYears(30)));
		users.add(new Users(userCount++, "Pravin", LocalDate.now().minusYears(25)));
		users.add(new Users(userCount++, "Jim", LocalDate.now().minusYears(20)));
		
	}
	
	public List<Users> findAll() {
		return users;
	}
	
	public Users findByID(Integer id) {
		Predicate<? super Users> predicate = user -> user.getId().equals(id);
		
			Users returnUser = users.stream().filter(predicate).findFirst().orElse(null);
			return returnUser;
//			if(returnUser.size() >= 1) {
//				
//			}
//			else {
//				return new Users();
//			}
			
		
	}

	public Users save(Users user) {
		// TODO Auto-generated method stub
		user.setId(userCount++);
		users.add(user);
		return user;
	}

}
