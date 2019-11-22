#!/usr/bin/env bash
#1.解压
tar -zvxf filename.tar

# -c 创建新的文档
# -v 显示详细的tar处理的文件信息
# -f 要操作的文件名
# -r 表示增加文件，把要增加的文件追加在压缩文件的末尾
# -t 表示查看文件，查看文件中的文件内容
# -x 解压文件
# -z 调用gzip程序来压缩文件，压缩后的文件名称以.gz结尾
# -j 调用bzip2来进行压缩文件,压缩后的文件名称以.bz2结尾

#2.压缩
tar czvf filename.tar dirname

#3.请求代理
wget -e "http-proxy=10.99.11.11" http://www.baidu.com
curl -x 10.99.11.11:8123 http://www.baidu.com

#4.查看端口
netstat -apn|grep "port"

#5.rpm操作
rpm -qa|grep java                    # 查询安装的rpm包
rpm -ivh your-package                # 直接安装
rpm --force -ivh your-package.rpm    # 忽略报错，强制安装
rpm -ivh *.rpm --nodeps --force      # 直接安装
rpm -e --nodeps java-1.6.0-openjdk-1.6.0.0-1.66.1.13.0.el6.i686 #卸载软件

#6.配置环境变量
vim /etc/profile #编辑环境文件
JAVA_HOME=/usr/local/jdk8  #配置的路径
PATH=$PATH:$JAVA_HOME/bin  #linux中分隔符为:
export JAVA_HOME PATH
source /etc/profile     #刷新配置文件

#7.目录
cp -r /dir /toDir #复制多级目录
mkdir -p /dir/1/2 #创建多级目录
chown -R root:root /tmp/src #将目录 /tmp/src 中所有文件的所有者和组更改为用户 root 和组 root


#8.用户
groupadd groupname #创建组
useradd -g groupname username #创建用户并指定组
