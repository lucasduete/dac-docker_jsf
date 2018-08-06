FROM postgres:latest

ENV POSTGRES_DB dac-docker_jsf
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres

COPY create.sql /docker-entrypoint-initdb.d/
