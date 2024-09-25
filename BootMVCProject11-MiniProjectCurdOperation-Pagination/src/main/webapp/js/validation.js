
function validation(frm){
	alert("client side form validations");
	//empty the error messeges
	document.getElementById("enameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";
	
	//read form data
	let ename=frm.ename.value;
	let job=frm.job.value;
	let sal=frm.sal.value;
	let flag=true;
	
	//form validations (client side)
	if(ename==""){
		document.getElementById("enameErr").innerHTML="Employee name is mandatory(cs)";
		flag=false;
	}
	
	if(ename.length>10){//ename max length rule
		document.getElementById("enameErr").innerHTML="Employee name must have max of 10 chars(cs)";
		flag=false;
	}
	
	
	
	if(job==""){//job required rule
		document.getElementById("jobErr").innerHTML="Employee desg is required(cs)";
		flag=false;
	}
	
	if(job.length>9){//job max length rule
		document.getElementById("jobErr").innerHTML="Employee desg can have max 9 characters(cs)";
		flag=false;
	}
	
	
	
	if(sal==""){//sal required rule
		document.getElementById("salErr").innerHTML="Employee salary is required(cs)";
		flag=false;
	}
	
	if(isNaN(sal)){//job max length rule
		document.getElementById("salErr").innerHTML="Employee salary must have numeric value(cs)";
		flag=false;
	}
	
	
	if(sal<0 || sal>100000){//job max length rule
		document.getElementById("salErr").innerHTML="Employee salary must be in the range 1 through 100000(cs)";
		flag=false;
	}
	
		//change vflag value to "yes" indicating client form validating are done
		
		frm.vflag.value="yes";
		
	return flag;
	
}