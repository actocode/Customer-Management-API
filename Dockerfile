FROM openjdk:17
LABEL maintainer = "akanksha"
ADD target/ContactManagementAPI-0.0.1-SNAPSHOT.jar ContactManagementAPI.jar
ENTRYPOINT ["java", "-jar", "ContactManagementAPI.jar"]