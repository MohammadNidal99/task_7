package jo.secondstep.hrServises.Repositories;

import org.springframework.data.repository.CrudRepository;

import jo.secondstep.hrServises.Entities.Employees;

public interface EmployeeRepository extends CrudRepository<Employees, Integer> {

}
