package nl.topicus.spanner.jpa;

import nl.topicus.spanner.jpa.entities.Employee;
import nl.topicus.spanner.jpa.entities.EmployeeRepository;
import nl.topicus.spanner.jpa.entities.Phone;
import nl.topicus.spanner.jpa.entities.PhoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Application
{
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository employeeRepo, PhoneRepository phoneRepo)
	{
		return (args) -> {


			//log.info("[CREATE COMPANY]");
			// reset repositories
			//employeeRepo.deleteAll(); //this line too generate the error
			//phoneRepo.deleteAll();
			//employeeRepo.deleteAll();
			log.info("[CREATE EMPLOYEE]");
			// create employee
			List<Phone> phones = new ArrayList<Phone>();
			phones.add(new Phone(getUuid(), 54111111));
			phones.add(new Phone(getUuid(), 54222222));
			String companyId = "AAAA";
			Employee.Pk pk1 = new Employee.Pk(companyId, getUuid());
			Employee emp_ = employeeRepo.save(new Employee(pk1, "Jack", "Bauer", phones ));


			Employee emp = employeeRepo.findOne(pk1);

			Iterator it = emp.getPhones().iterator();
			while (it.hasNext()) {
				Phone phone = (Phone) it.next();
				log.info("[phone]>> " + phone.getNumber());
			}


			log.info("-------------------------------");
			log.info("[employee]>>> pk.employeeId: " + emp.getPk().getEmployeeId() + " pk.companyId: " + emp.getPk().getCompanyId() + "name: " + emp.getName() + " lastname: " + emp.getLastname());
			log.info("-------------------------------");


			log.info("[UPDATE EMPLOYEE]");
			phones.clear();
			//phones.add(new Phone(getUuid(), 54333333));
			//phones.add(new Phone(getUuid(), 54444444));

			//THIS LINE PRODUCE A EXCEPTION INVALID_ARGUMENT: No matching signature for operator = for argument types: STRING, BOOL. Supported signature: ANY = ANY
			Employee emp2_ = employeeRepo.save(new Employee(pk1, "Jack", "Nicholson", phones ));

			Employee empUpdate  = employeeRepo.findOne(pk1);


			log.info("-------------------------------");
			log.info("[employee]>>> pk.employeeId: " + empUpdate.getPk().getEmployeeId() + " pk.companyId: " + empUpdate.getPk().getCompanyId() + "name: " + empUpdate.getName() + " lastname: " + empUpdate.getLastname());
			log.info("-------------------------------");
			log.info("----> END");

		};

	}



	public static String getUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
