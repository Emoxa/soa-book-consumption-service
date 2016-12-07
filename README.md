##Build docker image via dockerfile
From the directory containing the dockerfile
>docker build -t emoxa/soa-book-consumption-service .

##Build docker image via maven
From the directory ConsumptionRestService 
>mvn clean package docker:build

##Run image
Once you launched one of the two commands before
>docker run -p 8080:8080 emoxa/soa-book-consumption-service

