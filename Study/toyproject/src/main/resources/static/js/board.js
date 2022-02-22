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

	},

	commentSave: function() {

		let data = {
			userId: $("#userId").val(),
			boardId: $("#boardId").val(),
			commentContent: $("#commentContent").val()
		};

		alert(JSON.stringify(data));

		$.ajax({
			type: "POST",
			url: `/api/board/comment/${data.boardId}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset-utf-8",
			dataType: "json"
		}).done(res => {
			location.href = `/board/${data.boardId}`;
		}).fail(error => {
			alert(JSON.stringify(error));
		});

	},

	commentDelete: function(boardId, commentId) {

		let deleteConfirm = confirm("댓글을 삭제하시겠습니까?");

		if (deleteConfirm == true) {
			$.ajax({
				type: "delete",
				url: `/api/board/${boardId}/delete/${commentId}`,
				dataType: "json"
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

			$("#btn-commentUpdate-"+commentId).on("click", () => {
		
				let data = {
					commentId: $("#commentId").val(),
					commentUpdateContent: $("#commentUpdateContent").val()
				}

				alert(JSON.stringify(data));

				$.ajax({
					type: "PUT",
					url: `/api/board/${boardId}/update/${commentId}`,
					data: JSON.stringify(data),
					contentType: "application/json; charset-utf-8"
				}).done(res => {
					alert(JSON.stringify(data));
					location.href = `/board/${boardId}`;
				}).fail(error => {
					console.log(error);
					alert(JSON.stringify(error));
				});

			});

		} else {
			$("#commentUpdateDisplay-" + commentId).hide();
		}

	}

}


boardList.init();