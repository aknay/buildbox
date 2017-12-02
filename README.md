# Your Build Toolbox for Continuous Integration in Docker

[![Build Status](https://travis-ci.org/holisticon/buildbox.svg?branch=master)](https://travis-ci.org/holisticon/buildbox)

## Requirements

* Unix OS (Linux and macOS) or  Windows with cygwin
* Docker (6 GB+ assigned)


## Usage

![](docs/images/docker-compose.png)

* Build the images: `./docker-build.sh`
* Start the images: `./docker-run.sh`
* Get the admin password for initial setup: `docker logs buildbox_jenkins`
  Look for this entry:
```
Nov 19, 2017 13:45:26 PM jenkins.install.SetupWizard init
INFO:

*************************************************************
*************************************************************
*************************************************************

Jenkins initial setup is required. An admin user has been created and a password generated.
Please use the following password to proceed to installation:

2b7812c6c853418f887a6214a269e7b4

This may also be found at: /var/jenkins_home/secrets/initialAdminPassword

*************************************************************
*************************************************************
*************************************************************

```
* Open your browser at [localhost:8180](http://localhost:8180/login?from=%2F)

All data of the container is started within the folder `data`.

## Advanced

### Update dependency graph

```
docker run --rm -it --name dcv -v $(pwd):/input pmsipilot/docker-compose-viz render -m image docker-compose.yml && mv docker-compose.png docs/images/
```
