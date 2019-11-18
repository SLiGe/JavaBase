#创建windows服务
sc <server> create [service name] [binPath= ] <option1> <option2>...
#DisplayName= <显示名称>
example:
sc create MRedis binpath= "D:\dev\redis\redis-server.exe --service-run "D:\dev\redis\redis.windows-service.conf"" start= auto displayname= TestRedis
#删除服务
sc delete MRedis
#相关命令
query-----------查询服务的状态， 或枚举服务类型的状态。
queryex---------查询服务的扩展状态，或枚举服务类型的状态。
start-----------启动服务。
pause-----------向服务发送 PAUSE 控制请求。
interrogate-----向服务发送 INTERROGATE 控制请求。
continue--------向服务发送 CONTINUE 控制请求。
stop------------向服务发送 STOP 请求。
config----------更改服务的配置(永久)。
description-----更改服务的描述。
failure---------更改服务失败时执行的操作。
failureflag-----更改服务的失败操作标志。
sidtype---------更改服务的服务 SID 类型。
privs-----------更改服务的所需权限。
qc--------------查询服务的配置信息。
qdescription----查询服务的描述。
qfailure--------查询失败时服务执行的操作。
qfailureflag----查询服务的失败操作标志。
qsidtype--------查询服务的服务 SID 类型。
qprivs----------查询服务的所需权限。
qtriggerinfo----查询服务的触发器参数。
qpreferrednode--查询首选的服务 NUMA 节点。
delete----------(从注册表)删除服务。
create----------创建服务(将其添加到注册表)。
control---------向服务发送控制。
sdshow----------显示服务的安全描述符。
sdset-----------设置服务的安全描述符。
showsid---------显示相应于假定名称的 SID 字符串。
triggerinfo-----配置服务的触发器参数。
preferrednode---设置首选的服务 NUMA 节点。
GetDisplayName--获取服务的 DisplayName
GetKeyName------获取服务的 ServiceKeyName。
EnumDepend------枚举服务的依存关系