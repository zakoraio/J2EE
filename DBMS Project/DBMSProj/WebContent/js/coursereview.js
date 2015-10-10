var tabrowTemplate = '<tr>'+
					  	  '<td class="tabletext">studentname</td>'+
					  	  '<td class="tabletext1">comment</td>'+	
					  	  '<td class="tabletext">Exams</td>'+
					  	  '<td class="tabletext">Quizes</td>'+
					  	  '<td class="tabletext">Projects</td>'+
					  	'<td class="tabletext">Assignements</td>'+
					 '</tr>';

$(document).ready(function() {

	$('#deptnameselect').change(function() {
		if($(this).val()!="NONE"){
			
			
			$.get("http://www.google.com" ,function( data ) {
				  alert( "Data Loaded: " + data );
			});
			/*$.ajax({
				   url: 'http://www.google.com',
				   type: 'GET',
				   crossDomain : 'true',
				   success: function() {
				    alert("hello");
				   },
				   headers : {
					   'Access-Control-Allow-Origin' : '*'  
				   },
				   beforeSend: function (request)
		            {
		                request.setRequestHeader('Access-Control-Allow-Origin', '*');
		            }
				});*/
			
		$.ajax({
		      url: 'getcourse.htm',
		      data: ({deptname : $('#deptnameselect option:selected').text()}),
		      success: function(data) {
		        var options = data.split(":");
		        var i;
		        var optElement;
		        var option
		        $('#courseselect option[value!="NONE"]').remove()
		        instructorSelect = document.getElementById('courseselect');
		        for(i=0;i<options.length-1;i++){
		        	option = options[i].split("_");
		        	optElement = document.createElement('option');
		        	optElement.value = option[0];
		        	optElement.innerHTML = option[1];
		        	instructorSelect.appendChild(optElement);
		        }
		      }
		    });
		}
	});
	
	$('#courseselect').change(function() {
		if($(this).val()!="NONE"){
		$.ajax({
		      url: 'getinstructoryear.htm',
		      data: ({courseId : $('#courseselect option:selected').val()}),
		      success: function(data) {
		    	    var options = data.split(":");
			        var i;
			        var optElement;
			        var option
			        $('#instructornameselect option[value!="NONE"]').remove()
			        instructorSelect = document.getElementById('instructornameselect');
			        for(i=0;i<options.length-1;i++){
			        	option = options[i].split(",");
			        	optElement = document.createElement('option');
			        	optElement.innerHTML = option[0].replace(";"," ");
			        	optElement.value = option[1];
			        	instructorSelect.appendChild(optElement);
			        }
			      }
		    });
		}
	});
	
	$('#instructornameselect').change(function() {
		if($(this).val()!="NONE"){
		$.ajax({
		      url: 'getcoursereviews.htm',
		      data: ({offeringId : $('#instructornameselect option:selected').val()}),
		      success: function(data) {
		    	  if(data!=":"){
				    	  var rows = data.split(":");
				    	  var i ;
				    	  var rowData;
				    	  var modfiledtabrowTemplate;
				    	  var averages;
				    	  var nameText = $('#instructornameselect option:selected').text();
				    	  nameText = nameText.replace("SUMMER","").replace("SPRING","").replace("FALL","").replace(/[0-9]/g,"");
				    	  $('#name').html(nameText);
				    	  $('#address').html($('#deptnameselect option:selected').text());
				    	  $("#reviewsData").find("tr:gt(0)").remove();
				    	  for (i=0;i<rows.length-1;i++){
				    		  rowData = rows[i].split("|");
				    		  modfiledtabrowTemplate = tabrowTemplate;
				    		  modfiledtabrowTemplate = modfiledtabrowTemplate.replace("studentname", rowData[0]);
				    		  modfiledtabrowTemplate = modfiledtabrowTemplate.replace("comment", rowData[1]);
				    		  modfiledtabrowTemplate = modfiledtabrowTemplate.replace("Exams", rowData[2]);
				    		  modfiledtabrowTemplate = modfiledtabrowTemplate.replace("Quizes", rowData[3]);
				    		  modfiledtabrowTemplate = modfiledtabrowTemplate.replace("Projects", rowData[4]);
				    		  modfiledtabrowTemplate = modfiledtabrowTemplate.replace("Assignements", rowData[5]);
				    		  $('#reviewsData tbody').append(modfiledtabrowTemplate);
				    	  }
				    	  averages = rows[rows.length-1].split("|");
				    	  $('#ExamsAvg').html(averages[0])
				    	  $('#commandAvg').html(averages[1])
				    	  $('#InteractionAvg').html(averages[2])
				    	  $('#assignAvg').html(averages[3])
				    	  $('#workload').html(averages[4])
				    	  
				    	  
				    	  $('#content2').removeClass("hidden");
				    	  $('#reviewdiv').removeClass("hidden");
				    	  $('.user').removeClass("hidden");
				    	  $('.userdata').removeClass("hidden");
				    	  $('.review').removeClass("hidden");
				    	  $('#cumulativeData').removeClass("hidden");
				    	  $('#reviewcommentsdiv').removeClass("hidden");
				    	  $('#reviewsData').removeClass("hidden");
				    	  $('#content4').addClass("hidden")
				    	  $('#content4 p').addClass("hidden")
					   }
		    	  else{
			    	  $('#reviewdiv').addClass("hidden");
			    	  $('.user').addClass("hidden");
			    	  $('.userdata').addClass("hidden");
			    	  $('.review').addClass("hidden");
			    	  $('#cumulativeData').addClass("hidden");
			    	  $('#reviewcommentsdiv').addClass("hidden");
			    	  $('#reviewsData').addClass("hidden");
			    	  $('#content2').addClass("hidden");
			    	  $('#content4').removeClass("hidden").html('<p class="noreviews">No Reviews Available</p>');
		    	  }
		      	}
		   });
		}
	});	
});