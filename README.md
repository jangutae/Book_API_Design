# Daily_API_Design
<h3>API 명세서를 작성해보겠습니다.</h3>

<h1>Daily_API</h1>

<H5>- 일정 생성</H5>
<H5>- 전체 일정 조회</H5>
<H5>- 선택 일정 조회</H5>
<H5>- 선택한 일정 수정</H5>
<H5>- 선택한 일정 삭제</H5>

API 명세

| 구분 | API명 | 설명 | 
|-----|---|---|
|정보 생성|일정 생성|일정을 생성합니다.|
|정보 조회|전체 일정 조회|전체 일정을 조회합니다.|
|정보 조회|선택 일정 조회|선택한 일정을 조회합니다.|
|정보 수정|선택한 일정 수정|선택한 일정을 수정합니다.|
|정보 삭제|선택한 일정 삭제|선택한 일정을 삭제합니다.|

정보 생성 

일정을 생성합니다.

Method : POST


POST /calendar
{
  "name" : "schedule"
  "password : "0000"
} 



전체 일정을 조회합니다.

Method : GET

GET /canlender/schedule



선택한 일정을 조회합니다.

Method : GET

GET /canlender/{schedule}



선택한 일정을 수정합니다.

Method : PUT

PUT /canlender/{schedule}
{
  "name" : "events"
  "password" : "1111"
}



선택한 일정을 삭제합니다.

Method : DELETE

DELETE /canlender/{schedule}

