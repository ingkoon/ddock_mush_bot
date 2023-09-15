#/bin/sh

SERVER_CONTAINER_ID=`docker ps -aq --filter 'name=tarnished_bot'`

if [ -n "$SERVER_CONTAINER_ID" ];
  then
    echo "server container exist"
    docker stop $SERVER_CONTAINER_ID
    docker rm $SERVER_CONTAINER_ID
    docker run -d -p 8082:8082 --network springboot-mysql-net --name tarnished_bot server:tarnished_bot
  else
    echo "node container not exist"
    docker run -d -p 8082:8082 --network springboot-mysql-net --name tarnished_bot server:tarnished_bot
fi