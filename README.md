# springboot-docker

### mysql start
```shell
$ mkdir -p ~/.docker-data/mysql

$ docker run --cap-add=sys_nice -d --restart=always -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password \
-v ~/.docker-data/mysql:/var/lib/mysql \
--name mysql-ask mysql:8.0.34 \
--character-set-server=utf8mb4 \
--collation-server=utf8mb4_unicode_ci
```

### create database
```shell
$ docker exec -it mysql-ask bash
# mysql -uroot -ppassword
mysql> create database if not exists order_service;
```

### docker build
```shell
$ docker build --no-cache -t seungkyua/springboot-docker -f docker/Dockerfile .
```

### docker run
```shell
$ docker run -d --name springboot --rm -p 19090:19090 --link mysql-ask:localhost seungkyua/springboot-docker
```

### check
```shell
$ curl http://127.0.0.1:19090/orders/1
```