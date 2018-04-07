function showDropMenu(id) 
{
	
	var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) 
    {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) 
      {
        openDropdown.classList.remove('show');
      }
    }
	var ids = 'myDropdown-';
	var final = ids+id;
	console.log(final);
	var x = document.getElementById(final);
	console.log(x);
    document.getElementById(final).classList.toggle("show");
    //document.getElementById('myDropdown').classList.toggle("show");
    
}


function myFunction() 
{
	
	var dropdowns = document.getElementsByClassName("dropdown-content");
    
	var ids = 'myDropdown';
	document.getElementById(ids).classList.toggle("show");
    //document.getElementById('myDropdown').classList.toggle("show");
    
}


window.onclick = function(event) 
{
	 
	if (!event.target.matches('.dropbtn')) 
	{

	    var dropdowns = document.getElementsByClassName("dropdown-content");
	    var i;
	    for (i = 0; i < dropdowns.length; i++) 
	    {
	      var openDropdown = dropdowns[i];
	      if (openDropdown.classList.contains('show')) {
	        openDropdown.classList.remove('show');
	      }
	    }
	  }
	
	
	jQuery('#example tbody').on('click', 'tr', function () 
	{
	   jQuery('#example tbody tr').removeClass();
	   jQuery(this).removeClass();
		var id = this.id;
	    jQuery(this).toggleClass('selected');
	    var locId=jQuery('td:first', jQuery(this)).text();
	    console.log(locId);
	    jQuery.ajax({
	    	//headers: {'X-CSRF-TOKEN': cookie.csrf},
			timeout: 1000,
			type: 'GET',
	        url: "/api/location/"+locId
	        	
	    }).then(function(data) 
	    {
	       console.log(data);
	       
	       
	       document.getElementById('locationIdData').innerHTML=data.locationId;
	       document.getElementById('locationNameData').innerHTML=data.locationName;
	       document.getElementById('locationAddressData').innerHTML=data.locationAddress;
	       document.getElementById('locationCityData').innerHTML=data.locationCity;
	    	
	    });
	    
	    
	    
	} );
}




function VIEW_EMPLOYEE()
{
	//document.getElementById('containerDiv').innerHTML='';
	//document.getElementById('containerDiv').innerHTML='THIS IS VIEW EMPLOYEE SCREEN';
	console.log("done");
	
}


function VIEW_LOCATIONS()
{
	//document.getElementById('containerDiv').innerHTML='';
	//document.getElementById('containerDiv').innerHTML='THIS IS VIEW LOCATIONS SCREEN';
	
	document.getElementById('containerDiv').innerHTML='<table id="example"><thead><tr><th>Location ID</th><th>Location Name</th><th>Location Address</th><th>Location City</th></tr></thead></table>';
	document.getElementById('detailDataDiv').innerHTML='<table border="1" width="100%"><tr><td>Location Id</td><td id="locationIdData"></td></tr><tr><td>Location Name</td><td id="locationNameData"></td></tr><tr><td>Location Address</td><td id="locationAddressData"></td></tr><tr><td>Location City</td><td id="locationCityData"></td></tr></table>';
	console.log("done");
	var table=null;
	if ( jQuery.fn.dataTable.isDataTable( '#example' ) ) 
	{
	    table = jQuery('#example').DataTable();
	}
	else
		{
	
	 table = jQuery('#example').DataTable({
		    paging:true,
		    sortable:true,
		    select:true,
		    "bDestroy": true,
			"sAjaxSource": "/api/locations",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "locationId"},
		      { "mData": "locationName" },
				  { "mData": "locationAddress" },
				  { "mData": "locationCity" },
				  
			]
	 });
	 
	
		}
	//Using jQuery instead of $ as prototype.js is being used for calendar
	/*
	jQuery(document).ready(function() {
		jQuery.ajax({
	    	//headers: {'X-CSRF-TOKEN': cookie.csrf},
			timeout: 1000,
			type: 'GET',
	        url: "/api/locations"
	        	
	    }).then(function(data) 
	    {
	       console.log(data);
	       
	       var finalData = '<table border="1"><tr><th>Location ID</th><th>Location Name</th><th>Location Address</th><th>Location City</th></tr><tr>';
	       jQuery.each(data, function(index, location)
	    		   {
	    	   			finalData = finalData+'<td>'+location.locationId+'</td>';
	    	   			finalData = finalData+'<td>'+location.locationName+'</td>';
	    	   			finalData = finalData+'<td>'+location.locationAddress+'</td>';
	    	   			finalData = finalData+'<td>'+location.locationCity+'</td></tr>';
	    		   });
	    	finalData=finalData+'</table>';
	    	document.getElementById('containerDiv').innerHTML=finalData;
	       
	       jQuery('#example').dataTable( {
	           "ajax": data
	       } );
	    	
	    });
	});*/
	
}




