package com.eaton.tco.cis.view.common;

import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.Vector;

public class ValueObject implements Serializable
{
	//private UserInfo userInfo;
	private Object primaryKey;

	private boolean createFlg = false;
	private boolean removeFlg = false;
	private boolean dirtyFlg = false;
	private boolean loadFlg = false;

	private Vector loadEntities = new Vector();

	private String errorCode = null;
	private boolean valid = true;

	public ValueObject() {
	}
	public ValueObject(Vector argLoadEntities) {
		setLoadEntities(argLoadEntities);
	}
	public boolean canCreate() {
		return createFlg;
	}
	public boolean canLoad() {
		return loadFlg;
	}
/**
 * Insert the method's description here.
 * Creation date: (5/10/2001 12:42:33 PM)
 * @return boolean
 * @param argEntityName java.lang.String
 */
public boolean canLoadContainedEntity(String argEntityName) {
	return entityExists(argEntityName);
}
	public boolean canRemove() {
		return removeFlg;
	}
	private boolean entityExists(String argEntityName) {
		int noOfElements = loadEntities.size();

		for (int i = 0; i < noOfElements; i++)
			if (loadEntities.elementAt(i).equals(argEntityName))
				return true;
		return false;
	}
/**
 * Insert the method's description here.
 * Creation date: (5/10/2001 12:46:53 PM)
 * @return java.lang.String
 */
public String getErrorCode() {
	return errorCode;
}
	public Object getPrimaryKey() {
		return primaryKey;
	}
	/*
	public UserInfo getUserInfo(){
		return userInfo;
	}*/
	public boolean isDirty() {
		return dirtyFlg;
	}
/**
 * Insert the method's description here.
 * Creation date: (5/10/2001 12:48:43 PM)
 * @return boolean
 */
public boolean isValid() {
	return valid;
}
	public void loadEntity(String argEntityName) {
		if (!entityExists(argEntityName))
			loadEntities.addElement(argEntityName);
	}
	public void setCreate(boolean argFlg) {
		if (argFlg) {
			setDirty(false);
			setRemove(false);
			setLoad(false);
		}
		createFlg = argFlg;
	}
	public void setDirty(boolean argFlg) {
		if (argFlg) {
			setCreate(false);
			setRemove(false);
			setLoad(false);
		}
		dirtyFlg = argFlg;
	}
/**
 * Insert the method's description here.
 * Creation date: (5/10/2001 12:46:53 PM)
 * @param newErrorCode java.lang.String
 */
public void setErrorCode(String newErrorCode) {
	errorCode = newErrorCode;
	this.setValid (false);
}
	public void setLoad(boolean argFlg) {
		if (argFlg) {
			setCreate(false);
			setRemove(false);
			setDirty(false);
		}
		loadFlg = argFlg;
	}
	public void setLoadEntities(Vector argLoadEntities) {
		loadEntities = argLoadEntities;
	}
	public Vector getLoadEntities() {
		return loadEntities;
	}
	public void setPrimaryKey(Object argPK) {
		primaryKey = argPK;
	}
	public void setRemove(boolean argFlg) {
		if (argFlg) {
			setCreate(false);
			setDirty(false);
			setLoad(false);
		}		
		removeFlg = argFlg;
	}
	/*
	public void setUserInfo(UserInfo argUserInfo){
		userInfo = argUserInfo;
	}*/
/**
 * Insert the method's description here.
 * Creation date: (5/10/2001 12:48:43 PM)
 * @param newValid boolean
 */
public void setValid(boolean newValid) {
	valid = newValid;
}

public String checkForString(String tmpStr){
		
		if(tmpStr == null || tmpStr.trim().length() == 0) {
			return "";
		}
		StringTokenizer st = new StringTokenizer(tmpStr.trim(),"'");
		StringBuffer sb = new StringBuffer();
		while(st.hasMoreElements()){
			sb.append(st.nextToken());
			if(st.hasMoreElements()) sb.append("''");
		}
		if(tmpStr.charAt(0) == '\'') sb.insert(0,"''");
		if(tmpStr.charAt(tmpStr.length() - 1) == '\'') sb.append("''");
		
		return sb.toString();
		
	}	
	
}
