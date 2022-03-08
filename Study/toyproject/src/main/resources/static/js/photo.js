let photoList = {
	init: function() {
		$("#btn-photoUpdate").on("click", () => {
			this.photoUpdate();
		});

		$("#btn-deleteById").on("click", () => {
			this.deleteById();
		});

		$("#btn-photoCommentSave").on("click", () => {
			this.photoCommentSave();
		});
	},

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
	},


	photoCommentSave: function() {

		let photoSaveConfirm = confirm("댓글을 등록하시겠습니까?");

		let data = {
			userId: $("#userId").val(),
			photoId: $("#photoId").val(),
			photoCommentContent: $("#photoCommentContent").val()
		};

		if (photoSaveConfirm == true) {
			$.ajax({
				type: "POST",
				url: `/api/photo/comment/${data.photoId}`,
				data: JSON.stringify(data),
				contentType: "application/json; charset-utf-8",
			}).done(res => {
				location.href = `/photo/${data.photoId}`;
			}).fail(error => {
				alert(JSON.stringify(error));
			});
		} else {
			return false;
		}



	},

	commentDelete: function(photoId, commentId) {

		let deleteConfirm = confirm("댓글을 삭제하시겠습니까?");

		if (deleteConfirm == true) {
			$.ajax({
				type: "delete",
				url: `/api/photo/${photoId}/delete/${commentId}`,
			}).done(res => {
				location.href = "/photo/" + photoId;
			}).fail(error => {
				alert(JSON.stringify(error));
			});

		} else {
			return false;
		}

	},

	commentUpdate: function(photoId, commentId) {
		
		if ($("#commentUpdateDisplay-" + commentId).css('display') == 'none') {
			$("#commentUpdateDisplay-" + commentId).show();

			$("#btn-photoCommentUpdate-" + commentId).on("click", () => {

				let commentConfirm = confirm("댓글을 수정하시겠습니까?");

				if (commentConfirm == true) {
					
					let data = {
						photoCommentContent: $("#commentUpdateContent-" + commentId).val()
					}


					$.ajax({
						type: "PUT",
						url: `/api/photo/${photoId}/update/${commentId}`,
						data: JSON.stringify(data),
						contentType: "application/json; charset-utf-8"
					}).done(res => {
						location.href = `/photo/${photoId}`;
					}).fail(error => {
						alert(JSON.stringify(error));
					});
				} else {
					return false;
				}

			});

		} else {
			$("#commentUpdateDisplay-" + commentId).hide();
		}

	}

}

photoList.init();