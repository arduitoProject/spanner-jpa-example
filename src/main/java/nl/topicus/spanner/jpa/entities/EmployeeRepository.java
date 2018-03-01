package nl.topicus.spanner.jpa.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    Optional<Employee> findByEmployeeId(String id);

}
