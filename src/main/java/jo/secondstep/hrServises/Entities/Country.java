package jo.secondstep.hrServises.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "countries")
public class Country {
	
	@Id
	@Column(name="country_id")
	private String id;
	
	@Column(name="country_name")
	private String name;
		
	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region Region;
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return Region;
	}

	public void setRegion(Region region) {
		Region = region;
	}
	

}
