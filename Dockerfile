FROM gradle:8.4-jdk8
COPY src home/restassuredframework/src
COPY build.gradle home/restassuredframework/build.gradle
COPY settings.gradle home/restassuredframework/settings.gradle
COPY htmlReport.html home/restassuredframework/htmlReport.html
COPY logging.txt home/restassuredframework/logging.txt
WORKDIR home/restassuredframework
ENTRYPOINT gradle cucumber