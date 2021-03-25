<!--
유저아이디 qwer
유저비밀번호 qwerqwer

유저아이디 qwer1234
유저비밀번호 qwer1234!
-->  

# GP BOOKSTORE

서점 웹사이트에 다양한 기능을 추가하여 구현한 웹 프로젝트 사이트 입니다 로그인 한 사용자만 접근 하도록 구현하였고, 글귀 게시판을 구현하여 사용자들이 댓글을 등록할 수 있고 서로 정보를 공유할 수 있는 사이트 입니다
![GP BOOKSTORE _9](https://user-images.githubusercontent.com/52989474/103339444-c0957d80-4ac4-11eb-9427-fe73ee69b720.png)

## About The Project

[GP BOOKSTORE 사이트 바로가기](http://rclass.iptime.org:9999/20AM_Semi/index.jsp) : 배포용 사이트로 연결  
[AWS EC2서버에 배포](http://54.180.118.180:8080/SemiHeechan/) : 이 프로젝트를 AWS의 EC2서버(Ubuntu 18.04)에 배포만 한 버전    

[DB테이블(ERDCloud)](https://www.erdcloud.com/d/h7QHAaDNFmTKoMrW7) : ERD 클라우드로 이동

## Built With

### Back-end/Server

- JSP/Servlet
- JDK 8
- Oracle DB 11g
- Apache Tomcat 8.5
    
### Front-end

- Javascript
- AJAX
- JQuery
- HTML/CSS

## Contributors

- [나희찬](https://github.com/naheechan)
  - 도서 상세 페이지
  - 도서글귀 게시판
  - 북클럽 게시판
  - 에러페이지
- 유혜지
  - 로그인/회원가입
  - 스터디 그룹 예약 시스템/예매 아임포트API
  - 마이페이지
- 이승환
  - 공지사항
- 임동욱
  - 메인페이지
  - 도서 정보 페이지
  - 장바구니,아임포트 결제API
  - 마이페이지 도서 구매목록

## Explanation

- **도서 상세 페이지**
![책상세1](https://user-images.githubusercontent.com/33804909/112339228-d355d200-8d02-11eb-8a65-661ad3caf205.PNG)

-도서상품의 상세 페이지이다.    
-해당도서의 구매자들의 성별과 연령을 이용하여 '구매자 분포도'를 나타내었다.    
-구매자들에 한해서 댓글을 작성할 수 있고, 동시에 별점을 부여할 수 있다.     
-구매자들의 별점의 평균으로 상품의 평점이 정해지고, '별점 분포'에 분포가 반영된다.<br><br><br><br>

- **글귀 게시판**
![글귀01](https://user-images.githubusercontent.com/33804909/112339278-dc46a380-8d02-11eb-8fcc-60ef6a125119.PNG)

-글귀게시판의 처음 화면이다.       
-이용자들이 직접 배경사진과 글귀를 적어서 서로 공유하는 커뮤니티 게시판이다.     
-'좋아요(하트)'를 기준으로 인기글 1~3위가 정해지고, '좋아요'의 수가 같은 게시글의 경우는 조회수로 순위가 나뉘어진다.<br><br><br>

![글귀02](https://user-images.githubusercontent.com/33804909/112339301-e1a3ee00-8d02-11eb-972b-792398be8142.PNG)

-글귀게시판에서 글귀를 직접 작성하는 모습이다.    
-배경이미지를 가져오고, 글귀를 직접 적을 수 있다.    
-배경이미지의 밝기, 글자크기, 글자색, 글자위치를 설정할 수 있다.<br><br><br>

![글귀03](https://user-images.githubusercontent.com/33804909/112339320-e49ede80-8d02-11eb-9bab-51528a954bec.PNG)

-글귀게시판에서 글귀를 클릭해서 들어갈 수 있는 상세페이지이다.    
-'좋아요(하트)'와 댓글은 Ajax로 구현했다.    
-댓글은 level을 두어서 대댓글이 가능하도록 구현했다.<br><br><br><br>

- **북클럽 게시판**
![북클럽01](https://user-images.githubusercontent.com/33804909/112339335-e8cafc00-8d02-11eb-9e36-c387c7808da2.PNG)

-북클럽 게시판의 처음 화면이다.    
-현재 사이트에 등록된 도서를 이용하여 책모임을 할 수 있는 게시판이다.     
-아래의 '북클럽 참여하기'버튼으로 참여할 수 있다.<br><br><br>

![북클럽03](https://user-images.githubusercontent.com/33804909/112339373-eff20a00-8d02-11eb-99ed-472c3d90bdae.PNG)

-게시글위에 마우스를 올려놓으면 보이는 화면이다.    
-조장(해당 북클럽 만든사람)과 조원(참여자)가 보이게 되고, 성별도 표시된다.<br><br><br>

![북클럽02](https://user-images.githubusercontent.com/33804909/112339359-ecf71980-8d02-11eb-8d63-f3fae74d2d92.PNG)

-북클럽 게시판에서 직접 북클럽을 만드는 화면이다.    
-참여자 최대인원을 설정할 수 있다.    
-주제책 정할때는 현재 사이트에 등록된 책들만 가능하다.    
-주제책 검색을 할때 Ajax로 검색할 수 있는데, 검색단어가 포함된 책들을 자동추천검색어로 추천해준다.<br><br><br><br>

- **에러 페이지**
![에러01](https://user-images.githubusercontent.com/33804909/112339388-f3859100-8d02-11eb-81ac-666084eb1e11.PNG)

-404에러 등 각종에러상황에서 서비스가 끊기지않도록 에러페이지 설정.<br><br><br><br>

