let photoList = {
	init: function() {
		$("#btn-photoUpdate").on("click", () => {
			this.photoUpdate();
		});
	},
	
	photoUpdate: function() {

		let id = $("#id").val();

		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
			photoImageUrl: $("#photoImageUrl").val()
		};

		$.ajax({
			type: "PUT",
			url: "/api/photo/photoUpdate/"+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset-utf-8",
		}).done(res => {
			location.href = "/photo/" + id;
		}).fail(error => {
			alert(JSON.stringify(error));
		});

	},
	
}

photoList.init();