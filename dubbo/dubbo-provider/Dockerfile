FROM fabric8/java-centos-openjdk8-jre:1.6.1
ADD ./target/dubbo-provider-1.0.0.jar /root/.
CMD ["java" , "-jar" , "/root/dubbo-provider-1.0.0.jar > /root/info.log"]