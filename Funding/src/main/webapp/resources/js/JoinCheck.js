/**
 * 
 */

window.onload = function() {
		document.getElementById("send").onclick = chkData;

	}
	function chkData() {
		if(document.iform.nickname.value==""  || isNaN(iform.nickname.value) === false ){
			iform.nickname.focus(); //request는 생략 가능(java)
			alert("닉네임을 입력하세요");
			return false;
			
		}
		
		if (document.iform.id.value === "" || isNaN(iform.id.value) === false) { //isNaN에 의해서 숫자는 처리 불가
			iform.id.focus(); //request는 생략 가능(java)
			alert("아아디를 입력하세요");
			return false;
		}
		//정규 표현식으로 입력자료 검사
		var aa = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/; // 표준식
		// a부터 z까지 문자 1개 이상일 경우 and 숫자 0,1,2일 경우에만 / [^a-z, 0,1,2] : ^ 붙이면 부정의 뜻 / 한글은 가-힣
		if (!iform.id.value.match(aa)) {
			alert("이메일 형식으로 입력하세요!");
			iform.id.focus();
			return false;
		}

		if (document.iform.pwd.value === "") { //isNaN에 의해서 숫자는 처리 불가
			iform.pwd.focus(); //request는 생략 가능(java)
			alert("비밀번호를 입력하세요");
			return false;
		}
	
	

		if (iform.pwd.value.length < 8 || iform.pwd.value.length>20) {
			alert("비밀번호는 8~20자 이내로 입력 가능합니다!");

			iform.pwd.focus();//입력한 문자를 선택 상태로 만듬.
			return false;
		}
		if(iform.pwd.value!= iform.pwd1.value){
			iform.pwd1.focus();
			alert("비밀번호가 일치하지 않습니다.");
			return false;
			
		}
		

		iform.action = "loginInsert.do";
		iform.method = "post";
		iform.submit(); //서버에 파일로 전송(servlet, jsp)

	}