#!/bin/sh

docker kill banco
docker stop banco
docker rm banco
docker rmi dac/banco

docker kill app
docker stop app
docker rm app
docker rmi dac/app