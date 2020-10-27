package org.hcl.dao;

import org.hcl.entities.Manager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ManagerDao {

	@Autowired
	org.hibernate.SessionFactory factory;

	public void insertManager(Manager manager) {
		Session session = factory.openSession();
		Integer i = (Integer) session.save(manager);
	}
	
	public boolean validate(String userName, String password) {

		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Manager.class);
		criteria.add(Restrictions.like("firstName", userName));

		boolean flag = false;
		Object result = criteria.uniqueResult();
		if (result != null) {
			Manager manager= (Manager) result;
			if (manager.getPassword().equals(password) && manager.getStatus().equalsIgnoreCase("approved")) {
				flag = true;
			}
		}

		if (flag == true) {
			return true;
		} else {
			return false;
		}
	}
}
