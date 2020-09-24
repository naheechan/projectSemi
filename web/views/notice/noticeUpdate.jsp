<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%
 String noticeTitle=request.getParameter("noticeTitle");
 String noticeContnent=request.getParameter("noticeContent");
 String filepath=request.getParameter("filepath");
%>
<section>
  <div id="notice-container">
	<h2>공지사항 수정</h2>
    <form action="/"method="post" enctype="multipart/form-data">
      <input type="hidden" name="notice value="<%=request.getParameter("notice") %>>"
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><input type="text" name="title" id="title" required></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea cols="50" rows="5" name="content"></textarea></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td><input type="file" name="upfile"></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="수정하기" onclick="#">
                <input type="submit" value="취소하기" onclick="return" >
            </th>
        </tr>
    </table>
    </form>
    </div>
    <style>
    
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0; text-align:center;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>
</section>