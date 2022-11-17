# 멋쟁이 사자처럼 Spring Boot - Mustache를 사용해 게시판 만들기 프로젝트 (2022/11/07 ~ )

## Day 1 (11/07 월)
- Mustache 라이브러리, 플러그인 설치
- Mustache 기본 예제
  - Hello World 출력
  - Model과 Mustache의 {{}} 문법을 사용해 Controller에서 View로 값 전송
- Bootstrap 5 적용
- Header, Footer 추가 후 layout 적용
- Mustache Form 입력을 Controller에서 받기
- JPA 적용
  - JPA 라이브러리 설치
  - JPA Entity 생성
  - DB 접속 정보 입력
- Repository
  - JpaRepository를 상속받아 사용
  - Insert 실습

## Day 2 (11/08 화)
- header, footer에 Bootstrap 적용 => 모든 페이지에 Bootstrap 적용
- FindById 기능 추가
  - PathVariable로 id 입력 받음
- 에러 페이지 생성
- FindAll 기능 추가
  - 리스트 페이지에 테이블 적용
- 페이지 간 이동 기능 추가

## Day 3 (11/09 수)
- update 기능 추가
- delete 기능 추가
- form put, delete request 보내는 법
  1. application.yml에 코드 추가
     - spring.mvc.hiddenmethod.filter.enabled = true
  2. form에 input 태그 추가
    - \<input type="hidden" name="_method" value="put" />
- 글 삭제시 알림 메세지 뜨게 설정
  - java script 사용

## Day 4 (11/10 목)
- 연관관계 매핑(@OneToMany, @ManyToOne)을 사용해 댓글 기능 추가

## Day 5 (11/11 금)
- 전국 병의원 정보 DB 데이터 불러오기
- 전국 병의원 정보 리스트 페이징 구현
- 전국 병의원 정보 show 구현
- Bootstrap DropDown 기능 적용

## Day 6 (11/14 월)
- Jpa Repository 기능 사용 실습
  - contains
  - in
  - like
  - and
  - between
  - less than, greater than, less than equal, greater than equal
  - order by

## Day 7 (11/15 화)
- Hospital RestController 생성 => API 설계
  - findById 구현
- Hospital Service 생성
  - Hospital RestController의 findById, DTO로 변환 하는 부분을 Hospital Service로 옮김
  - businessStatusCode을 Code 번호에 맞는 이름으로 변경
    - ex) 13 => 영업중
- HospitalResponse(DTO)에 @Builder 적용
- Controller Test 진행
  - @WebMvcTest를 사용해 HospitalRestController Test 진행
  - Mock을 사용해 DB와 상관 없이 Test 진행

## Day 8 (11/16 수)
- Add 기능 테스트 코드 작성
- Add 기능 구현

## Day 9 (11/17 목)
- User Exercise
  - Rest API를 적용한 user 추가, 조회 기능 작성
  - 레이어드 아키텍쳐를 적용해 Controller, Service, Repository 구조 적용
  - @WebMvcTest, Mock을 사용해 UserRestController의 기능 테스트
  - UserService의 addUser 메소드 테스트
    - Service Test는 Spring 사용 X
    - Spring을 사용하지 않으면 속도를 더 빠르게 할 수 있지만 의존 주입을 직접 해줘야 함