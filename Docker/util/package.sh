#!/bin/bash

# 请注意
# 本脚本的作用是把本项目编译的结果保存到deploy文件夹中
# 1. 把项目数据库文件拷贝到Docker/db/init-sql
# 2. 编译SKS-Admin
# 3. 编译SKS-Start模块，然后拷贝到Docker/SecondsKillSystem

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
cd $DIR/../..
SKS_HOME=$PWD
echo "SKS_HOME $SKS_HOME"

# 复制数据库
cat $SKS_HOME/SKS-DB/SQL/sks_table.sql >> $SKS_HOME/Docker/db/init-sql/sks.sql
cat $SKS_HOME/SKS-DB/SQL/sks_data.sql >> $SKS_HOME/Docker/db/init-sql/sks.sql

# 安装阿里node镜像工具
npm install -g cnpm --registry=https://registry.npm.taobao.org

# 打包SKS-Admin
cd $SKS_HOME/SKS-Vue-Admin
cnpm install
cnpm run build:dep

cd $SKS_HOME
mvn clean package
cp -f $SKS_HOME/SKS-Start/target/SKS-Start-*-exec.jar $SKS_HOME/Docker/SecondsKillSystem/SecondsKillSystem.jar