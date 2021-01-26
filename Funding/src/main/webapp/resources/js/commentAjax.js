/**
 * comment add , select, 수정, delete
 */

// 댓글 등록
var values = $("#write_comment").val;
$.ajax({
	url : "addComment",
	type : "post",
	data : values,
	contentType : "application/json; charset=utf-8;",
	dataType : "json",

	success : function(result) {
		alert("댓글 등록 성공");
	}
});