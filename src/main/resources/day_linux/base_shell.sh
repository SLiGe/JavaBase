#!/usr/bin/env bash
#字符串拼接
myName="Gary"
str1="Hello,"${myName}",You're well!"
echo ${str1}
#获取字符串长度
echo ${#str1}
#截取字符串
echo ${str1:0:5}
#查找子字符串
echo `expr index "${str1}" e`
link="http://www.java.com/index.html"
# # 号截取，删除左边字符，保留右边字符
echo ${link#*//}   # # 号是运算符，*// 表示从左边开始删除第一个 // 号及左边的所有字符

# ## 号截取，删除左边字符，保留右边字符
echo ${link##*/}   # ##*/ 表示从左边开始删除最后（最右边）一个 / 号及左边的所有字符

# %号截取，删除右边字符，保留左边字符
echo ${link%/*}    # %号截取，删除右边字符，保留左边字符

# %% 号截取，删除右边字符，保留左边字符
echo ${link%%/*}   # %% 号截取，删除右边字符，保留左边字符


#数组
nameArray=("Lily" "Jaly" "Summary")
echo ${nameArray[0]}
#获取数组全部元素
echo ${nameArray[@]}
#获取数组长度
echo ${#nameArray[@]}
echo ${#nameArray[*]}
# 取得数组单个元素的长度
echo ${#nameArray[0]}

#多行注释
:<<EOF
shell传递参数
sh bash_shell.sh 1 2 3
$0 为当前文件名
EOF

echo "Shell param";
echo "run file：$0";

function getLog() {
    a=3
    b=2
    if [[ ${a} -gt ${b} ]]
    then
        echo "${a}>${b}"
    else
        echo "${a}<${b}"
    fi
    echo "One function!"
}
getLog

tomcat_id=`ps -ef | grep tomcat | grep -v "grep" | awk '{print $2}'`
echo ${tomcat_id}

for id in ${tomcat_id}
do
    kill -9 ${id}
    echo "killed ${id} "
done