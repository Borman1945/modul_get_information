-- Начало
1) Есть нет докера на машине, нужно установить
2) mvn clean
3) mvn package
4) sudo docker-compose build
5) sudo docker-compose up
-- Вы создали image и конетеры c postgres/  redis / aplication
   не останавливаем приложение
6) необходимо накстроить connect с redis для этого: 
        1. Заходим в docker
        2. выполняем команду - docker network create spring-redis-network (create connection)
        3. docker network connect spring-redis-network redis (присоединяем к ней redis)
        4. docker inspect spring-redis-network  - смотрим адрес редиса - у меня это = 172.21.0.1
        5. заходим в aplication property и сетим адрес из пунка выше  - spring.redis.host= 172.21.0.1
   
7) стопайте приложение, можно пересобрать  и снова запустить. Проверял в postman.
   http://localhost:8080/rate_like/U
   
есть тест (TestExcangeRateRepository); Можно его прогнать для наката данных. Потом закомментировать обратно.