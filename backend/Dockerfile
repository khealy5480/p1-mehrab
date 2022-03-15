FROM gradle AS build
WORKDIR /app
COPY build.gradle ./
RUN gradle clean build --no-daemon > /dev/null 2>&1 || true
COPY ./ /app
RUN gradle clean build --no-daemon --stacktrace

FROM openjdk
COPY --from=build /app/build/libs/*-all.jar /app.jar
EXPOSE 8080
ENTRYPOINT exec java -jar app.jar
