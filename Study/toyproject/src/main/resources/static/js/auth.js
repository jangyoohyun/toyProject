let pwJ = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
let nameJ = /^[가-힣]{2,6}$/;
let idJ = /^[a-z0-9]{4,12}$/;

$("#username").blur(() => {

	let username = $("#username").val();

	$.ajax({
		type: "get",
		url: `/auth/${username}`,
	}).done(res => {

		if (res == true) {
			$("#checkFont").text("사용중인 아이디입니다.");
			$("#checkFont").css("color", "red");
		} else {
			if (idJ.test(username)) {
				$("#checkFont").text("");
			} else {
				$("#checkFont").text("아이디는 최소 6자, 영문자로 시작하는 영문자 또는 숫자 6~20자 이내로 입력해주세요.");
				$("#checkFont").css("color", "red");
			}
		}

	}).fail(error => {
		console.log(JSON.stringify(error));
	});
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
			email: $("#email").val(),
			phone: $("#phone").val()
		}

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
	},

	signUpBtn: function() {

		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			name: $("#name").val(),
			email: $("#email").val(),
			phone: $("#phone").val()
		}

		let userConfirm = confirm("회원가입을 하시겠습니까?");

		if (userConfirm == true) {
			$.ajax({
				type: "post",
				url: "/api/auth/signUp",
				contentType: "application/json; charset-utf-8",
				data: JSON.stringify(data)
			}).done(res => {
				location.href = "/auth/signInForm";
			}).fail(error => {
				location.href = "/auth/signUpForm";
				alert(JSON.stringify(error));
			});
		} else {
			return false;
		}
	}
}


auth.init();