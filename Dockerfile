# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8582
ENTRYPOINT ["java","-jar","/app.jar"]

#build command
#docker build --build-arg JAR_FILE=build/libs/*.jar -t storelocator .



#run command
#docker run -p 8582:8582 storelocator

#gradle run
#./gradlew build && java -jar build/libs/storeLocator-0.0.1-SNAPSHOT.jar