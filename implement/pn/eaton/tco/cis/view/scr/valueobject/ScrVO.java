package com.eaton.tco.cis.view.scr.valueobject;

import java.util.Vector;

import com.eaton.tco.cis.view.common.ValueObject;
public class ScrVO extends ValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private java.lang.String accountNumber = null;
	
	
	private java.lang.String accountName;
	// Added by Vyas 19th july 
	protected String hdnAccountName = null;
	protected String accountAddress1 = null;
	protected String accountAddress2 = null;
	protected String accountCity = null;
	protected String accountState = null;
	protected String accountZipCode = null;
	protected String accountCountry = null;
	//CUONGBUI added for issue#156 : Add a new filed LTA to SCR - START
	protected String lta = "N";
	//CUONGBUI added for issue#156 : Add a new filed LTA to SCR - END
	
	
	
	private String scrNumber = null;
	private String scrName = null;
	private String oem = null;
	private String classType = null;
	private String versionNumber = null;
	private String year = null;
	private String quantity = null;
	private String currencyCode = null;
	private String customerDecision = null;
	private String decisionDate = null;
	private String status = null;
	private String yourNotes = new String();
	private String otherNotes = new String();
	private String customerAccepted = null;
	private String customerRejected = null;
	private String createdBy = null;
	//Added by vyas
	private String createdByName = null;
	private String updatedBy = null;
	private String expirationDate = null;
	
	private String createdDate = null;
	
	
	
	//this is to find the wether the scr schould be added or updated.
	private String mode = null;
	private String message = null;
	private boolean duplicateScr = false;
	private boolean referredByVDN = false;
	private String totalParityIncentive = null;
	private String hiddenTotalParityIncentive = null;

	//private Vector productDetailsVOVector = null;
//	private ProductDetailsVO productDetailsVO = null;

	private Vector scrCommentsVOVector = null;
	// to know wether the scr is versioned. If yes then all status should be OPEN including the master status
	private boolean versioned = false;
	
	//Added by Vyas on April 11th issue No 348
	private Vector productTypesReqdVec = null;
	
	//Added by Senthil - July19-2005
	protected String accountRegion = null;
	protected String accountTerritory = null;
	protected String accountSubTerritory = null;
	protected String accountSalesMgr = null;
	protected String accountServiceMgr = null;

	//Added on 19 Jan 2007.	
	protected String availableScrQty = null;
	//End of addition on 19 Jan 2007.
	
//Added on 25 Jan 2008 - start
	protected String includeTargetAccounts = null;
//Added on 25 Jan 2008 - end
	//DEVNOTE: COMMENTED/ADDED ON 20 JAN 2009 - FOR WARRANTY BRD.
	private boolean isSpecialDealAcct = false;	
	private boolean isCurrencyChanged = false;
	
	//Vehicle Usage Change START
	
	protected String vehicleUsage = null;
	protected String vocationCtgryEvId  = null;
	private boolean isVehUsageChanged = false;
	
	//Vehicle Usage Change END
	//LOILE add - start
	private double totalAmountMFGType;
	public double getTotalAmountMFGType() {
		return totalAmountMFGType;
	}
	public void setTotalAmountMFGType(double totalAmountMFGType) {
		this.totalAmountMFGType = totalAmountMFGType;
	}
	//LOILE add - END
	/* DEVNOTE: CHAU : 20-MAY-2010 : SHOW TARGET MODELS - START */
	private String showTargetModelOnly = null;
	
	public String getShowTargetModelOnly() {
		return showTargetModelOnly;
	}
	public void setShowTargetModelOnly(String showTargetModelOnly) {
		this.showTargetModelOnly = showTargetModelOnly;
	}
	/* DEVNOTE: CHAU : 20-MAY-2010 : SHOW TARGET MODELS - END */
	
	/* DEVNOTE: LOILE : 23-JUL-2010 : VSCR get CCR_ID - START */
	private String ccrId = null;
	
	public void setCcrId(String ccrId) {
		this.ccrId = ccrId;
	}
	public String getCcrId() {
		return ccrId;
	}
	/* DEVNOTE: LOILE : 23-JUL-2010 : VSCR get CCR_ID - END */
	/* DEVNOTE: LOILE : 1-SEP-2010 : VisComsumer - START */
	private String callReason = null;
	
	public String getCallReason() {
		return callReason;
	}
	public void setCallReason(String callReason) {
		this.callReason = callReason;
	}
	private boolean isComsumer = false;
	
	public boolean getIsComsumer() {
		return isComsumer;
	}
	public void setIsComsumer(boolean isComsumer) {
		this.isComsumer = isComsumer;
	}
	
	
}