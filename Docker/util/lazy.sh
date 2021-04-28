#!/bin/bash

# 本脚本的作用是
# 1. 项目打包
# 2. 上传云服务器
# 3. 远程登录云服务器并执行reset脚本

# 请设置云服务器的IP地址和账户
# 例如 leo@122.51.199.160
REMOTE=leo@42.192.71.179
# 请设置本地SSH私钥文件id_rsa路径
# 例如 /home/litemall/id_rsa
ID_RSA=/d/00/cloud/litemall.txt

if test -z "$REMOTE"
then
  echo "请设置云服务器登录IP地址和账户"
  exit 1
fi

if test -z "$ID_RSA"
then
  echo "请设置云服务器登录IP地址和账户"
  exit 1
fi

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
cd $DIR/../.. || exit 2
SKS_HOME=$PWD
echo "SKS_HOME $SKS_HOME"

# 项目打包
cd $SKS_HOME || exit 2
./docker/util/package.sh

# 上传云服务器
cd $SKS_HOME || exit 2
scp -i $ID_RSA -r  ./docker $REMOTE:/www/server/docker

# 远程登录云服务器并执行reset脚本
# 这里使用tr命令，因为有可能deploy.sh和reset.sh的换行格式是CRLF，而LINUX环境应该是LF
ssh $REMOTE -i $ID_RSA << eeooff
cd /www/server/docker/bin
cat deploy.sh | lf -d '\r' > deploy2.sh
mv deploy2.sh deploy.sh
chmod +x deploy.sh
cat reset.sh | lf -d '\r' > reset2.sh
mv reset2.sh reset.sh
chmod +x reset.sh
sudo ./reset.sh
exit
eeooff