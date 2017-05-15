package com.pn.dao.customer;

import java.util.List;

import com.pn.dao.base.GenericDAO;
import com.pn.model.Customer.CustomerPotential;
import com.pn.view.commentCustomer.bean.CommentCustomerBean;

public interface CommentCustomerDao  extends GenericDAO<CustomerPotential, Integer>{

	public List<CustomerPotential> searchCommentCustomer(CommentCustomerBean bean) throws Exception;

	public CustomerPotential getCommentCustomerByName(String name);
}
