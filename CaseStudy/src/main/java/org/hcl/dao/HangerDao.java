package org.hcl.dao;

import java.util.List;

import org.hcl.entities.Admin;
import org.hcl.entities.Hanger;
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
public class HangerDao {
	@Autowired
	org.hibernate.SessionFactory factory;

	public void insertHanger(Hanger hanger) {
		Session session = factory.openSession();
		Integer i = (Integer) session.save(hanger);
	}

	public List<Hanger> getAllHangers() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM Hanger");
		return query.list();
	}
	
	public List<Hanger> availableHangers(){
		
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Hanger.class);
		criteria.add(Restrictions.like("status", "Available"));
		List<Hanger> result = criteria.list();
		return result;		
	}
	
	public Hanger getHanger(Integer id) {
		Session session = factory.getCurrentSession();
		return (Hanger)session.get(Hanger.class, id);
		
	}
	
	 public boolean updateHanger(Hanger hanger) {
	        Session session=factory.getCurrentSession();
	        Query<Plane> q=session.createQuery("update Hanger h set h.hangerName=:name,h.hangerType=:type,h.status=:status where h.hangerId=:i");
	        q.setParameter("name",hanger.getHangerName());
	        q.setParameter("type",hanger.getHangerType());
	        q.setParameter("status",hanger.getStatus());
	        q.setParameter("i",hanger.getHangerId());
	        int status=q.executeUpdate();
	        if(status>0) {
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
	
	public void hangerStatus(Integer id) {
		Session session = factory.getCurrentSession();
		String approve= "update Hanger hanger set hanger.status='Alloted' where hanger.hangerId=:hid";
		Query query= session.createQuery(approve);
		query.setParameter("hid",id);
		query.executeUpdate();
	}
}
