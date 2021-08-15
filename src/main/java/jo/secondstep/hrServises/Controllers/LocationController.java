package jo.secondstep.hrServises.Controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jo.secondstep.hrServises.Entities.Country;
import jo.secondstep.hrServises.Entities.Location;
import jo.secondstep.hrServises.Entities.Region;
import jo.secondstep.hrServises.Repositories.CountryRepository;
import jo.secondstep.hrServises.Repositories.LocationRepository;
import jo.secondstep.hrServises.Repositories.RegionRepository;

//@Controller
@RestController
@RequestMapping(path="/hrServices")
public class LocationController {
	
	@Autowired
	RegionRepository regionRepository;
	@Autowired
	CountryRepository countryRepository;
	@Autowired
	LocationRepository locationRepository;
	
	@GetMapping(path = "/addRegion")
	public @ResponseBody String addRegion(@RequestParam String name) {
		Region region = new Region();
		
		region.setName(name);
		regionRepository.save(region);
		return name + " Region Saved Successfully";
	}
	
	@GetMapping(path = "/deleteRegion")
	public @ResponseBody String deleteRegion(@RequestParam Integer id) {
		
		regionRepository.deleteById(id);
		return " Region Deleted Successfully";
	}
//	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(path = "/allRegion")
	public @ResponseBody List<Region> gerRegions() {
		
		return (List<Region>) regionRepository.findAll();
	}
	
	@GetMapping(path = "/region")
	public @ResponseBody Optional<Region> getRegion(@RequestParam Integer id) {
		
		return regionRepository.findById(id);
	}
	
	@GetMapping(path = "/updateRegion")
	public @ResponseBody String updateRegion(@RequestParam Integer id, @RequestParam String name) {
		
		Region region = regionRepository.findById(id).get();
		region.setName(name);
		regionRepository.save(region);
		
		return "Region Updated Successfully";
	}
	
//--------------------------------------- Country -----------------------------------------------------	
	
	@GetMapping(path = "/addCountry")
	public @ResponseBody String addCountry(@RequestParam String name, @RequestParam Integer regionID) {
		
		Region region = regionRepository.findById(regionID).get();
		Country country = new Country();
		country.setId(name.substring(0,2).toUpperCase());	//let user enter the id of country	
		country.setName(name);
		country.setRegion(region);
		countryRepository.save(country);
		
		return "Country Added Successfully";
	}
	
	@GetMapping(path = "/deleteCountry")
	public @ResponseBody String deleteCountry(@RequestParam String id) {
		
		countryRepository.deleteById(id);
		return "Country Deleted Successfully";
	}
	
	@GetMapping(path = "/allCountries")
	public @ResponseBody List<Country> allCountries() {
			
		return (List<Country>) countryRepository.findAll();
	}
	
	@GetMapping(path = "/country")
	public @ResponseBody Optional<Country> getCountry(@RequestParam String id) {
		
		return countryRepository.findById(id);
	}
	
	@GetMapping(path = "/updateCountry")
	public @ResponseBody String updateCountry(@RequestParam String id, @RequestParam String name, @RequestParam Integer regionID) {
		
		Country country = countryRepository.findById(id).get();
		country.setName(name);
		Region region = regionRepository.findById(regionID).get();
		country.setRegion(region);
		countryRepository.save(country);
		
		return "Country Updated Successfully";
	}
//------------------------------------------- Location ------------------------------------------	
	@GetMapping(path = "/addLocation")
	public @ResponseBody String addLocation(@RequestParam String streetAddress, @RequestParam String postalCode,@RequestParam String city,
											@RequestParam String stateProvince, @RequestParam String countryID) {
		
		Country country = countryRepository.findById(countryID).get();
		Location location = new Location();
		location.setStreetAddress(streetAddress);
		location.setPostalCode(postalCode);
		location.setCity(city);
		location.setStateProvince(stateProvince);
		location.setCountry(country);
		locationRepository.save(location);
		
		return "Location Added Successfully";
	}
	
	@GetMapping(path = "/deleteLocation")
	public @ResponseBody String deleteLocation(@RequestParam Integer id) {
		
		locationRepository.deleteById(id);
		
		return "Location Deleted Successfully";
	}
	
	@GetMapping(path = "/allLocations")
	public @ResponseBody List<Location> allLocations() {
			
		return (List<Location>) locationRepository.findAll();
	}
	
	@GetMapping(path = "/location")
	public @ResponseBody Optional<Location> getLocation(@RequestParam Integer id) {
		
		return locationRepository.findById(id);
	}
	
	@GetMapping(path = "/updateLocation")
	public @ResponseBody String updateLocation(@RequestParam Integer id, @RequestParam String city,
											   @RequestParam String stateProvince, @RequestParam String countryID) {
		
		Location location = locationRepository.findById(id).get();
		location.setCity(city);
		location.setStateProvince(stateProvince);
		Country country = countryRepository.findById(countryID).get();
		location.setCountry(country);
		locationRepository.save(location);
		
		return "Location Updated Successfully";
	}
	
	
	
	
	@RequestMapping(path = "/addCountryForm", method = RequestMethod.POST)
	public Country countryForm(@RequestParam("countryCode") String countryCode, @RequestParam("countryName") String countryName,  @RequestParam("regions") int regionID) {

		Region region = regionRepository.findById(regionID).get();
		Country country = new Country();
		country.setId(countryCode);		
		country.setName(countryName);
		country.setRegion(region);
		
		return countryRepository.save(country);
	}
	
	@RequestMapping(path = "/addRegionForm", method = RequestMethod.POST)
	public Region regionForm(@RequestParam("regionName") String regionName) {
		Region region = new Region();
		region.setName(regionName);
		return regionRepository.save(region);
	}
	
	
	


}
