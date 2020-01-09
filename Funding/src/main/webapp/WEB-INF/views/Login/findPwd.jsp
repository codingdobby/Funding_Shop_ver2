<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link href="https://fonts.googleapis.com/css?family=Do Hyeon"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pwd.css"
	type="text/css">
<style type="text/css">
input[type="password"] {
	width: 100%;
}

input[type="button"] {
	width: 100%;
	display: block;
	box-sizing: border-box;
	background-color: #FF6F61;
	padding: 10px;
	border: 1px solid #eeeeee;
	border-radius: 3px;
	font-family: 'Do Hyeon', sans-serif;
	font-size: 100%;
	outline: none;
	color: #FFFFFF;
}

input[type="submit"]:hover, /*foucs는 탭으로 갔을때*/ input[type="submit"]:focus
	{
	border: 2px solid black;
	box-shadow: inset 2px 2px 2px rgba(0, 0, 0, .13)
}
 
 .findPWD {
 border: 1px solid black;
 width: 500px;
 padding: 10px;
 }
#checkid{
font-size: 15pt;
}


</style>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script>
function checkID(){
if (document.iform.checkid.value === "" || isNaN(iform.checkid.value) === false) { //isNaN에 의해서 숫자는 처리 불가
	iform.checkid.focus(); //request는 생략 가능(java)
	alert("아아디를 입력하세요");
	return false;
}
//정규 표현식으로 입력자료 검사
var aa = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/; // 표준식
// a부터 z까지 문자 1개 이상일 경우 and 숫자 0,1,2일 경우에만 / [^a-z, 0,1,2] : ^ 붙이면 부정의 뜻 / 한글은 가-힣
if (!iform.checkid.value.match(aa)) {
	alert("이메일 형식으로 입력하세요!");
	iform.checkid.focus();
	return false;
}
}
</script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>


	<form action="findPwd2.do" method="post" name="iform" id="iform">
	<div align="center">
		<div class="findPWD">
			<table>

				<tr>
					<th colspan="2">비밀번호 설정</th>
				</tr>

				<tr>
					<td>아이디를 입력해주세요</td>
					
				</tr>
				
				<tr>
				<td><input type="text" name="checkid" id="checkid" maxlength="40"></td>
				</tr>
				<tr>
					<td><input type="button" id="FindPWd" value="다음" onclick="checkID()">
					<br>
						<h3 id="result"></h3> <script
							src="//code.jquery.com/jquery-3.2.1.min.js"></script> <script>
					$(function() {

					    $("#FindPWd").on("click", function() {

					    	 $.ajax({
					    		    url: "findPwdTest.do",
					    		    type: "POST",
					    		    data: $("#iform").serialize(),
					    		    dataType:"text",
					    		    success: function(data){
					    		    console.log(data);
					    		      if(data=="success"){
					    		      	location.href="findPwd2.do"
					    		    	    }
					    		      else {
					    		    	  $('#result').html("아이디가 존재하지않습니다");
					    		    	  
					    		      }
					    		      if(data=="nothing"){
					    		    	  
					    		    	  $('#result').html("");
					    		      }
					    		    },
					    		    
					    		    error: function (request, status, error){        
					    		        var msg = "ERROR : " + request.status + "<br>"
					    		      msg +=  + "내용 : " + request.responseText + "<br>" + error;
					    		      console.log(msg);              
					    		    }
					    		  });
						});
					});
					</script></td>




				</tr>

			</table>

		</div>
		</div>
	</form>

	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>