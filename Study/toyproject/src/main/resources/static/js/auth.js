let pwJ = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
let nameJ = /^[가-힣]{2,10}$/;
let idJ = /^[a-z0-9]{4,12}$/;
let emailJ = /^[0-9a-zA-Z]([-_￦.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_￦.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
let phoneJ = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;

$("#username").blur(() => {

	let username = $("#username").val();

	if (username == "") {
		$("#checkUsername").text("아이디를 입력해주세요.");
		$("#checkUsername").css("color", "red");
	}

	$.ajax({
		type: "get",
		url: `/auth/${username}`,
	}).done(res => {

		if (res == true) {
			$("#checkUsername").text("사용중인 아이디입니다.");
			$("#checkUsername").css("color", "red");
		} else {
			if (!idJ.test(username)) {
				$("#checkUsername").text("아이디는 최소 6자, 영문자로 시작하는 영문자 또는 숫자 6~20자 이내로 입력해주세요.");
				$("#checkUsername").css("color", "red");
			} else {
				$("#checkUsername").text("");
			}
		}

	}).fail(error => {
		console.log(JSON.stringify(error));
	});
})

$("#password").blur(() => {

	let password = $("#password").val();

	if (password == "") {
		$("#checkPassword").text("비밀번호를 입력해주세요.");
		$("#checkPassword").css("color", "red");
	} else {
		if (!pwJ.test(password)) {
			$("#checkPassword").text("최소 8 자, 최소 하나의 문자, 하나의 숫자 및 하나의 특수 문자를 입력해주세요")
			$("#checkPassword").css("color", "red");
		} else {
			$("#checkPassword").text("");
		}
	}


})

$("#name").blur(() => {

	let nick = $("#name").val();

	if (name == "") {
		$("#checkName").text("이름을 입력해주세요.");
		$("#checkName").css("color", "red");
	}

	$.ajax({
		type: "get",
		url: `/auth/${nick}`
	}).done(res => {

		if (res == true) {
			$("#checkName").text("사용중인 닉네임입니다.");
			$("#checkName").css("color", "red");
		} else {
			if (!nameJ.test(nick)) {
				$("#checkName").text("이름은 한글 2~6자 이내로 입력해주세요.");
				$("#checkName").css("color", "red");
			} else {
				$("#checkName").text("");
			}
		}
	}).fail(error => {

	});

})

$("#email").blur(() => {

	let email = $("#email").val();

	if (email == "") {
		$("#checkEmail").text("메일주소를 정확히 입력해주세요.");
		$("#checkEmail").css("color", "red");
	} else {
		if (!emailJ.test(email)) {
			$("#checkEmail").text("메일 형식에 맞게 작성해주세요.");
			$("#checkEmail").css("color", "red");
		} else {
			$("#checkEmail").text("");
		}
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

		$("#findUsernameBtn").on("click", () => {
			this.findUsernameBtn();
		})

		$("#findPasswordBtn").on("click", () => {
			this.findPasswordBtn();
		})
	},


	btnUserUpdate: function() {

		let data = {
			userId: $("#userId").val(),
			password: $("#password").val(),
			name: $("#name").val(),
			email: $("#email").val(),
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
				alert("입력값을 확인 후 다시 시도해주세요!");
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
				alert("입력값을 확인 후 다시 시도해주세요!");
			});
		} else {
			return false;
		}
	},

	findUsernameBtn: function() {

		let email = $("#email").val()

		$.ajax({
			type: "post",
			url: `/api/auth/${email}`,
			contentType: "application/json; charset-utf-8",
			data: JSON.stringify(email),
		}).done((username) => {
			location.href = `/auth/findUsername/${username}`;

		}).fail(error => {
			alert("이메일과 일치하는 아이디가 없습니다. 확인 후 다시 시도해주세요.");
		});

	},

	findPasswordBtn: function() {

		let data = {
			username: $("#FPusername").val(),
			email: $("#FPemail").val()
		}

		$.ajax({
			type: "post",
			url: "/api/auth/findPassword",
			contentType: "application/json; charset-utf-8",
			data: JSON.stringify(data)
		}).done(res => {
			location.href = "/auth/signInForm";
		}).fail(error => {
			alert("입력하신 정보와 일치하는 사용자가 없습니다. 확인 후 다시 시도해주세요.");
		});

	}
}


auth.init();