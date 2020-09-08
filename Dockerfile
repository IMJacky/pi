FROM hypriot/rpi-java
ADD /target/pi-0.0.1-SNAPSHOT.jar /opt/pi-0.0.1-SNAPSHOT.jar
EXPOSE 9999
ENTRYPOINT ["java", "-jar", "/opt/pi-0.0.1-SNAPSHOT.jar"]