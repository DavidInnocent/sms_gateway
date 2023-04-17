
# SMS Gateway readme

The following is a guide for you to ru the sms handler gateway.

#### Steps to follow for a successfull running of the application.

To run the application make run the following on your shell

```bash
mvn spring-boot:run
```

To run checkstyle

```bash
mvn checkstyleMain
```
To run tests
```bash
mvn test
```

# Architecture

The application receives an sms from the api, it then sends it to a rabbitmq instance which is tied to a service that processes the sms sending request. Once The sms has been sent to the user it returns a boolean.
Since the service is annotated with transactional if the sending fails then the message is not removed from the queue and can be retried later.

# Disclaimer
Due to short time for implementation the api is not fully tested and may contain some bugs.