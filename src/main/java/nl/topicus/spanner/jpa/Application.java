package nl.topicus.spanner.jpa;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import nl.topicus.spanner.jpa.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

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
			Employee emp_ = employeeRepo.save(new Employee(companyId, getUuid(), "Jack", "Bauer", phones ));


			EmployeeId empId_ = new EmployeeId(companyId, emp_.getEmployeeId());

			Employee emp = employeeRepo.findOne(empId_);

			Iterator it = emp.getPhones().iterator();
			while (it.hasNext()) {
				Phone phone = (Phone) it.next();
				log.info("[phone]>> " + phone.getNumber());
			}


			log.info("-------------------------------");
			log.info("[employee]>>> id: " + emp.getEmployeeId() + "name: " + emp.getName() + " lastname: " + emp.getLastname());
			log.info("-------------------------------");



			log.info("[UPDATE EMPLOYEE]");
			phones.clear();
			//phones.add(new Phone(getUuid(), 54333333));
			//phones.add(new Phone(getUuid(), 54444444));

			//THIS LINE PRODUCE A EXCEPTION INVALID_ARGUMENT: No matching signature for operator = for argument types: STRING, BOOL. Supported signature: ANY = ANY
			Employee emp2_ = employeeRepo.save(new Employee("AAAA",emp.getEmployeeId(), "Jack", "Nicholson", phones ));
			EmployeeId empId2_ = new EmployeeId(companyId, emp2_.getEmployeeId());

			Employee empUpdate  = employeeRepo.findOne(empId2_);


			log.info("-------------------------------");
			log.info("[employee]>>> id: " + empUpdate.getEmployeeId() + "name: " + empUpdate.getName() + " lastname: " + empUpdate.getLastname());
			log.info("-------------------------------");
			log.info("----> END");

		};

	}



	public static String getUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
