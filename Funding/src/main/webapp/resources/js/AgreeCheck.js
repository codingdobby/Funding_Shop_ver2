$("#chkAll").click(function() {
	// 전체동의에 체크할때
	if ($(this).is(":checked")) {

		$("input:checkbox[name='chk']").prop("checked", true);

	} else {
		$("input:checkbox[name='chk']").prop("checked", false);

	}

});

$("input:checkbox[name='chk']")
		.change(
				function() {
					console.log("체크 갯수"
							+ $("input:checkbox[name='chk']").length);
					if ($("input:checkbox[name='chk']:checked").length == $("input:checkbox[name='chk']").length) {
						$("#chkAll").prop("checked", true);
						console
								.log("체크 갯수"
										+ $("input:checkbox[name='chk']:checked").length);

					} else {
						$("#chkAll").prop("checked", false);

					}
				});

function checkNec() {
	var box = $("input:checkbox[name='chk']");

	if (box[0].checked == false) {
		alert("필수동의 사항에 동의해주세요");
		return false;

	} else if (box[1].checked == false) {

		alert("필수동의 사항에 동의해주세요");
		return false;
	}

}