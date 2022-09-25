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

