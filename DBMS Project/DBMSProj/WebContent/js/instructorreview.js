var tabrowTemplate = '<tr>'+
					  	  '<td class="tabletext">studentname</td>'+
					  	  '<td class="tabletext1">comment</td>'+	
					  	  '<td class="tabletext">Teaching</td>'+
					  	  '<td class="tabletext">Knowledge</td>'+
					  	  '<td class="tabletext">Interaction</td>'+
					 '</tr>';

$(document).ready(function() {

	$('#deptnameselect').change(function() {
		if($(this).val()!="NONE"){
		$.ajax({
		      url: 'getinstructor.htm',
		      data: ({deptname : $('#deptnameselect option:selected').text()}),
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
		        	optElement.value = option[0];
		        	optElement.innerHTML = option[1];
		        	instructorSelect.appendChild(optElement);
		        }
		      }
		    });
		}
	});
	
	$('#instructornameselect').change(function() {
		if($(this).val()!="NONE"){
		$.ajax({
		      url: 'getofferingdetails.htm',
		      data: ({instructorId : $('#instructornameselect option:selected').val()}),
		      success: function(data) {
		    	    var options = data.split(":");
			        var i;
			        var optElement;
			        var option
			        $('#courseselect option[value!="NONE"]').remove()
			        instructorSelect = document.getElementById('courseselect');
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
	
	$('#courseselect').change(function() {
		if($(this).val()!="NONE"){
		$.ajax({
		      url: 'getinstructorreviews.htm',
		      data: ({offeringId : $('#courseselect option:selected').val()}),
		      success: function(data) {
		    	  if(data!=":"){
				    	  var rows = data.split(":");
				    	  var i ;
				    	  var rowData;
				    	  var modfiledtabrowTemplate;
				    	  var averages;
				    	  $('#name').html($('#instructornameselect option:selected').text());
				    	  $('#address').html($('#deptnameselect option:selected').text());
				    	  $("#reviewsData").find("tr:gt(0)").remove();
				    	  for (i=0;i<rows.length-1;i++){
				    		  rowData = rows[i].split("|");
				    		  modfiledtabrowTemplate = tabrowTemplate;
				    		  modfiledtabrowTemplate = modfiledtabrowTemplate.replace("studentname", rowData[0]);
				    		  modfiledtabrowTemplate = modfiledtabrowTemplate.replace("comment", rowData[1]);
				    		  modfiledtabrowTemplate = modfiledtabrowTemplate.replace("Teaching", rowData[2]);
				    		  modfiledtabrowTemplate = modfiledtabrowTemplate.replace("Knowledge", rowData[3]);
				    		  modfiledtabrowTemplate = modfiledtabrowTemplate.replace("Interaction", rowData[4]);
				    		  $('#reviewsData tbody').append(modfiledtabrowTemplate);
				    	  }
				    	  averages = rows[rows.length-1].split("|");
				    	  $('#teachingAvg').html(averages[0])
				    	  $('#commandAvg').html(averages[1])
				    	  $('#InteractionAvg').html(averages[2])
				    	  $('#reviewnumber').html(averages[3])
				    	  
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