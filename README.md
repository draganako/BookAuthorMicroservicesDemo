# Book Author Microservices Demo
Demo publisher, book and author persistence and notification microservices for notifying about new books
(made with an online tutorial) <br />

Each microservice has a persistence layer implemented with H2 database and initialized by Flyway. Microservices are deployed on a docker container and communicating via Kafka topics.<br />

Microservice *book-publisher* persists books and authors in its database and sends books to *books.published* Kafka topic, every 20 seconds.<br />
*book-persistence* and *author-persistence* microservices consume books and authors from *books.published* topic, respectively and store them in their local databases (H2). They also send notifications to *notification.created* topic about the data they persisted.<br />
Microservice *notifications*  consumes notifications from *notification.created* topic.<br />

**How to use**

Make sure to open Docker desktop

Run the following in terminal:<br />
docker-compose up --build<br />

Since this demo project runs locally, the microservice data can be accessed by sending GET requests to these API endpoints:<br />

http://localhost:8181/books (from *book-persistence*)<br />
http://localhost:8282/authors (from *author-persistence*)<br />
http://localhost:8383/notifications (from *notifications*)
