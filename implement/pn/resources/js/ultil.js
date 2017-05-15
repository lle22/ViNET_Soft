var globalLocaleObj = new locale(",", ".", 3);// This is for GERMAN Locale.

function checkEnter(e) { 
var characterCode  
  if(e && e.which){ 
  e = e
  characterCode = e.which 
  }
  else{       
  e = event      
  characterCode = e.keyCode 
  }
  if(characterCode == 13){ 
  return true 
  }
  else{
  return false
  }
}

function isNumeric(fldName, fldLabel, focusFlg){
	var fldObj = document.getElementById(fldName);
	var fldVal = Trim(fldObj.value);
	if(fldVal!=''){
		if (AllNumeric(fldVal)) return true;
		if (fldLabel == null) fldLabel = fldName;
		alert(fldLabel + " phải là số nguyên.");
		if (focusFlg == true)
			fldObj.focus();
		return false;
	}
	return true;
}

function isAlphabetic(formName, fldName, fldLabel, focusFlg)
{
	var fldVal = eval('document.'+formName+'.'+fldName+'.value');
	fldVal = Trim(fldVal);
	eval('document.'+formName+'.'+fldName+'.value = "'+fldVal+'";');
	if (AllAlphabets(fldVal)) return true;
	if (fldLabel == null) fldLabel = fldName;
	alert(fldLabel + " can contain only alphabets.");
	if (focusFlg == null || focusFlg.charAt(0) == 'y' || focusFlg.charAt(0) == 'Y')
		eval('document.'+formName+'.'+fldName+'.focus()');
	return false;
}

function isAlphaNumeric(formName, fldName, fldLabel, focusFlg)
{
	var fldVal = eval('document.'+formName+'.'+fldName+'.value');
	fldVal = Trim(fldVal);
	eval('document.'+formName+'.'+fldName+'.value = "'+fldVal+'";');
	if (AllAlphaNumeric(fldVal)) return true;
	if (fldLabel == null) fldLabel = fldName;
	alert(fldLabel + " can contain only alphanumerics.");
	if (focusFlg == null || focusFlg.charAt(0) == 'y' || focusFlg.charAt(0) == 'Y')
		eval('document.'+formName+'.'+fldName+'.focus()');
	return false;
}

function isNumber(formName, fldName, fldLabel, focusFlg)
{
	var fldVal = eval('document.'+formName+'.'+fldName+'.value');
	fldVal = Trim(fldVal);
	eval('document.'+formName+'.'+fldName+'.value = "'+fldVal+'";');
	var newNumber = parseLcNum(fldVal, globalLocaleObj);
	if (!isNaN(newNumber)) return true;
	if (fldLabel == null) fldLabel = fldName;
	alert(fldLabel + " can contain only numbers in German format.");
	if (focusFlg == null || focusFlg.charAt(0) == 'y' || focusFlg.charAt(0) == 'Y')
		eval('document.'+formName+'.'+fldName+'.focus()');
	return false;
}

function isProperDate(formName, fldName, fldLabel, focusFlg)
{
	var fldVal = eval('document.'+formName+'.'+fldName+'.value');
	fldVal = Trim(fldVal);
	fldVal = AddCenturyIfReqd(fldVal);
	eval('document.'+formName+'.'+fldName+'.value="'+fldVal+'";');
	if (ProperDate(fldVal)) return true;
	if (fldLabel == null) fldLabel = fldName;
	alert(fldLabel + " must contain a valid date after 01.01.1900 and should be in dd.mm.yyyy format.");
	if (focusFlg == null || focusFlg.charAt(0) == 'y' || focusFlg.charAt(0) == 'Y')
		eval('document.'+formName+'.'+fldName+'.focus()');
	return false;
}

function isEmail(fldName, focusFlg){
    emailRegExp = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.([a-z]){2,4})$/;
    var value = document.getElementById(fldName).value;
    if(value != ''){
	    if(emailRegExp.test(value)){
	        return true;
	    }
	    alert('Email nhập không đúng.');
	    if (focusFlg == true){
			fldObj.focus();
		}
	    return false;
    } 
    return true;
}
function isEmpty(fldName, fldLabel, focusFlg) {
	var fldObj = document.getElementById(fldName);
	var fldVal = fldObj.value;
	fldVal = Trim(fldVal);
	if (fldObj.type == "text"){
		fldObj.value = fldVal;
	}
	if (fldVal != null && fldVal != ""){
		return true;
	}
	if (fldLabel == null){
		fldLabel = fldName;
	}
	alert(fldLabel + " không được trống.")
	if (focusFlg == true){
		fldObj.focus();
	}
	return false;
}

function isSelected(formName, fldName, fldLabel, focusFlg)
{
	var fldObj = eval('document.'+formName+'.'+fldName);
	var fldVal = fldObj.value;
	fldVal = Trim(fldVal);
	
	if (fldObj.type == "text")
		fldObj.value = fldVal;
	if (fldVal != null && fldVal != "") return true;
	if (fldLabel == null) fldLabel = fldName;
	alert("Please select an option from "+fldLabel + ".")
	if (focusFlg == null || focusFlg.charAt(0) == 'y' || focusFlg.charAt(0) == 'Y')
		fldObj.focus();
	return false;
}

function AllAlphabets(strToCheck)
{
	var reslt = strToCheck.match(/[^a-zA-Z_]+/);
	if (!reslt) return true;
	return false;
}

function AllAlphaNumeric(strToCheck)
{
	var reslt = strToCheck.match(/[^a-zA-Z0-9_]+/);
	if (!reslt) return true;
	return false;
}

function AllNumeric(strToCheck)
{
	var reslt = strToCheck.match(/[^0-9]+/);
	if (!reslt) return true;
	return false;
}

function Ltrim(strToTrim)
{
	strToTrim = strToTrim.replace(/(^\s*)/, "");
	return strToTrim;
}

function Rtrim(strToTrim)
{
	strToTrim = strToTrim.replace(/(\s*$)/, "");
	return strToTrim;
}

function Trim(strToTrim)
{
	strToTrim = Ltrim(strToTrim);
	strToTrim = Rtrim(strToTrim);
	return strToTrim;
}

function DateCompare(date1, date2)
{
	date1 = AddCenturyIfReqd(date1);
	date2 = AddCenturyIfReqd(date2);

	if (!ProperDate(date1) || !ProperDate(date2)) return false;

	var thisDate = GetDate(date1);
	var thatDate = GetDate(date2);

	var thisTime = thisDate.getTime();
	var thatTime = thatDate.getTime();

	return thisTime - thatTime;
}

function GetDate(dateFld)
{

	var varFlds = dateFld.split(".");
	if (varFlds.length != 3)
		return new Date();
	if ((varFlds[0].length > 2) || !AllNumeric(varFlds[0]))
		return new Date();
	if ((varFlds[1].length > 2) || !AllNumeric(varFlds[1]))
		return new Date();
	if ((varFlds[2].length != 4) || !AllNumeric(varFlds[2]))
		return new Date();
	var dai = parseInt(varFlds[0], 10);
	if (dai < 1 || dai > 31)
		return new Date();
	var mon = parseInt(varFlds[1], 10);
	if (mon < 1 || mon > 12)
		return new Date();
	var yer = parseInt(varFlds[2], 10);
	if (yer < 1900)
		return new Date();
	if ((mon == 4 || mon == 6 || mon == 9 || mon == 11) && dai > 30)
		return new Date();
	if ((mon == 2) && ((dai > 29) || ((dai > 28) && (!LeapYear(yer)))))
		return new Date();
	return new Date(yer, mon-1, dai, 0, 0, 0, 0);
}

function ProperDate(dateFld)
{
	dateFld = Trim(dateFld);
	dateFld = AddCenturyIfReqd(dateFld);
	var varFlds = dateFld.split(".");
	if (varFlds.length != 3)
		return false;
	if ((varFlds[0].length > 2) || !AllNumeric(varFlds[0]))
		return false;
	if ((varFlds[1].length > 2) || !AllNumeric(varFlds[1]))
		return false;
	if ((varFlds[2].length != 4) || !AllNumeric(varFlds[2]))
		return false;
	var dai = parseInt(varFlds[0], 10);
	if (dai < 1 || dai > 31) return false;
	var mon = parseInt(varFlds[1], 10);
	if (mon < 1 || mon > 12) return false;
	var yer = parseInt(varFlds[2], 10);
	if (yer < 1900) return false;
	if ((mon == 4 || mon == 6 || mon == 9 || mon == 11) && dai > 30)
		return false;
	if ((mon == 2) && ((dai > 29) || ((dai > 28) && (!LeapYear(yer)))))
		return false;
	return true;
}


function LeapYear(yr)
{
	if ((yr % 400) == 0)	return true;
	if ((yr % 100) == 0)	return false;
	if ((yr % 4) == 0) return true;
	return false;
}

function AddCenturyIfReqd(dateStr)
{
	dateStr = Trim(dateStr);
	var varFlds = dateStr.split(".");
	if (varFlds.length != 3 || varFlds[2].length > 2 || varFlds[2].length == 0)
		return dateStr;
	if (varFlds[2].length == 1) varFlds[2] = "0"+varFlds[2];
	if (varFlds[2] < "70")
		varFlds[2] = "20"+varFlds[2];
	else
		varFlds[2] = "19"+varFlds[2];
	return varFlds[0]+"."+varFlds[1]+"."+varFlds[2];
}

//LOCALE FUNCTIONS....
function locale(decimalPoint, thousandSep, fracDigits)
{
	this.decimalPoint = new String(decimalPoint);
	this.thousandSep = new String(thousandSep);
}

function parseLcNum(str, lc)
{
	var sNum = new String(Trim(str));
	if (sNum == null || sNum == "") return sNum;
	if (sNum.split(lc.decimalPoint).length > 2)
		return NaN;
	var leftPart = sNum.split(lc.decimalPoint)[0];
	if (leftPart != null)
	{
		 var unitOfNums = leftPart.split(lc.thousandSep);
		 if (unitOfNums.length > 1)
		 	for (var i=1; i < unitOfNums.length; i++)
				if (unitOfNums[i].length != 3)
					return NaN;
	}
	var rightPart = sNum.split(lc.decimalPoint)[1];
	if (rightPart != null && rightPart.split(lc.thousandSep).length > 1)
		return NaN;
	var aParts = sNum.split(lc.thousandSep);
	sNum = aParts.join("");
	aParts = sNum.split(lc.decimalPoint);
	//start of change - to fix entries like 123aa
	aParts = aParts.join(".")
	if (isNaN(aParts)) return NaN;
	//return(parseFloat(aParts.join(".")));
	return(parseFloat(aParts));
	//end of change
}


//All the function below are moved from ASMB validations.js

//This function is used to check for empty condition but should not pop up alert message
function isEmptyWithoutPopUp(formName,fldName){

	var fldVal = eval('document.'+formName+'.'+fldName+'.value');
	if (fldVal != null && fldVal != "") return false;
	return true

}

//This function to check if the List box is empty or not
function checkIfDDEmpty(fld)
{
	var fldVal = fld.options[fld.selectedIndex].value
	if (fldVal != null && fldVal != "") return false;
	return true;
}

//Used to check whether entered date is greater than today date
function isGreaterThanToday(formName,fldName,fldLabel,currentDatefldName)
{
	var enteredDate = eval('document.'+formName+'.'+fldName+'.value');
	var currentDate = eval('document.'+formName+'.'+currentDatefldName+'.value');
	if (DateCompare(enteredDate,currentDate  ) > 0 )
	 {
		alert(fldLabel + " cannot be greater than current date.");
		return false;	
	}
	else
		return true;


}
// This function is to check whether the number entered is with in the range defined in Data Model

function isNumberWithinRange(formName,fldName,fldLabel,noOfDigitsafterDecimalPoint,noOfDigitsbeforeDecimalPoint)
{

	var number = eval('document.'+formName+'.'+fldName+'.value');
	var noOfThousandSeparator;
 	var message;
 	var message1;

	//Get No of thousand separators
	var pr=noOfDigitsbeforeDecimalPoint/3;
	var m=noOfDigitsbeforeDecimalPoint%3;
	var a=parseInt(pr);
        if(m>0)
	    noOfThousandSeparator = a;
	else
            noOfThousandSeparator = a-1;
            
        //Get Messages with number formats with and without thousand separators
  	var thousep=new String(".");
  	var maxnostr =new String("9");
  	var decsep=new String(",");
  	var str1=new String("");
  	var digitsAfterDec=new String("");
  	var messagestr=new String("");
  	var message1str = new String("");
  	var i=0;
  	
  	for(var e=0;e<noOfDigitsbeforeDecimalPoint;e++)
  	{
   		i=i+1;
  		str1 = str1.concat(maxnostr);
  		message1str = message1str.concat(maxnostr);
  		if(i == 3 && e != noOfDigitsbeforeDecimalPoint-1)
   		{
  			
    			str1 = str1.concat(thousep);
    			i=0;
   		}
  	}
  	
  	var p=str1.length;
  	for(var e2=p-1;e2>=0;e2--)
  	{
  		var l=str1.charAt(e2);
  		messagestr=messagestr.concat(l);
  	}
  	//Get digits after decimal
  	
  	for(var e1=0;e1<noOfDigitsafterDecimalPoint;e1++)
  	{
   	
  		digitsAfterDec = digitsAfterDec.concat(maxnostr);
  	
  	}
  	message = messagestr.concat(decsep).concat(digitsAfterDec);
	message1 = message1str.concat(decsep).concat(digitsAfterDec);
	

	
	if (number.indexOf(",") != -1){
		
		var beforeDecimalPoint = number.substring(0,number.indexOf(","));
		var afterDecimalPoint = number.substring(number.indexOf(",") + 1,number.length);
		if (afterDecimalPoint.length > noOfDigitsafterDecimalPoint) {
			alert(fldLabel + " cannot have more than " + noOfDigitsafterDecimalPoint + " digits after decimal point.");
			var obj = eval('document.'+formName+'.'+fldName);
			obj.focus();
			return false;
		}
	}
	else{
		var beforeDecimalPoint = number;
	}
	if (beforeDecimalPoint.indexOf(".") != -1){
		
		if (beforeDecimalPoint.length > noOfDigitsbeforeDecimalPoint + noOfThousandSeparator ){
			alert(fldLabel + " cannot be more than " + message);
			var obj = eval('document.'+formName+'.'+fldName);
			obj.focus();
			return false;
		}
	}
	else{
		if (beforeDecimalPoint.length > noOfDigitsbeforeDecimalPoint){
			alert(fldLabel + " cannot be more than " + message1);
			var obj = eval('document.'+formName+'.'+fldName);
			obj.focus();
			return false;
		}
	}
		
	return true;

}





// This function is to check whether the number entered is with in the range defined in Data Model - Added on 30-Aug-2003

function isNumberWithinRangeCheck(formName,fldName,fldLabel,noOfDigitsafterDecimalPoint,noOfDigitsbeforeDecimalPoint)
{

	var number = eval('document.'+formName+'.'+fldName+'.value');
	var noOfThousandSeparator;
 	var message;
 	var message1;

	//Get No of thousand separators
	var pr=noOfDigitsbeforeDecimalPoint/3;
	var m=noOfDigitsbeforeDecimalPoint%3;
	var a=parseInt(pr);
        if(m>0)
	    noOfThousandSeparator = a;
	else
            noOfThousandSeparator = a-1;
            
        //Get Messages with number formats with and without thousand separators
  	var thousep=new String(".");
  	var maxnostr =new String("9");
  	//var decsep=new String(",");
  	var decsep=new String(".");
  	var str1=new String("");
  	var digitsAfterDec=new String("");
  	var messagestr=new String("");
  	var message1str = new String("");
  	var i=0;
  	
  	for(var e=0;e<noOfDigitsbeforeDecimalPoint;e++)
  	{
   		i=i+1;
  		str1 = str1.concat(maxnostr);
  		message1str = message1str.concat(maxnostr);
  		if(i == 3 && e != noOfDigitsbeforeDecimalPoint-1)
   		{
  			
    			str1 = str1.concat(thousep);
    			i=0;
   		}
  	}
  	
  	var p=str1.length;
  	for(var e2=p-1;e2>=0;e2--)
  	{
  		var l=str1.charAt(e2);
  		messagestr=messagestr.concat(l);
  	}
  	//Get digits after decimal
  	
  	for(var e1=0;e1<noOfDigitsafterDecimalPoint;e1++)
  	{
   	
  		digitsAfterDec = digitsAfterDec.concat(maxnostr);
  	
  	}
  	message = messagestr.concat(decsep).concat(digitsAfterDec);
	message1 = message1str.concat(decsep).concat(digitsAfterDec);
	

	
	if (number.indexOf(".") != -1){
		
		var beforeDecimalPoint = number.substring(0,number.indexOf("."));
		var afterDecimalPoint = number.substring(number.indexOf(".") + 1,number.length);
		if (afterDecimalPoint.length > noOfDigitsafterDecimalPoint) {
			alert(fldLabel + " cannot have more than " + noOfDigitsafterDecimalPoint + " digits after decimal point.");
			var obj = eval('document.'+formName+'.'+fldName);
			obj.focus();
			return false;
		}
	}
	else{
		var beforeDecimalPoint = number;
	}
	if (beforeDecimalPoint.indexOf(".") != -1){
		
		if (beforeDecimalPoint.length > noOfDigitsbeforeDecimalPoint + noOfThousandSeparator ){
			alert(fldLabel + " cannot be more than " + message);
			var obj = eval('document.'+formName+'.'+fldName);
			obj.focus();
			return false;
		}
	}
	else{
		if (beforeDecimalPoint.length > noOfDigitsbeforeDecimalPoint){
			alert(fldLabel + " cannot be more than " + message1);
			var obj = eval('document.'+formName+'.'+fldName);
			obj.focus();
			return false;
		}
	}
		
	return true;

}



function isValidDunsNumber(formName, fldName, fldLabel, focusFlg)
{
	var fldVal = eval('document.'+formName+'.'+fldName+'.value');
	fldVal = Trim(fldVal);
	if(fldVal.length == 0) return true;
	eval('document.'+formName+'.'+fldName+'.value = "'+fldVal+'";');
	if (validDunsNumber(fldVal)) return true;
	if (fldLabel == null) fldLabel = fldName;
	alert(fldLabel + " entered is invalid.");
	if (focusFlg == null || focusFlg.charAt(0) == 'y' || focusFlg.charAt(0) == 'Y')
		eval('document.'+formName+'.'+fldName+'.focus()');
	return false;
}

function validDunsNumber(dunsNumber)
{
	var strlength = dunsNumber.length;
	var retvalue = "" ;
	var tmpchar ;
	for(var i=0 ; i<strlength ; i++)
	{
		tmpchar = dunsNumber.charAt(i);
		if(tmpchar >=0 && tmpchar <= 9)
		{
			retvalue+=tmpchar;
		}
	}
	if(retvalue.length != 9)
	{
		return false;
	}
	else
	{
		return true;
	}
}

function isValidTelephone(formName, fldName, fldLabel, focusFlg)
{
	var fldVal = eval('document.'+formName+'.'+fldName+'.value');
	fldVal = Trim(fldVal);
	if(fldVal.length == 0) return true;
	eval('document.'+formName+'.'+fldName+'.value = "'+fldVal+'";');
	if (validTelephone(fldVal)) return true;
	if (fldLabel == null) fldLabel = fldName;
	alert(fldLabel + " entered is invalid.");
	if (focusFlg == null || focusFlg.charAt(0) == 'y' || focusFlg.charAt(0) == 'Y')
		eval('document.'+formName+'.'+fldName+'.focus()');
	return false;
}
function validTelephone(telephone)
{
	var strlength = telephone.length;
	var retvalue = "" ;
	var tmpchar ;
	for(var i=0 ; i<strlength ; i++)
	{
		tmpchar = telephone.charAt(i);
		if(tmpchar >=0 && tmpchar <= 9)
		{
			retvalue+=tmpchar;
		}
	}
	if(retvalue.length != 10)
	{
		return false;
	}
	else
	{
		return true;
	}
}
function isValidZipcode(formName,fldName,countryName,fldLabel,focusFlg)
{
	//Newly Added by Thirumalai
	var tmpZip = eval('document.'+formName+'.'+fldName+'.value');
	//var tmpCountry = eval('document.'+formName+'.country.value'); 
	// Modified by KarthikSN --- 23/sep/2003
	var tmpCountry = eval('document.'+formName+'.'+countryName+'.value'); 
	tmpZip = Trim(tmpZip);
	if(tmpZip.length == 0) return true;
	
	var format="";
	var fldVal;
	var len = tmpZip.length;
	if(tmpCountry == "USA") format="NNNNN-NNNN";
	if(tmpCountry == "CAN") format="ANA NAN";
	if(tmpCountry == "USA" && len <= 5){
		format="NNNNN";
	}
	if(format == "") return true;
	fldVal = parseFormat(tmpZip,format);
	if(fldVal == ""){
		alert(fldLabel+" code should be entered in '" + format + "' format.");
	}
	else{
		eval('document.'+formName+'.'+fldName+'.value = "' + fldVal + '";' );
		return true;
	}
	if (focusFlg == null || focusFlg.charAt(0) == 'y' || focusFlg.charAt(0) == 'Y')
		eval('document.'+formName+'.'+fldName+'.focus()');
	return false;
}
function parseFormat(prmZip, prmFormat){
	var forLen = prmFormat.length;
	var zipLen = prmZip.length;
	var tmpVal;
	var tmpZipVal;
	var retVal="";
	var validVal;
	if(zipLen > forLen){
		return "";
	}
	var j=1;
	for(var i=1;i<= forLen; i++){
		tmpVal = prmFormat.substring(i,i-1);
		tmpZipVal = prmZip.substring(j,j-1);
		if(isSpecialChar(tmpVal)){
			retVal += tmpVal;
			if(tmpVal == tmpZipVal){
				j++;
			}
			else{
				if(isSpecialChar(tmpZipVal)){
					j++;
				}
			}
		}
		else{
			validVal = false;
			if(tmpVal == 'N' || tmpVal == 'n'){
				validVal = AllNumeric(tmpZipVal);
			}
			else if(tmpVal == 'A' || tmpVal == 'a'){
				validVal = AllAlphabets(tmpZipVal);
			}
			else if(tmpVal == 'x' || tmpVal == 'X'){
				validVal = AllAlphaNumeric(tmpZipVal);
			}
			j++;
			if(validVal){
				retVal += tmpZipVal;
			}
			else{
				return "";
			}
		}
	}
	if(forLen != retVal.length){
		return "";
	}
	return retVal;
}

function isSpecialChar(prmSpecial){
	return ( prmSpecial == ' ' || prmSpecial == '-');
}

function validZipcode(zipcode)
{
	var strlength = zipcode.length;
	var retvalue = "" ;
	var tmpchar ;
	for(var i=0 ; i<strlength ; i++)
	{
		tmpchar = zipcode.charAt(i);
		if(tmpchar >=0 && tmpchar <= 9)
		{
			retvalue+=tmpchar;
		}
	}
	if(retvalue.length == 5 || retvalue.length == 9)
	{
		return true;
	}
	else
	{
		return false;
	}
}

/*
Get number in German Format for the given English format.
Note:  IF GERMAN FORMAT IS GIVEN, THEN YOU GET WRONG VALUE.
*/

function getGermanFormat(argDouble, argAfterPeriod){
	var germanAmtFormat = null;
	var strAfterPeriod ="";
	var strBeforePeriod = null;
	var flagMinus = 0;
	argDouble = argDouble + "";
	var lcNumber = new String(Trim(argDouble));
	if (lcNumber == null || lcNumber == "") return lcNumber;

	lcNumber = lcNumber.replace(/,/g, "");

	if (lcNumber != null && lcNumber.length > 0 ){
	
		
		var varNumberFlds = lcNumber.split(".");
		
		if (varNumberFlds.length > 2) return NaN;

		if (parseFloat(lcNumber) < 0 ){
			flagMinus = 1;
			lcNumber = (parseFloat(lcNumber) * -1) + ""; 
		}

		
		if (varNumberFlds.length > 1){ 
			strBeforePeriod = varNumberFlds[0];
			strAfterPeriod = varNumberFlds[1];
		}
		else
			strBeforePeriod = lcNumber;

		//Constract the digits after decimal point 
		if (strAfterPeriod != null && strAfterPeriod.length < argAfterPeriod){
			while (strAfterPeriod.length < argAfterPeriod)
				strAfterPeriod = strAfterPeriod + "0";  
		}
		else{
			strAfterPeriod = strAfterPeriod.substring(0,argAfterPeriod);
		}
		
		//Constract the digits in germat format before decimal point 
		if (strBeforePeriod != null && strBeforePeriod.length > 3){
			var first = 1;
			var tempStr = strBeforePeriod;
			germanAmtFormat = "";
			while (tempStr.length > 3){
				if (first == 1)
					germanAmtFormat = tempStr.substring(tempStr.length - 3);
				else
					germanAmtFormat = tempStr.substring(tempStr.length - 3) + "." + germanAmtFormat;

				first = 0;		
				tempStr= 	tempStr.substring(0,tempStr.length - 3);
			}
			germanAmtFormat = tempStr + "." + germanAmtFormat;
		}
		else
			germanAmtFormat = strBeforePeriod;
		
		if (strAfterPeriod != null && strAfterPeriod.length > 0)	
			germanAmtFormat = germanAmtFormat + "," + strAfterPeriod;		
		
	}
	
	//Add minus sign if the given number is negative
	if (germanAmtFormat != null && germanAmtFormat.length > 0 && flagMinus == 1)
		germanAmtFormat = "-" + germanAmtFormat;
	return germanAmtFormat;
	
}
//added jagan rao on 23 july as per dan's mail
function isMaxSmallInt(fieldValue)
{
	if(fieldValue > 32767)			
	{
		return true;			
	}
	return false;
		
}
function isDecimal(number)
{
	if (number > 0 && number.indexOf(".") != -1){
		return true; 
	}
	return false;
}