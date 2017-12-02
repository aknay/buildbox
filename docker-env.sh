#!/usr/bin/env bash

export JENKINS_VERSION=lts
export GITLAB_VERSION=10.2.2
export NEXUS_VERSION=3.6.0
export SONAR_VERSION=5.6.7

export JENKINS_SERVER_PORT=8180
export JENKINS_DATA_DIR=${JENKINS_DATA_DIR:-./data/jenkins/master}

export GITLAB_HTTP_PORT=${GITLAB_HTTP_PORT:-8280}
export GITLAB_SSH_PORT=${GITLAB_SSH_PORT:-8222}
export GITLAB_DB_DIR=${GITLAB_DATA_DIR:-./data/gitlab_db}
export GITLAB_REDIS_DIR=${GITLAB_DATA_DIR:-./data/gitlab_redis}
export GITLAB_DATA_DIR=${GITLAB_DATA_DIR:-./data/gitlab}

export NEXUS_DATA_DIR=${NEXUS_DATA_DIR:-./data/nexus}

export SONAR_DATA_DIR=${SONAR_DATA_DIR:-./data/sonar}
