package jo.secondstep.hrServises.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jo.secondstep.hrServises.Entities.Employees;
import jo.secondstep.hrServises.Repositories.EmployeeRepository;


@Controller
@RequestMapping(path = "/home")

public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping(path = "/add")
	public @ResponseBody String addEmployee() {
		
		Employees employee = new Employees();
		employee.setFirstName("Mohammad");
		employee.setLastName("Nidal");
		employee.setEmail("mmm@gmail.com");
		employee.setSalary(1550.00);
		employee.setHireDate("2021-10-11");
		employee.setJobID(5);
//		employee.setManagerID(114);
		employee.setDepartmentID(3);
		employee.setPhoneNumber("079.078.4566");
		
		employeeRepository.save(employee);
		
		return "Saved";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Employees> getEmployees(){
		return employeeRepository.findAll();
	}

}
