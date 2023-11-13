FROM ubuntu:20.04
LABEL authors="SARJ"

ENV JAVA_HOME /opt/jdk
ENV PATH $JAVA_HOME/bin:$PATH

RUN apt-get update -y

ADD "https://github.com/CRaC/openjdk-builds/releases/download/17-crac%2B6/openjdk-17-crac+6_linux-x64.tar.gz" $JAVA_HOME/openjdk.tar.gz
RUN tar --extract --file $JAVA_HOME/openjdk.tar.gz --directory "$JAVA_HOME" --strip-components 1; rm $JAVA_HOME/openjdk.tar.gz;

RUN mkdir -p /opt/crac-files

#COPY build/libs/MY-APP.jar /opt/app/MY-APP.jar

COPY target/java-crac-service-0.0.1-SNAPSHOT.jar /opt/app/java-crac-service-0.0.1-SNAPSHOT.jar

#ENTRYPOINT ["top", "-b"]