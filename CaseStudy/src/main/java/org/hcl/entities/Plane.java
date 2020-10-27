package org.hcl.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="plane")
public class Plane {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planeId;
	@NotNull(message = "*")
	private String planeName;
	@Column(name= "FromLocation")
	private String from;
	@Column(name= "ToLocation")
	private String to;
	private String status;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pilotId")
	private Pilot pilot;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hangerId")
	private Hanger hanger;

	public Plane() {
		// TODO Auto-generated constructor stub
	}

	public Integer getPlaneId() {
		return planeId;
	}

	public void setPlaneId(Integer planeId) {
		this.planeId = planeId;
	}

	public Hanger getHanger() {
		return hanger;
	}

	public void setHanger(Hanger hanger) {
		this.hanger = hanger;
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

}
