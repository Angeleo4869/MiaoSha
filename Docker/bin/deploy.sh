#!/bin/bash

cd /www/server/docker
sudo docker-compose down
sudo docker-compose build
sudo docker image prune -f
sudo docker-compose up -d
