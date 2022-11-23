#!/bin/bash

##### This Script is intended to Update the current running app for MOalerts #####
REPO='MOAlerts'
DIR='/home/noetic/MOAlerts/'
DIRLOG='/var/log/apps/MOAlerts'
IMAGE='mo-alerts'
echo "Pull request from GitHub repo to ~${REPO} directory ..." && echo "" && \
[ ! -d "${DIR}" ] && mkdir -p "${DIR}"
cd ${DIR}
git pull origin dev &&
echo "Stopping ${IMAGE}_c from production environment ..." && echo "" && \
docker stop ${IMAGE}_c  && 
echo "destroying ${IMAGE}_c container  ..." && echo "" && \
docker rm -f ${IMAGE}_c && 
echo "deleting  container  ..." && echo "" && 
docker rmi -f ${IMAGE} && 
echo "Creating Build for newly pulled code ..." && echo "" && \
mvn clean package && 
echo "Creating Build for newly pulled code ..." && echo "" && \
docker build -t ${IMAGE} . && 
echo "Deploying the container ${IMAGE}_c ..." && echo "" && \
[ ! -d "${DIRLOG}" ] && mkdir -p "${DIRLOG}"
docker run -d --restart unless-stopped -p 7000:7000 -v /var/log/apps/${REPO}:/var/log/apps/${REPO} --name ${IMAGE}_c ${IMAGE} &&
echo "Build Successfull ..." && echo "" && 
echo "Success"
exit