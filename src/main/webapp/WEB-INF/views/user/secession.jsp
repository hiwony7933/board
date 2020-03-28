<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="login-box well">
				<form accept-charset="UTF-8" role="form" method="post"
					action="secession">
					<legend>비밀번호 입력</legend>
					<div style='color: red'>${msg}</div>
					<div class="form-group">
						<label for="password">비밀번호 </label> 
						<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="formcontrol" />
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary btn-login-submit btn-block m-t-md" value="비밀번호 확인" />
					</div>
					<div class="form-group">
						<a href="../" class="btn btn-success btn-block m-tmd">메인으로</a>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
</div>
<// %@ include file="../include/footer.jsp"%>

