package org.hcl.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Pilot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pilotId;
	@NotNull(message = "*")
	private String pilotName;
	private String gender;
	private String status;
	@OneToOne(mappedBy = "pilot")
	private Plane plane;
	
	public Pilot() {
		// TODO Auto-generated constructor stub
	}

	public Integer getPilotId() {
		return pilotId;
	}

	public void setPilotId(Integer pilotId) {
		this.pilotId = pilotId;
	}

	public String getPilotName() {
		return pilotName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

}
