#!/usr/bin/env bash

source ./docker-env.sh
mkdir -p ${JENKINS_DATA_DIR}
mkdir -p ${GITLAB_DATA_DIR}
mkdir -p ${NEXUS_DATA_DIR}
mkdir -p ${SONAR_DATA_DIR}
docker-compose down --rmi all
docker-compose create
