package org.hcl.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Hanger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hangerId;
	@NotNull(message = "*")
	private String hangerName;
	private String hangerType;
	private String status;
	@OneToOne(mappedBy = "hanger")
	private Plane plane;
	
	public Hanger() {
		// TODO Auto-generated constructor stub
	}

	public Integer getHangerId() {
		return hangerId;
	}

	public void setHangerId(Integer hangerId) {
		this.hangerId = hangerId;
	}

	public String getHangerName() {
		return hangerName;
	}

	public String getStatus() {
		return status;
	}

	public String getHangerType() {
		return hangerType;
	}

	public void setHangerType(String hangerType) {
		this.hangerType = hangerType;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setHangerName(String hangerName) {
		this.hangerName = hangerName;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	
	
}
