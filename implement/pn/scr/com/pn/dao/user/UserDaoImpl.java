package com.pn.dao.user;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl  {

//	@Autowired
//	private SessionFactory sessionFactory;
//
//	public void saveUser(User user) {
//		sessionFactory.getCurrentSession().saveOrUpdate(user);
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<User> listUsers() {	
//		List<DMQuiCach> qcs = listQuiCach();
//		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
//	}
//	@SuppressWarnings("unchecked")
//	public List<DMQuiCach> listQuiCach() {
//		return (List<DMQuiCach>) sessionFactory.getCurrentSession().createCriteria(DMQuiCach.class).list();
//	}
}