#! /bin/bash

function docker-compose (){
docker run --rm \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v "$PWD:$PWD" \
    -w="$PWD" \
    docker/compose:1.24.0 $1 $2 $3 $4
}

services=("zookeeper" "kafka" "identity" "vehicle" "trip" "payment" "messaging" "simulation")

for container in ${services[*]}
do 
if docker ps | grep -q $container; then
echo "$container is already up";
else
echo "Starting $container"
docker-compose up --no-deps -d $container &>/dev/null &
fi
done

sleep 5
docker-compose ps
