package org.hcl.dao;

import java.util.List;

import org.hcl.entities.Hanger;
import org.hcl.entities.Manager;
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
public class planeDao {
	@Autowired
	org.hibernate.SessionFactory factory;

	public void insertPlane(Plane plane) {
		Session session = factory.openSession();
		Integer i = (Integer) session.save(plane);
	}
	
	public void updatePlane(Plane plane) {
		Session session = factory.openSession();
		Plane plane1=(Plane)session.get(Plane.class, plane.getPlaneId());
		plane1.setPlaneName(plane.getPlaneName());
		plane1.setFrom(plane.getFrom());
		plane1.setTo(plane.getTo());
		plane1.setStatus(plane.getStatus());
		plane1.setPilot(plane.getPilot());
		plane1.setHanger(plane.getHanger());
		session.save(plane1);
		
	}

	public List<Plane> getAllPlanes() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM Plane");
		return query.list();
	}

	public List<Plane> waitingPlanes() {

		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Plane.class);
		criteria.add(Restrictions.like("status", "Waiting"));
		List<Plane> result = criteria.list();
		return result;
	}
	
	public List<Plane> notAssignedPlanes() {

		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Plane.class);
		criteria.add(Restrictions.isNull("pilot.pilotId"));
		List<Plane> result = criteria.list();
		return result;
	}
	
	public Plane getplane(Integer id) {
		Session session = factory.getCurrentSession();
		return (Plane)session.get(Plane.class, id);
	}
	
	public void setHangerId(Integer planeId,Integer hangerId) {
		Session session = factory.getCurrentSession();
		String approve= "update Plane plane set plane.hanger.hangerId=:hid where plane.planeId=:pid";
		Query query= session.createQuery(approve);
		query.setParameter("hid",hangerId);
		query.setParameter("pid", planeId);
		query.executeUpdate();
	}
	public void setStatus(Integer id) {
		Session session = factory.getCurrentSession();
		String approve= "update Plane plane set plane.status='Alloted' where plane.planeId=:pid";
		Query query= session.createQuery(approve);
		query.setParameter("pid",id);
		query.executeUpdate();
	}
	
	public void setPilotId(Integer planeId,Integer pilotId) {
		Session session = factory.getCurrentSession();
		String approve= "update Plane plane set plane.pilot.pilotId=:id where plane.planeId=:pid";
		Query query= session.createQuery(approve);
		query.setParameter("id",pilotId);
		query.setParameter("pid", planeId);
		query.executeUpdate();
	}
}
