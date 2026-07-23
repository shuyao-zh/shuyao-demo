FROM artifactory.ap.manulife.com/docker/rsf/rsf-java-newrelic:1.0.1

# Following Environment variable should be set to enable New Relic for the application
#Also following environment variable should be passed by the application team in the values.yaml file for newrelic-agent to work
ENV NEW_RELIC_APP_NAME=hk-aks-demo-java-maven-kaiski-dev
ENV NEW_RELIC_LICENSE_KEY=68d93d382301e2155f7f67097ad65dcd6db76cde
ENV NEW_RELIC_DISTRIBUTED_TRACING_ENABLED=true

ARG JAR_FILE

COPY target/${JAR_FILE} app.jar

ENTRYPOINT ["java","-javaagent:./newrelic.jar","-jar","app.jar"]
