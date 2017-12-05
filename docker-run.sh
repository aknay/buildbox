#!/usr/bin/env bash

source ./docker-env.sh

# Starts all applications. Run 'mvn docker:build' in platform and webapp before this script to create docker images.

# Remove existing containers
docker-compose stop
docker-compose rm -f

## Start new containers (except jenkins)

mkdir -p ${GITLAB_DATA_DIR}/data/git-data/repositories/
chmod -R 2770 ${GITLAB_DATA_DIR}/data/git-data/repositories/

docker-compose up -d

# Show logs. Hit 'Ctrl + c' to exit.
# docker-compose logs -f

while ! echo exit | nc localhost ${JENKINS_SERVER_PORT} ; do sleep 30; done
