package com.eaton.tco.cis.dao.scr;

import org.springframework.stereotype.Repository;

import com.eaton.tco.cis.dao.base.impl.GenericDAOImpl;
import com.eaton.tco.cis.entity.scr.Scr;
@Repository("ScrDao")
public class ScrDaoImpl extends GenericDAOImpl<Scr, Integer> implements ScrDao{

}
