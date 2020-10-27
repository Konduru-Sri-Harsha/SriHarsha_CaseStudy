package org.hcl.dao;

import java.util.List;

import org.hcl.entities.Admin;
import org.hcl.entities.Manager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AdminDao {
	@Autowired
	org.hibernate.SessionFactory factory;

	public void insertAdmin(Admin admin) {
		Session session = factory.openSession();
		Integer i = (Integer) session.save(admin);
	}

	public boolean validate(String userName, String password) {

		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Admin.class);
		criteria.add(Restrictions.like("firstName", userName));

		boolean flag = false;
		Object result = criteria.uniqueResult();
		if (result != null) {
			Admin admin = (Admin) result;
			if (admin.getPassword().equals(password)) {
				flag = true;
			}
		}

		if (flag == true) {
			return true;
		} else {
			return false;
		}
	}

	public List<Manager> getAllMangers() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM Manager");
		return query.list();
	}
	
	public void approveManager(Integer id) {
		Session session= factory.getCurrentSession();
		String approve= "update Manager manager set manager.status='approved' where manager.managerId=:mid";
		Query query= session.createQuery(approve);
		query.setParameter("mid", id);
		query.executeUpdate();
		
	}
	
	public void deleteManager(Integer id) {
		Session session= factory.getCurrentSession();
		String delete="delete from Manager manager where manager.managerId=:mid";
		Query query= session.createQuery(delete);
		query.setParameter("mid", id);
		query.executeUpdate();
	}
	
	
	
}
