<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@page
import="java.util.List,com.semi.product.model.vo.Books" %> <% List<Books
  >list=(List)session.getAttribute("booklist");
int totalprice=0;
for(Books bk:list){
	totalprice+=bk.getPrice();
}
%>
<%@ include
  file="/views/common/header.jsp"%>
  <style>
    #carttable {
      height:auto;
      margin: 0 auto;
      border: 2px solid black;
      width: 960px;
   
     
    }
    #button-box{
    display:flex;
 	justify-content: space-between;
 	height:150px;
 
  
    }
    #headerfont{
    	font-size:25px;
    	width:960px;
    	margin:0 auto;
    }
    #carttable th{
    border:1px solid black;
    }
   #carttable td{
    border:1px solid black;
    }
    hr{
    	margin-bottom:50px;
    }
    #cartcontainer{
     height:auto;
      padding-bottom:2.5em;
    }
	td{
	width:auto;
	}
 	#price-box{
 	width:960px;
 	margin:0 auto;
 	}
 	#totaltxt{
 	margin-bottom:100px;
 	}
  </style>
  <section>
  <p id="headerfont">Cart</p>
  <hr>
  	<div id="cartcontainer">
    <table id="carttable">
      <%for(Books bk:list){%>
      <tr>
        <th colspan="2">상품명</th>
        <th class="price">가격</th>
        <th class="count">수량</th>
        <th class="del">삭제</th>
      </tr>
      <tr>
        <td><img src="<%=request.getContextPath()%>/image/<%=bk.getBookimg()%>"></td>
        <td><%=bk.getTitle() %></td>
       	<td><%=bk.getPrice()%>원</td>
        <td><input type="number" min="1" max="99"></td>
        <td><input type="checkbox" name="dele" id="dele" /></td>
      </tr>
    
      <%} %>
    </table>
    <hr>
    <div id="price-box">
    <div id="totaltxt">총금액 :<%=totalprice%>원</div>
    <div id="button-box">    
    <button>선택상품삭제하기</button>
    <button onclick="location.href='<%=request.getContextPath()%>/cart/order'">주문하기</button>
   </div>
    </div>
    </div>

  </section>
  <%@ include file="/views/common/footer.jsp"%>
