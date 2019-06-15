[![Build Status](https://travis-ci.org/bartoszsokolik/spring-data-audit.svg?branch=master)](https://travis-ci.org/bartoszsokolik/spring-data-audit)

## About
Simple REST application with Hibernate Evners, Postgresql and Docker.

## Usage
To start application build application with `./mvnw clean install` and then run `docker-compose up`

To create a movie, acotr and catoegory curl
```
curl -v -X POST -H "Content-type: application/json" http://localhost:8080/api/movies -d '{"title" : "Star Wars"}'
```

```
curl -v -X POST http://localhost:8080/api/actors -H "Content-type: application/json" -d '{"firstName" : "Mark", "lastName" : "Hamil"}'
```

```
curl -v -X POST -H "Content-type: application/json"  http://localhost:8080/categories -d '{"name" : "science-fiction"}'
```

To assign actor to movie curl
```
curl -v -X PUT http://localhost:8080/api/movies/1/actors -H "Content-type: application/json" -d '{"actors" : [here put actor id]}'
```

To assign category to movie curl
```
curl -v -X PUT -H "Content-type: application/json" http://localhost:8080/api/movies/category -d '{"movieId" : "movie id", "categoryName" : "category name"}'
```

To get info about all movies, actors, categories curl
```
curl -v http://localhost:8080/api/movies
```

```
curl -v http://localhost:8080/api/actors
```

```
curl -v http://localhost:8080/api/categories
```

