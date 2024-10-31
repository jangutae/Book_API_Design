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
* 메소드 : POST
* 요청URL : /canlander/schedules

* request : schedules

{ 
  "schedule_id" : "1234"
  "name" : "일정"
  "PASSWORD" : "0000"
  }
  
ERD
-
 ![사진](https://github.com/jangutae/Calander_API_Design/blob/main/ERD.png) 
