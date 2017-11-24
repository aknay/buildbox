#!/bin/bash
# script to start reconfiguration of already running gitlab container from inside a container.
# call this when changing something in gitlab.rb
# should be placed to inside location /etc/gitlab/gitlab-reconfigure.sh
# make sure to run that only if gitlab alredy is completely online
set -e

if [ -f /.dockerenv ]; then
  # we are inside a container environment, hopefully the right one
  gitlab-ctl stop unicorn
  gitlab-ctl stop sidekiq
  gitlab-ctl reconfigure
  gitlab-ctl restart
else
  # we are outside a container, hopefully on the right docker host
  docker exec -it buildbox_gitlab /etc/gitlab/gitlab-reconfigure.sh
fi
