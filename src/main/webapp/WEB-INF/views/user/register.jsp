<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<section class="content">
	<!-- 회원가입 -->
	<form id="registerform" enctype="multipart/form-data" method="post">
		<p align="center">
		<table border="1" width="50%" height="80%" align='center'>
			<tr>
				<td colspan="3" align="center"><h2>회원 가입</h2></td>
			</tr>
			<tr>
				<td rowspan="5" align="center">
					<p></p> <img id="img" width="100" height="100" border="1" /> <br />
					<br /> <input type='file' id="image" name="image"
					accept=".jpg,.jpeg,.gif,.png" /><br />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;이메일</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="email" name="email"
					id="email" size="30" maxlength=50 required="required" />
				<div id="emailDiv"> </div>				
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="password" name="pw" id="pw"
					size="20" required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호
						확인</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="password" id="pwconfirm"
					size="20" required="required" />
				<div id="pwDiv"></div>
				</td>
			</tr>
			<tr>
				<td width="17%" bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;닉네임</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="text" name="nickname"
					id="nickname" size="20" pattern="([a-z, A-Z, 가힣]){2,}"
					required="required" title="닉네임은 문자 2자 이상입니다." />
					<div id="nicknameDiv"></div>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3">
					<p></p> <input type="submit" value="회원가입" class="btn btn-warning" />
					<input type="button" value="메인으로" class="btn btn-success"
					onclick="javascript:window.location='/'">
					<p></p>
				</td>
			</tr>
		</table>
	</form>
	<br /> <br />
</section>
<// %@include file="../include/footer.jsp"%>

<script>
	var filename = ''
	// change 이벤트가 발생하면 readURL 호출
	// change - 내용이 변경되면 호출되는 이벤트
	document.getElementById("image").addEventListener('change', function(e) {
		if (this.files && this.files[0]) {
			filename = this.files[0].name;
			var reader = new FileReader();
			reader.onload = function(e) {
				document.getElementById('img').src = e.target.result;
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
	
	var emailcheck = false;	
	document.getElementById("email").addEventListener("blur",function() {
		var addr = "emailcheck";
		var email = document.getElementById("email").value;
		$.ajax({url : addr,	data : {'email' : email}, dataType : "json", success : function(data) {
						if (data.result == true) {
							document.getElementById("emailDiv").innerHTML = "사용 가능한 아이디입니다.";
							document.getElementById("emailDiv").style.color = 'blue';
							emailcheck = true;
						} else {
							document.getElementById("emailDiv").innerHTML = "사용 불가능한 아이디입니다.";
							document.getElementById("emailDiv").style.color = 'red';
							emailcheck = false
						}
					}
				});
	}) 
	
	var nicknamecheck = false;
	document.getElementById("nickname").addEventListener("focusout",function(){
		var nickname = document.getElementById("nickname").value;
		$.ajax({url : "nicknamecheck", data : {'nickname':nickname}, dataType : "json",	success : function(data) {
					if (data.result == true) {
						document.getElementById("nicknameDiv").innerHTML = "사용 가능한 nickname 입니다.";
						document.getElementById("nicknameDiv").style.color = 'blue';
						nicknamecheck = true;
					} else {
						document.getElementById("nicknameDiv").innerHTML = "사용 불가능한 nickname입니다.";
						document.getElementById("nicknameDiv").style.color = 'red';
						nicknamecheck = false
					}
				}
			});
	})
	
	document.getElementById("registerform").addEventListener("submit",function(e){
		if(emailcheck == false){
			document.getElementById("emailDiv").innerHTML = "이메일 중복검사를 수행하세요!!";
			document.getElementById("emailDiv").style.color='red';
			document.getElementById("email").focus();
			e.preventDefault();
			}
		if(nicknamecheck == false){
			document.getElementById("nicknameDiv").innerHTML = "닉네임 중복검사를 수행하세요!!";
			document.getElementById("nicknameDiv").style.color='red';
			document.getElementById("nickname").focus();
			e.preventDefault();
			}
	var pw = document.getElementById("pw").value;
	var pwconfirm = document.getElementById("pwconfirm").value;
		if(pw != pwconfirm){
			document.getElementById("pwDiv").innerHTML = "2개의 비밀번호가 다릅니다!!";
			document.getElementById("pwDiv").style.color='red';
			document.getElementById("pw").focus();
			e.preventDefault();
		}
	var pattern1 = /[0-9]/; // 숫자 var
		pattern2 = /[a-zA-Z]/; // 문자 var
		pattern3 = /[~!@#$%^&*()_+|<>?:{}]/;// 특수문자
		if(!pattern1.test(pw) || !pattern2.test(pw) || !pattern3.test(pw) || pw.length < 8) {
			document.getElementById("pwDiv").innerHTML = "비밀번호는 8자리 이상 문자, 숫자, 특수문자로 구성하여야 합니다.";
			document.getElementById("pw").focus();
			e.preventDefault();
		}
	})	
</script>