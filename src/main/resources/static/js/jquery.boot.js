$(function() {
	$("#userList").click(function(){
		fetchList("user");
	});
	$("#addressList").click(function(){
		fetchList("address");
	});
});


var pageConstant = "?page=1";


function addForm(type){

	modifyData(type+"/form");
	
	
	//$.ajax({
	//	type: "GET",
	//	url:"/springboot/"+type+"/form",
	//	success: function(data){
	//		$(".inner-jsp").html(data);
	//	}
	//});
}

function editForm(type, id){
	
	modifyData(type+"/edit/"+id);
	
	//$.ajax({
	//	type: "GET",
	//	url:"/springboot/"+type+"/edit/"+id,
	//	success: function(data){
	//		$(".inner-jsp").html(data);
	//	}
	//});
}


function fetchList(type){
	modifyData(type+"/list"+pageConstant);
	

	//$.ajax({
	//	type: "GET",
	//	url:"/springboot/"+type+"/list"+pageConstant,
	//	success: function(data){
	//		
	//		$(".inner-jsp").html(data);
	//	}
	//});
}

function refresh(type){
	
	modifyData(type+"/refresh"+pageConstant);

	//$.ajax({
	//	type: "GET",
	//	url:"/springboot/"+type+"/refresh"+pageConstant,
	//	success: function(data){
	//		$(".inner-jsp").html(data);
	//	}
	//});
}

function list(type, page, size) {
	console.log("list function called....");
	modifyData(type+"/list?page="+page+"&size="+size);
}


function modifyData(suffix){
	$.ajax({
		type: "GET",
		url:"/springboot/"+suffix,
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





