<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
    <style>
    section#notice-container{width:600px; margin:0 auto; text-align:center; border-bottom: 100px;}
    section#notice-container h2{margin:10px 0; text-align:center;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>
<section>
  <div id="notice-container">
	<h5 align="center">공지사항 작성</h5>
    <form action="<%=request.getContextPath() %>/notice/NoticeWriterEnd" method="post" enctype="multipart/form-data">
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><input type="text" name="title" id="title" required></td>
        </tr>
          <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" id="writer" 
            value="<%=logginedMember.getMemberId()%>" readonly></td>
        </tr>
           <tr>
            <th>첨부파일</th>
            <td><input type="file" name="upfile"></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea cols="50" rows="5" name="content"></textarea></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="등록하기" onclick="return validate();" >
           </th>
        </tr>
    </table>
    </form>
    </div>
	<!-- <script>
		function validate(){
			const content=$("[name=content]").val();
			if(content.trim().length==0){
				alert("내용을 입력해주세요!");
				$("[name=content]").focus();
				return false;
			}
		}
	
	</script> -->

</section>
<%@ include file="/views/common/footer.jsp" %>