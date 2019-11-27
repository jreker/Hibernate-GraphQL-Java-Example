[![Build Status](https://travis-ci.com/jreker/Hibernate-GraphQL-Java-Example.svg?token=K6k8TUza3z4HxWL6c1Np&branch=master)](https://travis-ci.com/jreker/Hibernate-GraphQL-Java-Example)
# Getting Started
### Description
This project is a boilerplate for using plain Hibernate 5 with GraphQL webservice in spring boot.
It uses a docker container with mariadb as database backend for testing.

Based on:
 - Hibernate 5
 - Spring Boot
 - GraphQL Spring Boot starter

### Database
The database for this project runs inside a docker container. You can have a look on the schema in [initial sql script](docker/init.sql) file.

### Starting Docker container
**Do not run this container in a production enviroment!**

You can start the docker container with the compose file in the folder "docker"
First please set the volume to the init script!

```
- C:\<<yourpath>>\init.sql:/docker-entrypoint-initdb.d/init.sql
```

Because in windows this path have to be a absolute path. In linux is can also be a relative one.

Then run ` docker-compose up` and don't forget to delete the container after you finished: `docker-compose rm`.
### GraphQL - Examples
You can access GraphiQL testconsole from:

```text
http://localhost:8080/graphiql/
```

In the graphql schema-file ([schema.graphqls](src/main/resources/schema.graphqls)) you can see what functions are available via graphQL

####Query

Example (get all categories with links).
![GraphQLQuery](doc/graphiql.gif "GraphiQL")

Example 2 (get all links with category):

```text
query {
  getLinks {
  	Name
    Url 
    Category {
      Name
    }
  }
}
```

#### Mutation 
#####Insert

Example (add a new link).
This query returns the saved link if everything works correctly.

```text
mutation {
  addLink(
    Name:"NewLink"
    Url:"https://myURL.com"
    CategoryId:3
  ) {
    Name,
    Id
  }
}
```

##### Update

Example (update the name of a link based on the id).
This query returns the modified link if everything works correctly.

```
mutation {
  updateLink(
    Id:1
    Name:"New Website Name"
  ) {
    Name
    Id
  }
}
```
