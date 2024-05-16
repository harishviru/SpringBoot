package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.model.Person;
import com.har.journey.model.Profile;
import com.har.journey.repo.PersonRepository;
import com.har.journey.repo.ProfileRepository;

/*      OneToOne (multiplicity)
        Person ----<>Profile
*/

@Component
@Order(3)
public class AssociationMapping_One_To_OneTestRunner implements CommandLineRunner {

	@Autowired
	private PersonRepository psRepo;
	@Autowired
	private ProfileRepository prRepo;
	
	
	@Override
	public void run(String... args) throws Exception {

		Profile p1 =new Profile(40, "P1", "PANCARD", "ABCJ9398N", "HYD");
		Profile p2 =new Profile(41, "P2", "AADHAR", "98319871981", "BAN");
		Profile p3 =new Profile(42, "P3", "RATIONCARD", "ABIUABCJ98N", "CHN");
		
		prRepo.save(p1);
		prRepo.save(p2);
		prRepo.save(p3);
		
		Person pr1 =new Person(1501, "S", "H", "098719812", "MALE", p1);
		Person pr2 =new Person(1502, "I", "J", "371879128", "FEMALE", p2);
		Person pr3 =new Person(1503, "K", "L", "643512901", "MALE", p3);
		
		psRepo.save(pr1);
		psRepo.save(pr2);
		psRepo.save(pr3);
		
	 System.out.println("__________________(ONE_TO_ONE)________SUCCESSFULLY INSERTED____________________________");
	}

}
