function validate_login_actor()
{
	var check = document.getElementById("actor");
	if(!validate_numeric(check))
	{
	alert('Please select the actor');
	check.focus();
	return false;
	}
return true;
}
function validate_login_id()
{
	var check = document.getElementById("login_id");
	if(validate_isEmpty(check))
	{
		alert('User ID cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_alphanumeric(check))
		{
		alert('USER ID must have only alphanumeric characters.');
		check.focus();
		return false;
		}
	return true;		
}

function validate_login_password()
{
	var check = document.getElementById("login_pass");
	if(validate_isEmpty(check))
	{
		alert('Password cannot be empty');
		check.focus();
		return false;
	}

	else return true;		
}

function page_validate_login()
{
	if(validate_login_actor())
	{
	if(validate_login_id())
	{
		if(validate_login_password())
		{
			return true;
		}
		else return false;
	}
	else return false;
	}
	else return false;
}

function validate_offers()  
{
	var check = document.getElementById("off");
	if(validate_isEmpty(check))
	{
		alert('Offers cannot be empty');
		check.focus();
		return false;
	}

	
	return true;
}

function validate_order_value()
{
	var check = document.getElementById("Desc");
	if(validate_isEmpty(check))
	{
		alert('Order Value cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_numeric(check))
		{
		alert('Order Value must have only numeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function page_validate_add_package()
{
	if(validate_offers())
	{
		if(validate_order_value())
		{
		alert("New package added successfully!");
		return true;
		}
		else return false;
	}
	else return false;
}

function validate_product_name()
{
	var check = document.getElementById("PMName");
	if(validate_isEmpty(check))
	{
		alert('Product Name cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_alphanumeric(check))
		{
		alert('Product Name must have only alphanumeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function validate_product_desc()
{
	var check = document.getElementById("PMDesc");
	if(validate_isEmpty(check))
	{
		alert('Product Description cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_alphanumeric(check))
		{
		alert('Product Description must have only alphanumeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function validate_product_feat()
{
	var check = document.getElementById("PMFeat");
	if(validate_isEmpty(check))
	{
		alert('Product Features cannot be empty');
		check.focus();
		return false;
	}
	return true;
}

function validate_product_price()
{
	var check = document.getElementById("Price");
	if(validate_isEmpty(check))
	{
		alert('Price cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_numeric(check))
		{
		alert('Price must have only numeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function validate_product_threshold()
{
	var check = document.getElementById("PMTh");
	if(validate_isEmpty(check))
	{
		alert('Product Threshold cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_numeric(check))
		{
		alert('Product Threshold must have only numeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function page_validate_add_product()
{
	if(validate_product_name())
	{
		if(validate_product_desc())
			if(validate_product_feat())
				
					if(validate_product_threshold())
					{
						alert('New product added successfully!');
						return true;
					}
					else return false;
				else return false;
			
		else return false;
	}
	else return false;
	
}

function validate_retailer_name()
{
	var check = document.getElementById("name");
	if(validate_isEmpty(check))
	{
		alert('Retailer Name cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_allLetter(check))
		{
		alert('Retailer Name must have only alphanumeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function validate_retailer_loc()
{
	var check = document.getElementById("loc");
	if(validate_isEmpty(check))
	{
		alert('Location cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_alphanumeric(check))
		{
		alert('Location must have only alphanumeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function validate_retailer_licence()
{
	var check = document.getElementById("licNo");
	if(validate_isEmpty(check))
	{
		alert('Licence number cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_alphanumeric(check))
		{
		alert('Licence number must have only alphanumeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function page_validate_add_retailer()
{
	if(validate_retailer_name())
	{
		if(validate_retailer_loc())
			if(validate_retailer_licence())
			{
				alert('New retailer added successfully!');
				return true;
			}
			else return false;
		else return false;
		
	}
	else return false;
}

function validate_stock_pcode()
{
	var check = document.getElementById("PCode");
	if(validate_isEmpty(check))
	{
		alert('Product Code cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_alphanumeric(check))
		{
		alert('Product Code must have only alphanumeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function validate_stock_pname()
{
	var check = document.getElementById("PName");
	if(validate_isEmpty(check))
	{
		alert('Product Name cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_alphanumeric(check))
		{
		alert('Product Name must have only alphanumeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function validate_stock_quantity()
{
	var check = document.getElementById("quantity");
	if(validate_isEmpty(check))
	{
		alert('Quantity cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_numeric(check))
		{
		alert('Quantity must have only numeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function validate_add_stock()
{
	if(validate_stock_pcode())
	{
		if(validate_stock_pname())
			if(validate_stock_quantity())
			{
				alert('New stock added successfully!');
				return true;
			}
			else return false;
	}
	
}

function validate_offer()
{
	var check = document.getElementById("order");
	if(validate_isEmpty(check))
	{
		alert('Offers cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_alphanumeric(check))
		{
		alert('Offers must have only numeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function validate_order_value()
{
	var check = document.getElementById("QUANTITY");
	if(validate_isEmpty(check))
	{
		alert('Order Value cannot be empty');
		check.focus();
		return false;
	}

	if(!validate_alphanumeric(check))
		{
		alert('Order Value must have only numeric characters.');
		check.focus();
		return false;
		}
	return true;
}

function page_validate_update_package()
{
	if(validate_offer())
	{
		if(validate_order_value())
		{
			alert('Package updated successfully!');
			return true;
		}
		else return false;
	}
	else return false;
}

function validate_packageID()
{
	var CP_ID=document.getElementById("CPID");
	var letters = /^[0-9A-Za-z]+$/;  
	
	if(CP_ID.value=="" ||CP_ID.value=="Enter the value")
	{
  		alert("Package ID cannot be empty");
  		CP_ID.focus();
  		return false;
  	}

	
	if(CP_ID.value.match(letters))  
	{  
	return true;  
	}  

	else  
	{  
	alert('Package ID must have alphanumeric characters only');  
	CP_ID.focus();  
	return false;  
	} 
		
}

function validate_EOV()
{
	var EOV=document.getElementById("EOV");
	var letters = /^[0-9]+$/;  
	
	if(EOV.value=="" ||EOV.value=="Enter the value")
	{
  		alert("EOV cannot be empty");
  		EOV.focus();
  		return false;
  	}

	
	if(EOV.value.match(letters))  
	{  
	return true;  
	}  

	else  
	{  
	alert('EOV must have numeric characters only');  
	EOV.focus();  
	return false;  
	} 
		
}

function validate_Desc()
{
	var Desc=document.getElementById("Desc");
	var letters = /^[0-9a-zA-Z]+$/;   
	
	if(Desc.value=="" ||Desc.value=="Enter the value")
	{
  		alert("Desc cannot be empty");
  		Desc.focus();
  		return false;
  	}

	
	if(Desc.value.match(letters))  
	{  
	return true;  
	}  

	else  
	{  
	alert('Desc must have alphanumeric characters only');  
	Desc.focus();  
	return false;  
	} 
		
}

function validate_add_package()
{

	if(validate_packageID())
	{
	if(validate_EOV())
		if(validate_Desc())
		{
			alert("New package added successfully!");
			return true;
		}
	}
	else
		return false;
	
	
		
}


function validate_ProductModelID()
{
	var PMID=document.getElementById("PMID");
	var letters = /^[0-9A-Za-z]+$/;  
	
	if(PMID.value=="" ||PMID.value=="Enter the value")
	{
  		alert("Product Model ID cannot be empty");
  		PMID.focus();
  		return false;
  	}

	
	if(PMID.value.match(letters))  
	{  
	return true;  
	}  

	else  
	{  
	alert('Product Model ID must have alphanumeric characters only');  
	PMID.focus();  
	return false;  
	} 
		
}

function validate_ProductModelName()
{
	var PMName=document.getElementById("PMName");
	var letters = /^[0-9A-Za-z]+$/;  
	
	if(PMName.value=="" ||PMName.value=="Enter the value")
	{
  		alert("Product Model Name cannot be empty");
  		PMName.focus();
  		return false;
  	}

	
	if(PMName.value.match(letters))  
	{  
	return true;  
	}  

	else  
	{  
	alert('Product Model Name must have alphanumeric characters only');  
	PMName.focus();  
	return false;  
	} 
		
}

function validate_ProductModelDesc()
{
	var PMDesc=document.getElementById("PMDesc");
	var letters = /^[0-9A-Za-z]+$/;  
	
	if(PMDesc.value=="" ||PMDesc.value=="Enter the value")
	{
  		alert("Product Description cannot be empty");
  		PMDesc.focus();
  		return false;
  	}

	
	if(PMDesc.value.match(letters))  
	{  
	return true;  
	}  

	else  
	{  
	alert('Product Description must have alphanumeric characters only');  
	PMDesc.focus();  
	return false;  
	} 
		
}

function validate_ProductModelFeatures()
{
	var PMFeat=document.getElementById("PMFeat");
	var letters = /^[0-9A-Za-z]+$/;  
	
	if(PMFeat.value=="" ||PMFeat.value=="Enter the value")
	{
  		alert("Product Features cannot be empty");
  		PMFeat.focus();
  		return false;
  	}

	
	if(PMFeat.value.match(letters))  
	{  
	return true;  
	}  

	else  
	{  
	alert('Product Features must have alphanumeric characters only');  
	PMFeat.focus();  
	return false;  
	} 
		
}

function validate_ProductModelPrice()
{
	var PMPrice=document.getElementById("PMPrice");
	var letters = /^[0-9]+$/;  
	
	if(PMPrice.value=="" ||PMPrice.value=="Enter the value")
	{
  		alert("Price cannot be empty");
  		PMPrice.focus();
  		return false;
  	}

	
	if(PMPrice.value.match(letters))  
	{  
	return true;  
	}  

	else  
	{  
	alert('Price must have numeric characters only');  
	PMPrice.focus();  
	return false;  
	} 
		
}

function validate_ProductModelThreshold()
{
	var PMTh=document.getElementById("PMTh");
	var letters = /^[0-9]+$/;  
	
	if(PMTh.value=="" ||PMTh.value=="Enter the value")
	{
  		alert("Threshold cannot be empty");
  		PMTh.focus();
  		return false;
  	}

	
	if(PMTh.value.match(letters))  
	{  
	return true;  
	}  

	else  
	{  
	alert('Threshold must have numeric characters only');  
	PMTh.focus();  
	return false;  
	} 
		
}


function validate_add_product()
{

	
	if(validate_ProductModelName())
	{
		if(validate_ProductModelDesc())
			if(validate_ProductModelFeatures())
				if(validate_ProductModelPrice())
					if(validate_ProductModelThreshold())
						{
						alert("New product added successfully!");
						return true;
						}
	}
	else
		return false;
	
	
		
}








function validate_isEmpty(variable)
{

if(variable.value=="" ||variable.value=="Enter the value")
{
return true;
}

else 
	return false;
}

function validate_allLetter(variable)  
{   
var letters = /^[A-Za-z]+$/;  
if(variable.value.match(letters))  
{  
return true;  
}  
else  
{   
return false;  
}  
}  

function validate_alphanumeric(variable)  
{   
var letters = /^[0-9a-zA-Z]+$/;  
if(variable.value.match(letters))  
{  
return true;  
}  
else  
{  
return false;  
}  
}

function validate_numeric(variable)  
{   
var letters = /^[0-9]+$/;  
if(variable.value.match(letters))  
{  
return true;  
}  
else  
{   
return false;  
}  
}
function data()
{
	document.input.name.value="name";
}

function DeleteConfirmation(linkbutton)
{
	if (linkbutton.innerText == "Delete")
	{
		if(confirm('Are you sure you want to Delete this Record'))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}



