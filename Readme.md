-- Начало
1) Есть нет докера на машине, нужно установить
2) mvn clean
3) mvn package
4) sudo docker-compose build
5) sudo docker-compose up
-- Вы создали image и конетеры c postgres/  redis / aplication
   не останавливаем приложение
6) необходимо накстроить connect с redis для этого: 
a. Заходим в docker
b. выполняем команду - docker network create spring-redis-network (create connection)
c. docker network connect spring-redis-network redis (присоединяем к ней redis)
d. docker inspect spring-redis-network  - смотрим адрес редиса - у меня это = 172.21.0.1
e. заходим в aplication property и сетим адрес из пунка выше  - spring.redis.host= 172.21.0.1
#  c postgres аналогично
a. docker network create spring-postgres-network
b. docker network connect spring-postgres-network postgres-db
c. docker inspect spring-postgres-network смотрим адрес - у меня 172.19.0.1
d. заходим в aplication property и сетим адрес из пунка выше spring.datasource.url=jdbc:postgresql://172.19.0.1:5432/vv
   
7) стопайте приложение, можно пересобрать  и снова запустить. Проверял в postman.
   http://localhost:8080/rate_like/U
   
есть тест (TestExcangeRateRepository); Можно его прогнать для наката данных. Потом закомментировать обратно.