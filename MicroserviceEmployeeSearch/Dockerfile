Dockerfile-EmployeeSearch. 
================================
FROM alpine-jdk:base
MAINTAINER javaonfly
RUN apk --no-cache add netcat-openbsd
COPY files/MicroserviceEmployeeSearch.jar /opt/lib/
COPY EmployeeSearch-entrypoint.sh /opt/bin/EmployeeSearch-entrypoint.sh
RUN chmod 755 /opt/bin/EmployeeSearch-entrypoint.sh
EXPOSE 9080
Dockerfile-EmployeeDashboard
====================================
FROM alpine-jdk:base
MAINTAINER javaonfly
RUN apk --no-cache add netcat-openbsd
COPY files/MicroserviceEmployeeDashboard.jar /opt/lib/
COPY EmployeeDashBoard-entrypoint.sh /opt/bin/EmployeeDashBoard-entrypoint.sh
RUN chmod 755 /opt/bin/EmployeeDashBoard-entrypoint.sh
EXPOSE 9081
Dockerfile-ZuulServer
=========================================
FROM alpine-jdk:base
MAINTAINER javaonfly
COPY files/MicroserviceEmployeeAPIGateway.jar /opt/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/MicroserviceEmployeeAPIGateway.jar"]
EXPOSE 9084
