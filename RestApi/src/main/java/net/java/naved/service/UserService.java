package net.java.naved.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.java.naved.model.User;

@Service
public class UserService {

	private List<User> userList;
	
	public UserService() {
		userList=new ArrayList<>();
		User user1=new User(1,"Ida",32,"ida@gmail.com");
		User user2=new User(2,"Hans",32,"hens@gmail.com");
		User user3=new User(3,"Lars",32,"lars@gmail.com");
		User user4=new User(4,"Ben",32,"ben@gmail.com");
		User user5=new User(5,"Eva",32,"eva@gmail.com");
		
		userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
	}
	public List<User> getusers(){
		return userList;
	}
	
	public List<User> getUsers() {
        return userList;
    }
	
	public Optional<User>  getUser(long id) {
		//Optional optional=Optional.empty();
		for(User user: userList) {
			if(id==user.getId()) {
				return Optional.of(user);
			}
		}
		return Optional.empty();
	}
	public void addUser(User user) {
		userList.add(user);
	}
	public void printAllUsers() {
        System.out.println("List of Users:");
        for (User user : userList) {
            System.out.println(user.getId() + ": " + user.getName() + " - " + user.getEmail());
        }
    }
}
