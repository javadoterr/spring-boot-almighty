$(function() {
	$("#userList").click(function(){
		fetchList("user");
	});
	$("#addressList").click(function(){
		fetchList("address");
	});
});

function addForm(type){
	$.ajax({
		type: "GET",
		url:"/springboot/"+type+"/form",
		success: function(data){
			$(".inner-jsp").html(data);
		}
	});
}

function editForm(type, id){
	console.log(id);
	$.ajax({
		type: "GET",
		url:"/springboot/"+type+"/edit/"+id,
		success: function(data){
			$(".inner-jsp").html(data);
		}
	});
}


function fetchList(type){
	$.ajax({
		type: "GET",
		url:"/springboot/"+type+"/list",
		success: function(data){
			$(".inner-jsp").html(data);
		}
	});
}

function refresh(type){
	$.ajax({
		type: "GET",
		url:"/springboot/"+type+"/refresh",
		success: function(data){
			$(".inner-jsp").html(data);
		}
	});
}

function deleteData(type, id){
	toastr.warning("<div>Are you sure you want to delete this ?</div>"+
			"<div class='btn-group text-right'>" +
			"<button type='button' id='confirmationYes' class='btn btn-xs btn-danger'>Yes</button>"+
			"<button type='button' class='btn btn-xs btn-default clear'>No</button>"+
			 "</div>", "DeleteConfirmation",{
			 	allowHtml:true,
			 	closeButton:true,
			 	onShown:function() {
			 	$("#confirmationYes").click(function() {
			 		$.ajax({
						type: "GET",
						url:"/springboot/"+type+"/delete/"+id,
						success: function(data){
							fetchList(type);
							toastr.success(data.message, "Delete Confirmation");
						}
				    });
			    });	
		    }
	});
}





