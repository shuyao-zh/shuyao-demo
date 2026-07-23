#!/bin/sh

kubectl delete deploy/dep-hk-aks-demo-java-maven-v3

cd ../../

mvn clean install -P local

cd ./cicd/k8s/

docker push artifactory.ap.manulife.com/docker/com/manulife/hk/hk-aks-demo-java-maven:3.0.1-SNAPSHOT

kubectl apply -f deployment.yaml
