FROM centos:latest

RUN yum install java-1.8.0-openjdk.x86_64 -y

ADD tivit-mon-db*.jar /root/tivit-mon-db.jar

EXPOSE 9020

ENTRYPOINT [ "bash", "-c", "java -jar /root/tivit-mon-db.jar" ]