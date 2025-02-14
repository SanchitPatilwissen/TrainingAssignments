FROM alpine
 
WORKDIR /root/demo
COPY emp /root/demo
COPY creation.sql /docker-entrypoint-init.d/
 
RUN apk add openjdk8
 
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:$JAVA_HOME/bin
 
RUN javac emp/Main.java
 
#CMD ["java", "Abc"]
ENTRYPOINT java emp.Main