#==================================
#start microservice script
#==================================
#!/bin/sh
echo "time: $TIME_WAITING"
echo "microservice up"
java -jar /opt/lib/kpersonaservice-0.0.1.jar
