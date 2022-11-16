# Token Service

## Description
This service will be used to fetch an unused range from Postgres database. Numbers in this range will be used to generate encoded short URLs.


## Process to run the database
1. Take a pull of the code and navigate inside the database folder.
2. Make sure that docker is installed on the system.
3. Run the command `docker-compose up`. This will run the docker container containing the postgres database along with pre-existing tables.
4. Run the command `docker ps` to get the container for this postgres database.
5. Run the command `docker exec -it <> /bin/bash` to enter the postgres server where <> will be replaced by the container ID in the above step.
6. Run the command `psql -U postgres` to enter the postgres cli once inside the server.
7. Type `\d` to display the relations.
8. Run `select * from range_central;` to see the available ranges.
9. To exit the postgres cli, use `\q`.
10. To exit the postgres server, use `exit`.
11. To kill the container, use `docker-compose down`.



## Process to run the service