# Schedule_manegemnet

API 명세서
-

Schedules
-
|기능|Method|URL|Request|Response|상태코드|
|----|---|---|---|---|---|
|일정 생성|POST|/calander/schedules|요청 body|등록 정보|200: 정상 등록, 400:비정상값|
|전체일정조회|GET|/calander/schedules|X|다건 응답 정보|200: 정상 조회|
|선택일정조회|GET|/calander/schedules/{schedule_id}|X|단건 응답 정보|200: 정상조회, 404:일정이 사라짐|
|선택일정수정|PUT|/calander/schedules/{schedule_id}|요청 body|수정 정보|200:정상등록, 400:비정상 값, 404: 일정이 사라짐|
|선택일정삭제|DELETE|/calander/schedules/{schedule_id}|X||삭제 정보|204: 정상 등록, 404:일정이 사라짐|

일정 생성 
-
* 메소드 : POST
* 요청URL : /canlander/schedules


* 예제


* request : POST/canlander/schedules


{ 
  "name" : "홍길동",
  "password" : "0000"
  "content" : "lv.0 과제 마무리"
 
  }

* reponse : HTTP/1.1 200 OK

{ 
 "schedule_id" = "1"
 }

 * 본문

 
 * request 


|이름|타입|설명|필수|
|---|---|---|---|
|name|String|작성자명|Y|
|password|String|비밀번호|Y|
|content|String|일정 내용|Y|


 * reponse 


|이름|타입|설명|필수|
|---|---|---|---|
|schedule|String|schedule의 id|Y|


전체 일정 조회
-
* 메소드 : GET
* 요청URL : /canlander/schedules


* 예제

* request : X


* reponse : HTTP/1.1 200 OK

  {
  "schedule_id" : "1",
  "name" : "홍길동",
  "password" : "0000"
  "content : "lv.0 과제 마무리" 
  "create_date" : "2024-10-31 17:05:33",
  "update_date" : "2024-10-31 17:05:33"      
}
 
* 본문


* request : X 


* reponse 


  
|이름|타입|설명|필수|
|---|---|---|---|
|schedule_id|INT|schedule 의 id|Y|
|name|String|작성자명|Y|
|password|String|비밀번호|Y|
|content|String|일정 내용|Y|
|create_date|INT|작성일자|Y|
|update_date|INT|수정일자|Y|



선택 일정 조회
-
* 메소드 : GET
* 요청URL : /canlander/schedules/{schedule_id}


* 예제 :

  
* request : GET/canlander/schedules/{schedule_id}


* reponse : HTTP/1.1 200 OK

  {
  "schedule_id" : "1",
  "name" : "홍길동",
  "password" : "0000"
  "content : "lv.0 과제 마무리" 
  "create_date" : "2024-10-31 17:05:33",
  "update_date" : "2024-10-31 17:05:33"  

}

* 본문

* request 


|이름|타입|설명|필수|
|---|---|---|---|
|schedule|String|schedule의 id|Y|


* reponse
 

|이름|타입|설명|필수|
|---|---|---|---|
|schedule_id|INT|schedule 의 id|Y|
|name|String|작성자명|Y|
|password|String|비밀번호|Y|
|content|String|일정 내용|Y|
|create_date|INT|작성일자|Y|
|update_date|INT|수정일자|Y|




선택 일정 수정
-
* 메소드 : PUT
* 요청URL : /canlander/schedules/{schedule_id}

* 예제 :

* request : PUT/canlander/schedules/{schedule_id}

{ 
  "schedule_id" : "1",
  "name" : "홍두깨",
  "password" : "0000"
  "content : "lv.1 과제 마무리" 
  }


* reponse : HTTP/1.1 200 OK

{
  "schedule_id" : "1",
}


* 본문

* reqeust

|이름|타입|설명|필수|
|---|---|---|---|
|schedule_id|INT|schedule 의 id|Y|
|name|String|작성자명|Y|
|password|String|비밀번호|Y|
|content|String|일정 내용|Y|

  
* reponse

|이름|타입|설명|필수|
|---|---|---|---|
|schedule|String|schedule의 id|Y|


선택 일정 삭제
-
* 메소드 : DELETE
* 요청URL : /canlander/schedules/{schedule_id}

* 예제 : 

* request : DELETE/canlander/schedules/{schedule_id}


* reponse : HTTP/1.1 200 OK


  {
  "schedule_id" : "1",
}


* 본문
  

* request


|이름|타입|설명|필수|
|---|---|---|---|
|schedule|String|schedule의 id|Y|


* reponse
 

|이름|타입|설명|필수|
|---|---|---|---|
|schedule|String|schedule의 id|Y|

SQL 
--

---
1. 테이블 생성 (Create)
---


CREATE TABLE SCHEDULES (

schedule_id int PRIMARY KEY AUTO_INCREMENT,

name varchar(50), 

password varchar(16),

content varchar(250),

create_date datetime, 

update_date datetime


)

---
2. 유저 생성 및 일정 생성 (Insert)
----

INSERT INTO schedules (schedules_id, name, password, title, create_date, update_date)

valuse (1234, "홍길동", "qwer123", "대청소", 2024_10_31 17:05:34)

---
3. 전체 일정 조회 (Select)
---

SELECT * 

FROM schedules

---
4. 선택 일정 조회 (select)
---

SELET *

FROM schedules

WHERE schedules_id = 1;

---
5. 선택 일정 수정  (Update)
---

UPDATE schedules SET name = "홍두깨" , update_date = "2024_10_31 17:40:34" 

WHERE schedule_id =1;

---
6. 선택 일정 삭제 (DELETE)
---
DELETE FROM schedules 

WHERE schedules_id = 1;

ERD
-
 ![사진](https://github.com/jangutae/Calander_API_Design/blob/main/%EC%B2%A8%EB%B6%80%ED%8C%8C%EC%9D%BC4.png) 
