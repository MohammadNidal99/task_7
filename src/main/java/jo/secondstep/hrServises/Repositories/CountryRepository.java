package jo.secondstep.hrServises.Repositories;

import org.springframework.data.repository.CrudRepository;

import jo.secondstep.hrServises.Entities.Country;

public interface CountryRepository extends CrudRepository<Country, String> {

}
