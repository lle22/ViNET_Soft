package com.pn.service.commentCustomer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.pn.dao.customer.CommentCustomerDao;
import com.pn.dao.customer.RatepotentialDao;
import com.pn.model.Customer.CustomerPotential;
import com.pn.model.Customer.RatePotential;
import com.pn.view.commentCustomer.bean.CommentCustomerBean;

@Service("CommentCustomerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CommentCustomerServiceImpl implements CommentCustomerService{

	@Autowired
	private CommentCustomerDao commentDao;
	@Autowired
	private RatepotentialDao ratepotentialDao;
	
	public Integer saveComentCustomer(CustomerPotential entity) throws Exception {
		return (Integer)commentDao.save(entity);
	}
	public List<CustomerPotential> searchCommentCustomer(CommentCustomerBean bean)  throws Exception {
		return commentDao.searchCommentCustomer(bean);		
	}
	public CustomerPotential getCommentCustomerById(Integer id){
		return commentDao.loadById(id);
	}
	public void deleteCommentCustomer(Integer id) throws Exception {
		commentDao.deleteById(id);
		
	}
	@Cacheable(cacheName="ratePotentialCache")
	public List<RatePotential> getRatePotential() {
		return ratepotentialDao.loadAll();
	}
	public void updateComentCustomer(CustomerPotential entity)
			throws Exception {
		commentDao.saveOrUpdate(entity);
	}
	public CustomerPotential getCommentCustomerByName(String name) {
		return commentDao.getCommentCustomerByName(name);
	}
}
