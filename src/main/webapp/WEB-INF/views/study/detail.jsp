<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section class="content">
    <div class="box">
        <div class="box-header">
            <h3 class="box-title">상세보기</h3>
        </div>
        <div class="box-body">
            <div class="form-group">
                <label>제목</label> <input type="text" name="title"
                    class="form-control" value="${vo.title}" readonly="readonly" />
            </div>
            <div class="form-group">
                <label>내용</label>
                <textarea name="content" rows="30" readonly="readonly"
                    class="form-control">${vo.content}</textarea>
            </div>
            <div class="form-group">
                <label>작성자</label> <input type="text" class="form-control"
                    value="${vo.nickname}" readonly="readonly" />
            </div>
        </div>
        <div class="box-footer">
            <button class="btn btn-success" id="mainbtn">메인</button>
            <c:if test="${user.email == vo.email}">
                <button class="btn btn-warning" id="updatebtn">수정</button>
                <button class="btn btn-danger" id="deletebtn">삭제</button>
            </c:if>
            <button class="btn btn-primary" id="listbtn">목록</button>
        </div>
    </div>
</section>
<// %@ include file="../include/footer.jsp"%>
<script>
    //메인 버튼을 눌렀을 때 처리
    document.getElementById("mainbtn").addEventListener("click", function() {
        location.href = "/";
    });
    //목록 버튼을 눌렀을 때 처리
    document.getElementById("listbtn").addEventListener("click", function() {
        location.href = "/study/list";
    });
    <c:if test = "${user.email == vo.email}">
    //삭제 버튼을 눌렀을 때 처리
    document.getElementById("deletebtn").addEventListener("click", function() {
        $("#dialog-confirm").dialog({
            resizable : false,
            height : "auto",
            width : 400,
            modal : true,
            buttons : {
                "삭제" : function() {
                    $(this).dialog("close");
                    location.href = "/study/delete/${vo.bno}";
                },
                "취소" : function() {
                    $(this).dialog("close");
                }
            }
        });
    });


    //수정 버튼을 눌렀을 때 처리
    document.getElementById("updatebtn").addEventListener("click", function() {
        location.href = "/study/update/${vo.bno}";
    });
    </c:if>
</script>


<c:if test="${user.email == vo.email}">
    <link rel="stylesheet"
        href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <div id="dialog-confirm" title="삭제?" style="display: none;">
        <p>정말로 삭제하시겠습니까?</p>
    </div>
</c:if>

