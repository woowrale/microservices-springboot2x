#==================================
#start microservice script
#==================================
#!/bin/sh
echo "time: $TIME_WAITING"
echo "microservice up"
java -jar /opt/lib/keurekaservice-0.0.1.jar
