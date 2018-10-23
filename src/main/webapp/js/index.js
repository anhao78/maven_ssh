$(function() {
	pageObj.Init();
});

var pageObj = {
	Init : function() {
		$("#btn_login").click(function() {
			pageObj.LoginValidate();
		});
	},
	LoginValidate : function() {
		var param = {
			"username" : "123",
			"password" : "123"
		};
		$.ajax({
			type : 'get',
			url : 'savePrdCont1',
			data : param,
			cache : false,
			dataType : 'json',
			success : function(data) {
				$("#divp").html('after: ' + data);
			}
		});
	}
};
