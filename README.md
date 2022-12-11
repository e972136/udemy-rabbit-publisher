# udemy-rabbit-publisher

Curso Origen
https://www.udemy.com/course/rabbitmq-messaging-with-java-spring-boot-and-spring-mvc/?src=sac&kw=rabbitmq+java

implementado con rabbit en Docker

#https://spring.io/guides/gs/messaging-rabbitmq/
#https://www.rabbitmq.com/getstarted.html
#https://www.rabbitmq.com/tutorials/tutorial-five-spring-amqp.html

  rabbitmq-container:
    image: rabbitmq:3.9-management
    container_name: rabbitmq-container
    ports:
      - '15672:15672'
      - '5672:5672'
