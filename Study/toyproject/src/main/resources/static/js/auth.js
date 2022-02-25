$("#usernameCheck").blur(() => {


	let idJ = /^[a-z0-9]{4,12}$/;

	let username = $("#usernameCheck").val();

	$.ajax({
		type: "get",
		url: `/auth/${username}`,
	}).done(res => {

		if (res == true) {
			$("#checkFont").text("사용중인 아이디입니다.");
			$("#checkFont").css("color", "red");
		} else {

			if (idJ.test(username)) {
				$("#checkFont").text("사용 가능한 아이디입니다.");
				$("#checkFont").css("color", "blue");
			} else if (username == "") {
				$("#checkFont").text("아이디를 입력해주세요.");
				$("#checkFont").css("color", "red");
			} else {
				$("#checkFont").text("아이디는 소문자와 숫자 4~12 자리만 가능합니다.");
				$("#checkFont").css("color", "red");
			}
		}

	}).fail(error => {

	});
})


$("#passwordCheck").blur(() => {

	let pwJ = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;

	let password = $("#passwordCheck").val();

	if (password == "") {
		$("#passwordCheckFont").text("비밀번호를 입력해주세요.");
		$("#passwordCheckFont").css("color", "red");
	} else if (pwJ.test(password)) {
		$("#passwordCheckFont").text("사용 가능한 비밀번호입니다.");
		$("#passwordCheckFont").css("color", "blue");
	} else {
		$("#passwordCheckFont").text("비밀번호는 최소 8 자, 최소 하나의 문자, 하나의 숫자 및 하나의 특수 문자를 포함해주세요.");
		$("#passwordCheckFont").css("color", "red");
	}

})

$("#nameCheck").blur(() => {

	let nameJ = /^[가-힣]{2,6}$/;

	let name = $("#nameCheck").val();

	if (name == "") {
		$("#nameCheckFont").text("이름을 입력해주세요.");
		$("#nameCheckFont").css("color", "red");
	} else if (nameJ.test(name)) {
		$("#nameCheckFont").text("사용 가능한 이름입니다.");
		$("#nameCheckFont").css("color", "blue");
	} else {
		$("#nameCheckFont").text("이름은 2~6글자 한글로 작성해주세요.");
		$("#nameCheckFont").css("color", "red");
	}

})




auth = {
	init: function() {

		$("#btnUserUpdate").on("click", () => {
			this.btnUserUpdate();
		})

		$("#signUpBtn").on("click", () => {
			this.signUpBtn();
		})
	},


	btnUserUpdate: function() {

		let data = {
			userId: $("#userId").val(),
			password: $("#password").val(),
			name: $("#name").val(),
			phone: $("#phone").val()
		}

		if (data.password == null || data.password == "") {
			alert("비밀번호를 입력해주세요.");
		} else if (data.name == null || data.name == "") {
			alert("이름을 입력해주세요.");
		} else {
			let userUpdateConfirm = confirm("회원정보를 수정하시겠습니까?");

			if (userUpdateConfirm == true) {
				$.ajax({
					type: "put",
					url: `/api/auth/${data.userId}/update`,
					data: JSON.stringify(data),
					contentType: "application/json; charset-utf-8",
					dataType: "json"
				}).done(res => {
					location.href = "/";
				}).fail(error => {
					alert(JSON.stringify(error));
				});
			} else {
				return false;
			}
		}
	},


	/*signUpBtn: function() {

		let data = {
			username: $("#usernameCheck").val(),
			password: $("#passwordCheck").val(),
			name: $("#name").val()
		}

		alert(JSON.stringify(data));

		$.ajax({
			type: "post",
			url: "/auth/signUp",
			contentType: "application/json; charset-utf-8",
			data: JSON.stringify(data),
		}).done(res => {
			location.href = "/auth/signInForm";
		}).fail(error => {
			alert(JSON.stringify(error));
		});


	}*/


}



auth.init();