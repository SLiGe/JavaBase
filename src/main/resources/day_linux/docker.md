## 1.解压版本docker安装
[官网地址](https://docs.docker.com/install/linux/docker-ce/binaries/#install-static-binaries)
---
  a.首先现在**docker**的压缩包
  
  b.解压 tar xzvf /path/to/<FILE>.tar.gz
  
  c.复制到bin目录 cp docker/* /usr/bin/
  
  d.启动docker : dockerd &
## 2.将docker注册为服务
`vim /etc/systemd/system/docker.service`
####脚本内容
```bash
[Unit]

Description=Docker Application Container Engine

Documentation=https://docs.docker.com

After=network-online.target firewalld.service

Wants=network-online.target

[Service]

Type=notify

# the default is not to use systemd for cgroups because the delegate issues still

# exists and systemd currently does not support the cgroup feature set required

# for containers run by docker

ExecStart=/usr/bin/dockerd

ExecReload=/bin/kill -s HUP $MAINPID

# Having non-zero Limit*s causes performance problems due to accounting overhead

# in the kernel. We recommend using cgroups to do container-local accounting.

LimitNOFILE=infinity

LimitNPROC=infinity

LimitCORE=infinity

# Uncomment TasksMax if your systemd version supports it.

# Only systemd 226 and above support this version.

#TasksMax=infinity

TimeoutStartSec=0

# set delegate yes so that systemd does not reset the cgroups of docker containers

Delegate=yes

# kill only the docker process, not all processes in the cgroup

KillMode=process

# restart the docker process if it exits prematurely

Restart=on-failure

StartLimitBurst=3

StartLimitInterval=60s

[Install]
WantedBy=multi-user.target
```

## 3.启动
```bash
chmod +x /etc/systemd/system/docker.service       #添加文件权限并启动docker

systemctl daemon-reload                           #重载unit配置文件

systemctl start docker                            #启动Docker

systemctl enable docker.service                   #设置开机自启
```

## 4.验证
```bash
systemctl status docker               #查看Docker状态

docker -v                             #查看Docker版本
```
## 5.命令
```bash
docker load < 文件名.tar       #导入镜像
docker images                 #查看镜像
docker run --name 指定名称 -d image #-d 守护式容器
docker ps                     #查看正在运行的容器
docker attach --sig-proxy=false containerId #连接到容器查看日志
docker rename localcontainername newlocalcontainer  #修改容器名
docker update --restart=always/no/on-failure:num redis_dev #修改容器自启
```
## 6.常用命令
```bash
#1.启动mysql
docker run -itd --name mysql-test -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql:5.6
#2.启动rabbitmq
docker run -d --name rabbitmq_dev -p 5672:5672 -p 15672:15672 -v `pwd`/data:/var/lib/rabbitmq --hostname rabbit_dev -e RABBITMQ_DEFAULT_VHOST=my_vhost  -e RABBITMQ_DEFAULT_USER=guest -e RABBITMQ_DEFAULT_PASS=guest rabbitmq:3.8-rc-management
#3.启动redis
docker run -dit -p 6379:6379 -v /usr/local/etc/redis/redis.conf:/etc/redis/redis.conf  --name redis2 redis:latest redis-server /etc/redis/redis.conf
#4.启动Consul
docker run --name consul-server -d -p 8500:8500 -p 8300:8300 -p 8301:8301 -p 8302:8302 -p 8600:8600 -v /home/consul/config/:/consul/config/ -v /home/consul/data/:/consul/data/  consul agent -server -bootstrap-expect=1 -ui -bind=0.0.0.0 -client=0.0.0.0 -data-dir=/consul/data -config-dir=/consul/config
```