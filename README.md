# banttang
개발을 담당한 거래(deal) 관련 코드만 있는 상태입니다. 코드는 java/com/hproject/banttang/deal 에서 확인 할 수 있습니다.
**(참고 - 현재 진행중인 프로젝트에 일부 코드만 공개 하였습니다.)**

## Run application on local
로컬 테스트 환경에서 실행하기 위한 사전 설정 입니다.

mariadb docker image 다운로드
```bash
docker pull mariadb
```
Init Database on local
```bash
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 --name local_mariadb_test mariadb
```
database 접속
```bash
docker exec -it local_mariadb_test bash
```
```bash
mysql -uroot -p1234
```
create test database
```bash
create database test_db;
```

위에 나와있는 설정을 완료 하면 프로젝트를 정상 실행 할 수 있으며,
http://localhost:8080/swagger-ui/index.html#/ 링크를 통해 테스트를 진행 할수 있습니다.

## 사용 기술
* java11, Spring boot, Spring Security, MySQL, JPA, QueryDSL, Junit5, EC2, RDS, S3

## 패키지 구조
```bash
.
├── main
│   ├── java
│   │   ├── Object1 (Domain 개념) - Domain의 개념으로 첫 Package 분기
│   │   │   ├── config - 해당 Domain과 관련된 설정 객체
│   │   │   │   └── advice -Exception Handling 객체
│   │   │   ├── controller - API 관련 객체
│   │   │   │   ├── Request - API 요청 객체
│   │   │   │   ├── Response - API 응답 객체
│   │   │   │   └── Object1Controller.java
│   │   │   ├── entity - Domain 개념 객체
│   │   │   │   ├── value - Domain 개념에 활용하는 값 객체들(Enum, Domain 하위의 VO 객체들)
│   │   │   │   └── Object1.java
│   │   │   ├── infra - Server 외부와 연관되는 부분
│   │   │   │   ├── Repository - JPA, QueryDSL 등의 DB와 연결하는 객체들 (QueryDSL을 사용하는 Custom과 Impl은 Custom 패키지로 추가 분기)
│   │   │   │   │   ├── Custom
│   │   │   │   │   │   ├── Object1RepsitoryImpl.java
│   │   │   │   │   │   └── Object1RepsitoryCustom.java
│   │   │   │   │   └── Object1Repsitory.java
│   │   │   │   └── connector - Retrofit2 외부 API를 활용할 Package
│   │   │   └── service - 비즈니스 로직을 수행하는 객체 (Repository 등 infra 객체들을 불러와서 비즈니스 로직을 수행하고 결과를 Controller에게 전달해주는 역할)
│   │   │        └── Object1Service.java
│   │   └── Application.java
│   └── resources
│       └── application.yml (.properties)
└── test
    └── java
        ├── controller
        │   └── Object1ControllerTest.java
        ├── service
        │   └── Object1ServiceTest.java
        └── ApplicationTest
```


## ERD
<img src="https://user-images.githubusercontent.com/120109736/226907480-4b241f8f-4e1c-40f2-8c0c-9900caae5adb.png">

## 기능 상세

## 로그인/ 회원가입

- 소셜(카카오 / 구글) 을 통한 로그인이 가능합니다.

<img src="https://user-images.githubusercontent.com/120109736/221446470-407dbe17-fb2b-4825-9738-d804e880cfe5.jpeg" width="200px">





## 홈

### 거래글

### 거래글 목록

- 내 현재 위치별 가까운 순서대로 정렬되어 나타나게 됩니다

<img src = https://user-images.githubusercontent.com/120109736/220337125-ef460486-4692-4fa3-a423-b7c76d87269f.png width = 200px>

- 카테고리 별로 거래글을 볼 수 있습니다

<img src="https://user-images.githubusercontent.com/120109736/221446471-040bd9fb-b1ce-4c19-af42-876e52454724.jpeg" width="200px">

### 거래글 상세

- `참여하기` 를 이용해 거래 참여가 가능합니다
    - 거래에 참여하는 유저 명 수, 인원별 가격, 거래 장소를 보여줍니다
    - 거래에 참여한 다른유저들에게 `앱 푸시 알림` 을 보냅니다

<img src = https://user-images.githubusercontent.com/120109736/220337106-59b11312-276d-43bf-9197-8d78f9b34575.png width = 200>

<img src = https://user-images.githubusercontent.com/120109736/221447654-b01b001a-cacd-4d0f-9d85-f987f687603a.png width = "200px">

- 글 작성자 는 `모집 종료` 를 할 수 있습니다
    - 종료시 다른 유저들에게 `앱 푸시 알림`이 갑니다.

<img src= https://user-images.githubusercontent.com/120109736/221446481-7f929803-b783-4096-a61b-e5636ee13b44.jpeg width="200px">



- 댓글 등록을 할 수 있습니다

  <img src = https://user-images.githubusercontent.com/120109736/221447653-1e353895-e752-4062-bfb8-269e5a094b3a.png width = "200px">

## 거래글 등록

- 사진 첨부가 가능합니다 (최대 5장)

- 거래글의 카테고리를 선택할 수 있습니다.

- 지도를 통해 거래장소 선택 가능



<img src=https://user-images.githubusercontent.com/120109736/221446474-bdc91195-da59-43fe-85c3-5bd3ac5f2b91.jpeg width="200px">

# My 거래

- 내가 올린 글 확인
- 내가 참여하고 있는 거래 확인

<img src=https://user-images.githubusercontent.com/120109736/221446480-ebe90976-03ea-4c7e-98a4-2683e0d53305.jpeg width="200px">

# 마이페이지

- 1:1 문의
- 공지사항

<img src=https://user-images.githubusercontent.com/120109736/221446477-84f5a05b-b7d5-4ef0-8b49-e31c3d229a8f.jpeg width="200px">