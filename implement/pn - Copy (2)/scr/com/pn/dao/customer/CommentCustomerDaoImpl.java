package com.pn.dao.customer;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.pn.dao.base.impl.GenericDAOImpl;
import com.pn.model.Customer.CustomerPotential;
import com.pn.util.Ultil;
import com.pn.view.commentCustomer.bean.CommentCustomerBean;

@Repository("CommentCustomerDao")
public class CommentCustomerDaoImpl  extends GenericDAOImpl<CustomerPotential, Integer> implements CommentCustomerDao{
	@SuppressWarnings("unchecked")
	public List<CustomerPotential> searchCommentCustomer(CommentCustomerBean bean) throws Exception {
		Session session =sessionFactory.openSession();
		List results = null;
		try {
			String sql = "FROM CustomerPotential WHERE createDate is not null ";
			if(!"".equals(bean.getId()) && bean.getId() != null){
				sql += " AND ID LIKE '%" + bean.getId() +  "%'";
			}
			if(!"".equals(bean.getCreateDate()) && bean.getCreateDate() != null){
				sql += " AND createDate >= :fromCreateDate "; 
			}
			if(!"".equals(bean.getToCreateDate()) && bean.getToCreateDate() != null){
				sql += " AND createDate <= :toCreateDate "; 
			}
			if(!"".equals(bean.getDiaChi())  && bean.getDiaChi() != null){
				sql += " AND diaChi LIKE '%" + bean.getDiaChi() +  "%'";
			}
			if(!"".equals(bean.getDienThoai()) && bean.getDienThoai() != null){
				sql += " AND dienThoai = '" + bean.getDienThoai()  + "'";
			}
			if(!"".equals(bean.getEmail()) && bean.getEmail() != null){
				sql += " AND email = '" + bean.getEmail() + "'";
			}
			if(!"".equals(bean.getFax()) && bean.getFax() != null){
				sql += " AND fax = " + bean.getFax();
			}
			if(!"".equals(bean.getName()) && bean.getName() != null){
				sql += " AND name LIKE '%" + bean.getName() + "%'";
			}
			if(!"".equals(bean.getNguoiGiaoDich()) && bean.getNguoiGiaoDich() != null){
				sql += " AND nguoiGiaoDich = '" + bean.getNguoiGiaoDich() + "'";
			}
			if(!"".equals(bean.getRemindDate()) &&  bean.getRemindDate() != null){
				sql += " AND remindDate <= :remindDate";
			}
			if(!"".equals(bean.getEmployeeId()) && bean.getEmployeeId() != null){
				sql += " AND employeeId = '" + bean.getEmployeeId() + "'";
			}
			if(!"".equals(bean.getUpdatedBy()) && bean.getUpdatedBy() != null){
				sql += " AND updatedBy = '" + bean.getUpdatedBy() + "'";
			}
			if(!"".equals(bean.getRatePotentialId()) && bean.getRatePotentialId() != null){
				sql += " AND ratePotentialId = " + bean.getRatePotentialId();
			}
			if(!"".equals(bean.getRatePotentialId()) && bean.getRatePotentialId() != null){
				sql += " AND ratePotentialId = " + bean.getRatePotentialId();
			}
			if(bean.getInactive()){
				sql += " AND inactive = 1";
			} else {
				sql += " AND inactive = 0";
			}

			if(!"".equals(bean.getSortColumn()) && bean.getSortColumn() != null && !"".equals(bean.getOrderBy()) && bean.getOrderBy() != null){
				sql += " ORDER BY " + bean.getSortColumn() + " " + bean.getOrderBy();
			} else {
				sql += " ORDER BY createDate DESC ";
			}
			Query query = session.createQuery(sql);
			if(!"".equals(bean.getRemindDate()) &&  bean.getRemindDate() != null){
				query.setDate("remindDate", Ultil.stringToDate(bean.getRemindDate()));
			}
			if(!"".equals(bean.getCreateDate()) && bean.getCreateDate() != null){
				query.setDate("fromCreateDate", Ultil.stringToDate(bean.getCreateDate()));
			}
			if(!"".equals(bean.getToCreateDate()) && bean.getToCreateDate() != null){
				query.setDate("toCreateDate", Ultil.stringToDate(bean.getToCreateDate()));
			}

			results = query.list();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());			
			e.getStackTrace();
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<CustomerPotential> getCommentReminder() {
		Session session =sessionFactory.openSession();
		List results = null;
		try {
			String sql = "FROM CustomerPotential WHERE remindDate <= :remindDate"; 
			Query query = session.createQuery(sql);
			query.setDate("remindDate", new Date());
			results = query.list();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			e.getStackTrace();
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	public CustomerPotential getCommentCustomerByName(String name) {
		Session session =sessionFactory.openSession();
		CustomerPotential result = null;
		try {
			Query query = session.getNamedQuery("getCommentCustomerByName").setString("name", name);
			List list = query.list();
			if (list.size() > 0) {
				result = (CustomerPotential)list.get(0);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return result;
	}
}
