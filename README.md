##Build docker image via dockerfile
>docker build -t emoxa/soa-book-consumption-service .

##Build docker image via maven
>mvn clean package docker:build

##Run image
>docker run -p 8080:8080 emoxa/soa-book-consumption-service

