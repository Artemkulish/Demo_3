#! /bin/bash

# Way to use docker-compose in Google Container-Optimized OS 
function docker-compose (){
docker run --rm \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v "$PWD:$PWD" \
    -w="$PWD" \
    docker/compose:1.24.0 $1 $2 $3 $4
}

# Array of services defined in docker-compose
services=("zookeeper" "kafka" "identity" "vehicle" "trip" "payment" "messaging" "simulation")

# Loop through the array
for container in ${services[*]}
do 
    # Downloading a new image
    docker pull gitlab.svagworks.me:5050/root/demo_3:$container &>/dev/null
        # If the image is updated, then, restart the container
        if docker images | awk '{print $2}' | awk 'NR==2' | grep $container &>/dev/null; then
            echo "Updating $container"
            docker-compose up --no-deps -d $container &>/dev/null &
        # If the container is already up, then, print it out
        elif 
            docker ps | grep -q $container; then
            echo "Running $container";
        # If the container is down, then, start it    
        else
            echo "Starting $container"
            docker-compose up --no-deps -d $container &>/dev/null &
        fi
done

echo "Checking active containers, please hold on..."
sleep 15
docker-compose ps

echo "Deleting unused images" 
docker image prune -a -f | grep Total
