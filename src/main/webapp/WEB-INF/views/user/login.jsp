<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="login-box well">
				<form accept-charset="UTF-8" role="form" method="post" action="login">
					<legend>로그인 </legend>
					<div style='color: red'>${msg}</div>
					<div class="form-group">
						<label for="email">EMAIL</label> 
						<input type="email" name="email" id="email" placeholder="email을 입력하세요" class="form-control" />
					</div>
					<div class="form-group">
						<label for="password"> 비밀번호</label> 
						<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control" />
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary btn-login-submit btn-block m-t-md" value="로그인" />
					</div>
					<div class="form-group">
						<a href="register" class="btn btn-warning btn-block m-t-md">회원가입</a>
					</div>
					<div class="form-group">
						<a href="/" class="btn btn-success btn-block m-t-md">메인으로</a>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
</div>
<// %@ include file="../include/footer.jsp"%>