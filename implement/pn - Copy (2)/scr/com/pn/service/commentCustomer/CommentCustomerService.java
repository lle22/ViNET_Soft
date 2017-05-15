package com.pn.service.commentCustomer;

import java.util.List;

import com.pn.model.Customer.CustomerPotential;
import com.pn.model.Customer.RatePotential;
import com.pn.view.commentCustomer.bean.CommentCustomerBean;


public interface CommentCustomerService {
	public Integer saveComentCustomer(CustomerPotential entity) throws java.lang.Exception;
	public List<CustomerPotential> searchCommentCustomer(CommentCustomerBean bean) throws java.lang.Exception;
	public CustomerPotential getCommentCustomerById(Integer id);
	public void deleteCommentCustomer(Integer id) throws java.lang.Exception;
	public List<RatePotential> getRatePotential();
	public void updateComentCustomer(CustomerPotential customerPotential) throws java.lang.Exception;
	public CustomerPotential getCommentCustomerByName(String name);
}
