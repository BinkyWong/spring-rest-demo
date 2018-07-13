FROM centos:7

RUN yum -y install net-tools htop java-1.8.0-openjdk-headless-1.8.0.171-8.b10.el7_5.x86_64 java-1.8.0-openjdk-1.8.0.171-8.b10.el7_5.x86_64 java-1.8.0-openjdk-devel-1.8.0.171-8.b10.el7_5.x86_64

EXPOSE 8080

ADD rest-0.0.1-SNAPSHOT.jar /srv

CMD java -jar /srv/rest-0.0.1-SNAPSHOT.jar
