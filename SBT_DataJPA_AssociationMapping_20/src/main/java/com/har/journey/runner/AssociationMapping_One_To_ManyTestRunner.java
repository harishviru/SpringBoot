package com.har.journey.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.model.Contract;
import com.har.journey.model.Vendor;
import com.har.journey.repo.ContractRepository;
import com.har.journey.repo.VendorRepository;
/*     OneToMany (multiplicity)
       Vendor ----<>Contract
*/
@Component
@Order(2)
public class AssociationMapping_One_To_ManyTestRunner  implements CommandLineRunner{

	@Autowired
	private VendorRepository vRepo;
	
	@Autowired
	private ContractRepository cRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Contract c1 =new Contract(701, "C1", 8000.0, "WATER PIPES");
		Contract c2 =new Contract(702, "C2", 4500.0, "ROAD EXT");
		Contract c3 =new Contract(703, "C3", 6000.0, "CLEAN STREET");
	
		Vendor v1 =new Vendor(8001, "Priya", "Hyd", List.of(c1,c2,c3));
		
		//child
		cRepo.save(c1);
		cRepo.save(c2);
		cRepo.save(c3);
		
		//Parent
		vRepo.save(v1);
		System.out.println("__________________(ONE_TO_MANY)________SUCCESSFULLY INSERTED____________________________");
	}

}
