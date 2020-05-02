function validate(frm) {
	// set vflag to "yes indicating client side form validations are done
	frm.vflag.value = "yes";
	document.getElementById("nameErr").innerHTML = "";
	document.getElementById("ageErr").innerHTML = "";
	document.getElementById("nameErr").style = "color:red";
	document.getElementById("ageErr").style = "color:red";

	// read form data
	var name = frm.name.value;
	var age = frm.age.value;
	// perform client side form validations
	if (name == "") {// required rule
		document.getElementById("nameErr").innerHTML = "person name is mandatory";
		frm.name = focus();
		return false;
	}
	if (age == "") {// required rule
		document.getElementById("ageErr").innerHTML = "person age is mandatory";
		frm.name = focus();
		return false;
	} else {
		if (isNaN(age))// checks wheather age is numeric are not
		{
			doucument.getElementById.innerHTML = "person age must be numeric value";
			frm.age.focus();
			frm.age.value();
			return false;
		}// if
	}// else
	return true;
}// function
