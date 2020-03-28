<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Study 게시글 작성</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">Study 게시글 작성</div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form role="form" method="post">
                    <div class="form-group">
                        <label>제목</label> <input class="form-control" name='title'>
                    </div>
                    <div class="form-group">
                        <label>내용</label>
                        <textarea class="form-control" rows="30" name='content'></textarea>
                    </div>
                    <div class="form-group">
                        <label>작성자</label> 
                        <input class="form-control" name='writer' value="${user.nickname}" readonly="readonly">
                    </div>
                    <button type="submit" class="btn btn-primary">작성완료</button>
                    <button type="reset" class="btn btn-default">다시작성</button>
                    <input type="button" value="메인으로" class="btn btn-success" onclick="javascript:window.location='/'">
                </form>
            </div>
            <!-- end panel-body -->
        </div>
        <!-- end panel-body -->
    </div>
    <!-- end panel -->
</div>
<// %@include file="../include/footer.jsp"%>
