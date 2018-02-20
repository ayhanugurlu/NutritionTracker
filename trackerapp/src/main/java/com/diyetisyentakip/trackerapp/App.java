package com.diyetisyentakip.trackerapp;

import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.diyetisyentakip.trackerapp.model.Company;
import com.diyetisyentakip.trackerapp.model.User;
import com.diyetisyentakip.trackerapp.model.UserRole;
import com.diyetisyentakip.trackerapp.model.WeightMeasurement;
import com.diyetisyentakip.trackerapp.repository.ICompanyRepository;
import com.diyetisyentakip.trackerapp.repository.IUserRepository;
import com.diyetisyentakip.trackerapp.repository.IUserRoleRepository;
import com.diyetisyentakip.trackerapp.repository.IWeightMeasurementRepository;


@SpringBootApplication
public class App implements CommandLineRunner{

	@Autowired
	private ICompanyRepository companyRepository;
	
	
	@Autowired
	private IWeightMeasurementRepository weightMeasurementRepository;
	
	@Autowired
	private IUserRoleRepository userRoleRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(App.class, args);
		
		System.out.println("Let's inspecOt the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
			
	}
	
	
	@Override
    public void run(String... args) throws Exception {
		
		userRoleRepository.deleteAllInBatch();
		userRepository.deleteAllInBatch();
		companyRepository.deleteAllInBatch();
		weightMeasurementRepository.deleteAllInBatch();
		
		UserRole nutritionist = new UserRole("Diyetisyen");
		UserRole client = new UserRole("Musteri");
		
		userRoleRepository.save(nutritionist);
		userRoleRepository.save(client);
		
		
		
		
		
		
		Company company = new Company();
		company.setName("Company 1");
		company.setPhone("00903123456778");
		
		companyRepository.save(company);
		
		User userClient = new User();
		userClient.setUsername("tatagoren");
		userClient.setUserRole(client);
		userClient.setCompany(company);
		
		
		User userNutritionist = new User();
		userNutritionist.setUsername("sedabakir");
		userNutritionist.setUserRole(nutritionist);
		userNutritionist.setCompany(company);
		
		userRepository.save(userClient);
		userRepository.save(userNutritionist);
		
		
		
		
		WeightMeasurement measurement1 = new WeightMeasurement();
		measurement1.setClient(userClient);
		measurement1.setNutritionist(userNutritionist);
		measurement1.setMeasurementDate(new DateTime(2018,2,1,0,0).toDate());
		measurement1.setWeight(93);
		
		WeightMeasurement measurement2 = new WeightMeasurement();
		measurement2.setClient(userClient);
		measurement2.setNutritionist(userNutritionist);
		measurement2.setMeasurementDate(new DateTime(2018,2,1,0,0).toDate());
		measurement2.setWeight(91);
		
		weightMeasurementRepository.save(measurement1);
		weightMeasurementRepository.save(measurement2);
		
		
		
		List<UserRole> userRoles = userRoleRepository.findAll();
		System.out.println(userRoles.get(0));
		
		System.err.println("Seed ok");
		
        /*
        
        userRoleRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();
        
        UserRole userRole = new UserRole();
		userRole.setRoleName("Deneme");
		
		
		User user1 = new User();
		user1.setUsername("Tan");
		user1.setUserRole(userRole);
		
		User user2 = new User();
		user2.setUsername("Seda");
		user2.setUserRole(userRole);
		
		
		
		userRole.getUsers().add(user1);
		userRole.getUsers().add(user2);
		
		userRoleRepository.save(userRole);
		*/
		
		
	}
}
