let boardList = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});

		$("#btn-update").on("click", () => {
			this.update();
		})

		$("#btn-deleteById").on("click", () => {
			this.deleteById();
		})

	},

	save: function() {

		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		$.ajax({
			type: "POST",
			url: "/api/board/write",
			data: JSON.stringify(data),
			contentType: "application/json; charset-utf-8",
		}).done(res => {
			location.href = "/board";
		}).fail(error => {
			alert(JSON.stringify(error));
		});
	},

	update: function() {

		let id = $("#id").val();

		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		$.ajax({
			type: "PUT",
			url: "/api/board/update/" + id,
			data: JSON.stringify(data),
			contentType: "application/json; charset-utf-8",
		}).done(res => {
			location.href = "/board/" + id;
		}).fail(error => {
			alert(JSON.stringify(error));
		});

	},

	deleteById: function() {

		let id = $("#id").val();

		let result = confirm("글을 삭제하시겠습니까?");

		if (result == true) {
			$.ajax({
				type: "delete",
				url: "/api/board/delete/" + id,
				dataType: "json"
			}).done(res => {
				location.href = "/board";
			}).fail(error => {
				alert(JSON.stringify(error));
			});
		} else {
			return false;
		}

	}

}

boardList.init();