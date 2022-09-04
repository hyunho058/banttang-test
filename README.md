# banttang

로컬 테스트 환경에서 실행하기 위한 사전 설정 입니다.

## Run application on local

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

(참고 - 현재 진행중인 프로젝트에 일부 코드만 공개 하였습니다.)