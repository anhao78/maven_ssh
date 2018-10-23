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
		alert("asdf");
		var param = {
			"username" : $("[name=txt_name]").val(),
			"password" : $("[name=txt_pwd]").val(),
		};
		$.getJSON("http://localhost:8080/maven_ssh/savePrdCont1", param, function(data) {
			if (data != null) {
				var user = JSON.stringify(data); // 将返回用户对象信息转化为JSON字符串
				localStorage.setItem("user", user);
				location.href = "../htmltemplate/home.html";
			} else {
				alert('登录失败！');
			}
		});
	}
};
