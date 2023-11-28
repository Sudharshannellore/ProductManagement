function productvalidation(){
	var pid = document.getElementById("pid").value;
	var pname = document.getElementById("pname").value;
	var price = document.getElementById("price").value;
    var brand = document.getElementById("brand").value;
	var made = document.getElementById("made").value;
	if(pid.trim()==="" | pname.trim()===""|price.trim()===""|brand.trim()===""|made.trim()===""){

        alert("All fields must be filled out");
        return false;
		
	}	
    if (parseFloat(price) < 0) {
        alert("Price must be a non-negative value");
        return false;
    }

    if (pname.length > 50 || brand.length > 50) {
            alert("Product name and brand must be less than 50 characters");
            return false;
    }
    var mandate = document.getElementById("mandate").value;
    var expdate = document.getElementById("expdate").value;
    var manufacturingDateObj = new Date(mandate);
    var expiryDateObj = new Date(expdate);
    if (manufacturingDateObj > expiryDateObj) {
        alert("Manufacturing date cannot be greater than expiry date.");
        return false;
    }
        return true;


    }