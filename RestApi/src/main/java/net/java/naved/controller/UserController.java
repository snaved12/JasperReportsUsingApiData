package net.java.naved.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.java.naved.model.User;
import net.java.naved.service.UserService;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
public class UserController {
	
	
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	
	@GetMapping
	public List<User> getUser(){
		return userService.getUser();
		
	}
	
	@GetMapping("{id}")
	public User getUser(@PathVariable Integer id){
		return userService.getUser(id).orElse(null);
	}
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		userService.addUser(user);
		
		try {
			List<User> users = userService.getUsers();

			
	        for (User us : users) {
	            System.out.println("User ID: " + us.getId());
	            System.out.println("Name: " + us.getName());
	            System.out.println("Age: " + us.getAge());
	            System.out.println("Email: " + us.getEmail());
	            System.out.println("----------------------------");
	        }
        	String filePath="C:\\Users\\ssyed\\Documents\\workspace-spring-tool-suite-4-4.20.0.RELEASE\\RestApi\\src\\main\\resources\\api.jrxml";
			
			JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(users);
			
			Map<String,Object> parameters=new HashMap<String,Object>();
			parameters.put("dataset",dataSource);
			
			JasperReport report=JasperCompileManager.compileReport(filePath);
			JasperPrint print=JasperFillManager.fillReport(report,parameters,new JREmptyDataSource());
			
			JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\ssyed\\OneDrive\\Desktop\\SCOREME\\api.pdf");
			System.out.println("Report Created");
			
		}catch(Exception e) {
		System.out.println("Exception while creating report");
	}
		
		return user;
	}
	
}

