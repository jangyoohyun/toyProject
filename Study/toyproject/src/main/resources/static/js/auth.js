auth = {
	init: function() {
		$("#btnUserUpdate").on("click", () => {
			this.btnUserUpdate();
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
	}

}



auth.init();