package com.pn.dao.customer;

import org.springframework.stereotype.Repository;

import com.pn.dao.base.impl.GenericDAOImpl;
import com.pn.model.Customer.RatePotential;
@Repository("RatepotentialDao")
public class RatepotentialDaoImpl extends GenericDAOImpl<RatePotential, Integer> implements RatepotentialDao{

}
