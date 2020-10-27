package org.hcl.dao;

import java.util.List;

import org.hcl.entities.Pilot;
import org.hcl.entities.Plane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PilotDao {
	@Autowired
	org.hibernate.SessionFactory factory;

	public void insertPilot(Pilot pilot) {
		Session session = factory.openSession();
		Integer i = (Integer) session.save(pilot);
	}

	public List<Pilot> getAllPilots() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM Pilot");
		return query.list();
	}
	
	public List<Pilot> notAssignedPilots() {

		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Pilot.class);
		criteria.add(Restrictions.like("status", "Not Assigned"));
		List<Pilot> result = criteria.list();
		return result;
	}
	
	public void updateStatus(Integer id) {
		Session session = factory.getCurrentSession();
		String approve= "update Pilot pilot set pilot.status='Assigned' where pilot.pilotId=:pid";
		Query query= session.createQuery(approve);
		query.setParameter("pid",id);
		query.executeUpdate();
	}
	
}
