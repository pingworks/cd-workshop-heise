#!/bin/bash

set -e

echo "Stopping Tomcat .."
sudo /etc/init.d/tomcat7 stop
echo -e "done.\n"

echo "Cleaning up existing webapps .."
rm -rf /var/lib/tomcat7/webapps/musicDB*
echo -e "done.\n"

echo "Installing new artifact.."
cp /var/bundle/unpack/artifacts/musicDB-*.war /var/lib/tomcat7/webapps/musicDB.war
echo -e "done.\n"

echo "Starting Tomcat .."
sudo /etc/init.d/tomcat7 start
echo -e "done.\n"

echo "Running Smoke Test for http://testenv1:8080/musicDB/ .."
wget -q -O/dev/null http://testenv1:8080/musicDB/
echo -e "done.\n"
