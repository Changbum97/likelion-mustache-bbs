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