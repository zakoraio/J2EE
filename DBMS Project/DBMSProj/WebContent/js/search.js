
var query;

$(document).ready(function() {

$('#search').click(function() {
	query = $('#query').val();
	$('#loadingImage').css("display","block")
		$.ajax({
		      url:'searchResult.htm',
		      data: ({query : $('#query').val()}),
		      success: function(data) {
		        var docs = data.match(/~#.*?#~/g);
		        var txtData = data.split(/~#.*?#~/g);
		        var i;
		        var elementLink;
		        var elementText;
		        var element;
		        var contentDiv = document.getElementById('content_main');
		        while (contentDiv.firstChild) {
		        	contentDiv.removeChild(contentDiv.firstChild);
		        }
		        $('#query').remove()
		        $('#querytext').text("Query : "+query);
		        for(i=0;i<docs.length;i++){
		        	elementLink = document.createElement('a');
		        	elementLink.setAttribute('href',"#");
		        	elementLink.setAttribute('id',"a"+i);
		        	elementLink.setAttribute('name','link');
		        	elementLink.innerHTML = docs[i].replace("~#","").replace("#~","");
		        	elementText = document.createElement('div');
		        	elementText.setAttribute('style','display:none;color:rgb(10,150,20)');
		        	elementText.innerHTML = txtData[i+1];
		        	elementText.setAttribute('id','div'+i);
		        	contentDiv.appendChild(elementLink);
		        	contentDiv.appendChild(document.createElement('br'));
		        	contentDiv.appendChild(elementText);
		        	$('#a'+i).on("click", function(){
		        		var id = $(this).attr('id');
		        		var txtElement = $('#div'+id.substring(1,id.length));
		        		if(txtElement.css("display") == "block")
		        		txtElement.css("display","none");
		        		else 
		        		txtElement.css("display","block");
		        	});
		        }
		      },
		      complete: function(){
		    	  $('#loadingImage').css("display","none")
		      }
		    });
	});
});