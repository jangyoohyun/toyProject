let photoList = {
	init: function() {
		$("#btn-photoUpdate").on("click", () => {
			this.photoUpdate();
		});

		$("#btn-deleteById").on("click", () => {
			this.deleteById();
		});
	},

	/*photoUpdate: function() {

		let id = $("#id").val();

		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
			photoImageUrl: $("#photoImageUrl").val()
		};

		$.ajax({
			type: "PUT",
			url: "/api/photo/photoUpdate/" + id,
			data: JSON.stringify(data),
			contentType: "application/json; charset-utf-8",
		}).done(res => {
			location.href = "/photo/" + id;
		}).fail(error => {
			alert(JSON.stringify(error));
		});

	},*/

	deleteById: function() {

		let id = $("#id").val();

		var deleteConfirm = confirm("글을 삭제하시겠습니까?");

		if (deleteConfirm == true) {
			$.ajax({
				type: "delete",
				url: "/api/photo/photoDelete/" + id,
				dataType: "json"
			}).done(res => {
				location.href = "/photo";
			}).fail(error => {
				console.log(error);
			})
		} else {
			return false;
		}
	}

}

photoList.init();