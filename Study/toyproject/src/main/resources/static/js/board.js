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

		$("#btn-commentSave").on("click", () => {
			this.commentSave();
		})

		$("#likeBtn").on("click", () => {
			this.likeBtn();
		})

	},

	save: function() {

		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		let boardWriteConfirm = confirm("글을 등록하시겠습니까?");

		if (boardWriteConfirm == true) {
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
		} else {
			return false;
		}


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

	},

	commentSave: function() {

		let data = {
			userId: $("#userId").val(),
			boardId: $("#boardId").val(),
			commentContent: $("#commentContent").val()
		};

		let commentSaveConfirm = confirm("댓글을 등록하시겠습니까?");

		if (commentSaveConfirm == true) {

			$.ajax({
				type: "POST",
				url: `/api/board/comment/${data.boardId}`,
				data: JSON.stringify(data),
				contentType: "application/json; charset-utf-8",
			}).done(res => {
				location.href = `/board/${data.boardId}`;
			}).fail(error => {
				alert(JSON.stringify(error));
			});
		} else {
			return false;
		}



	},

	commentDelete: function(boardId, commentId) {

		let deleteConfirm = confirm("댓글을 삭제하시겠습니까?");

		if (deleteConfirm == true) {
			$.ajax({
				type: "delete",
				url: `/api/board/${boardId}/delete/${commentId}`,
			}).done(res => {
				location.href = "/board/" + boardId;
			}).fail(error => {
				alert(JSON.stringify(error));
			});

		} else {
			return false;
		}

	},

	commentUpdate: function(boardId, commentId) {


		if ($("#commentUpdateDisplay-" + commentId).css('display') == 'none') {
			$("#commentUpdateDisplay-" + commentId).show();

			$("#btn-commentUpdate-" + commentId).on("click", () => {

				let commentConfirm = confirm("댓글을 수정하시겠습니까?");

				if (commentConfirm == true) {
					let data = {
						commentContent: $("#commentUpdateContent-" + commentId).val()
					}

					$.ajax({
						type: "PUT",
						url: `/api/board/${boardId}/update/${commentId}`,
						data: JSON.stringify(data),
						contentType: "application/json; charset-utf-8"
					}).done(res => {
						location.href = `/board/${boardId}`;
					}).fail(error => {
						console.log(error);
						alert(JSON.stringify(error));
					});
				} else {
					return false;
				}
			});

		} else {
			$("#commentUpdateDisplay-" + commentId).hide();
		}

	},

	likeBtn: function(boardId) {
		
		let likeIcon = $("#likeButton");

		if ($("#likeButton").hasClass("fa-regular")) {
			$.ajax({
				type: "post",
				url: `/api/board/${boardId}/likes`,
				data: boardId
			}).done(res => {

				likeIcon.removeClass("fa-regular");
				likeIcon.addClass("fa-solid");
				
				let likeCountStr = $("#likeCount").text();
				let likeCount = Number(likeCountStr) + 1;
				$("#likeCount").text(likeCount);

			}).fail(error => {
				console.log(error);
			})

		} else {

			$.ajax({
				type: "delete",
				url: `/api/board/${boardId}/unlikes`,
			}).done(res => {

				likeIcon.removeClass("fa-solid");
				likeIcon.addClass("fa-regular");
				
				let likeCountStr = $("#likeCount").text();
				let likeCount = Number(likeCountStr) - 1;
				$("#likeCount").text(likeCount);

			}).fail(error => {
				console.log(error);
			})

		}

	}

}


boardList.init();