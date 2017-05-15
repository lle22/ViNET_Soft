package com.eaton.tco.cis.view.scr.valueobject;

import java.util.Vector;

import com.eaton.tco.cis.view.common.ValueObject;
 
public class DetailsVO extends ValueObject {

	protected Vector productType = null;
	protected Vector productDescription = null;
	protected Vector modelNumber = null;
	protected Vector parity = null;
	protected Vector incentive = null;
	protected Vector status = null;
	protected Vector wlm = null;
	protected Vector approvedBy = null;
	protected Vector approvalType = null;
	protected int length = 0;
	protected Vector autoRejectReason = null;
	protected Vector incentiveRuleId = null;
	
	//Added by Vyas
	protected Vector bpc = null;
	//DEVNOTE: COMMENTED/ADDED ON 20 JAN 2009 - FOR WARRANTY BRD.
	//protected Vector policy = null;
	protected Vector policyAmt = null;
	protected Vector parts = null;
	protected Vector hpRatio = null;
	protected Vector capacity= null;
	protected Vector partsValue = null;

//Added on 25 Jan 2008 - start
	protected Vector target = null;	
//Added on 25 Jan 2008 - end
	
	//DEVNOTE: ADDED ON 15 DEC 2008.
	protected Vector discountPct = null;	
	//DEVNOTE: ADDED ON 15 JAN 2009 - FOR WARRANTY BRD - START.
	protected Vector stdWarranty = null;
	protected Vector extWarranty = null;
	private Vector listPrice = null;
	private Vector customerInc = null;
	private Vector totalCoverage = null;	
	//DEVNOTE: ADDED ON 15 JAN 2009 - FOR WARRANTY BRD - END.	
	private Vector speWarranty = null;

	//DEVNOTE: LOILE: Added on 19 May 2010 AT RISK/GROWTH - start
	private Vector atRisk = null;
	private Vector atGrowth = null;
	private Vector riskGrowthNotes = null;
	private Vector detRiskOEMs = null;
	private Vector isUpdate = null;
	//DEVNOTE: LOILE: Added on 19 May 2010 - end
	//DEVNOTE: LOILE: Added on 05 Aug 2011 - start
	private Vector componentMFG = null;	
}

