#!/bin/sh

cd banco
docker build -t dac/banco .

cd ..
mvn clean package
docker build -t dac/app .

docker run -p 5432:5432 --name banco -d dac/banco
docker run -p 8080:8080 --link banco:banco --name app -d dac/app

