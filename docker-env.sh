#!/usr/bin/env bash

export JENKINS_VERSION=latest
export GITLAB_VERSION=10.1.4-ce.0
export NEXUS_VERSION=3.6.0
export SONAR_VERSION=5.6.7


export JENKINS_SERVER_PORT=8180
export JENKINS_ADMIN_PASS=${JENKINS_ADMIN_PASS:-admin}
export JENKINS_DATA_DIR=${JENKINS_DATA_DIR:-./data/jenkins/master}
export GITLAB_DATA_DIR=${GITLAB_DATA_DIR:-./data/gitlab}
export NEXUS_DATA_DIR=${NEXUS_DATA_DIR:-./data/nexus}
export SONAR_DATA_DIR=${SONAR_DATA_DIR:-./data/sonar}
