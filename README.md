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

* request : POST/canlander/schedules

{ 
  "user_id" : "1234",
  "name" : "일정",
  "PASSWORD" : "0000"
  }

* reponse :

{ 
 "schedule_id" = "1"
 }

전체 일정 조회
-
* 메소드 : GET
* 요청URL : /canlander/schedules

* reponse : GET/canlander/schedules

  {
  "schedule_id" : "1",
  "user_id" : "1234",
  "name" : "과제",
  "create_date" : "2024-10-31 17:05:33",
  "update_date" : "2024-10-31 17:05:33"      
}
 

선택 일정 조회
-
* 메소드 : GET
* 요청URL : /canlander/schedules/{schedule_id}

* 요청 param 

* reponse :

  {
  "schedule_id" : "1",
  "user_id" : "1234",
  "name" : "과제",
  "create_date" : "2024-10-31 17:05:33",
  "update_date" : "2024-10-31 17:05:33"      

}
선택 일정 수정
-
* 메소드 : PUT
* 요청URL : /canlander/schedules/{schedule_id}

* request : PUT/canlander/schedules/{schedule_id}

{ "schedule_id" : "1",
  "user_id" : "1234",
  "name" : "과제",
  }


* reponse :

{
  "schedule_id" : "1",
  "user_id" : "1234",
  "name" : "과제",
}

선택 일정 삭제
-
* 메소드 : DELETE
* 요청URL : /canlander/schedules/{schedule_id}

* request : DELETE/canlander/schedules/{schedule_id}


SQL 
--

---
1. 테이블 생성 (Create)
---


CREATE TABLE SCHEDULES (

schedule_id int PRIMARY KEY AUTO_INCREMENT

name varchar() 

password varchar()

title varchar()

create_date int 

update_date int


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
4. 선태 일정 조회 (select)
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
 ![사진]) 
