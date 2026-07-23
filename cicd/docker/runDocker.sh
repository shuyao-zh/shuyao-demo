#!/bin/sh
  
# To enable NewRelic Agent for the application the environment varialbles mentioned in the docker file should be set
# To run locally using Docker Desktop. Ensure that config server are also deployed otherwise you will not be able to run
docker run --name hk-aks-demo-java-maven -p 8080:8080 -i -t --rm artifactory.ap.manulife.com/docker/com/manulife/hk/hk-aks-demo-java-maven:1.0.3-SNAPSHOT -e "--spring.profiles.active=dev"

# To run in Kubernetes and Cloud Config Server
# docker run --name mua-aks-zeromu-rsf -p 8080:8080 -i -t --rm mua-aks-zeromu-rsf:1.0-SNAPSHOT -e "--spring.profiles.active=dev" -e "--spring.cloud.config.uri=http://cfgserver:8888"

# To run in Kubernetes, Cloud Config Server and Eureka Registry
# docker run --name mua-aks-zeromu-rsf -p 8080:8080 -i -t --rm mua-aks-zeromu-rsf:1.0-SNAPSHOT -e "--spring.profiles.active=dev" -e "--spring.cloud.config.uri=http://cfgserver:8888"

# Run with NewRelic
# Ensure your license key is set in newrelic.yml file.

# Export NRA_VERSION=5.3.0
# docker run --name mua-aks-zeromu-rsf -p 8080:8080 -i -t --rm mua-aks-zeromu-rsf:1.0-SNAPSHOT -e "--spring.profiles.active=dev" -e "--spring.cloud.config.uri=http://cfgserver:8888" -e "--newrelic.environment=MLF-PREPROD"
