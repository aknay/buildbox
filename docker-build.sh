#!/usr/bin/env bash

source ./docker-env.sh
docker-compose down --rmi all
docker-compose create
