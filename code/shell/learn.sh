#!/bin/bash
a="helloworld"
echo $a

if [ $a ];then
	echo "aaa"
fi

for i in $*
do
echo $i
done

echo $@
echo $*


echo "-- \$* 演示 ---"
for i in "$*"; do
    echo $i
done

echo "-- \$@ 演示 ---"
for i in "$@"; do
    echo $i
done


#获取数组的length（数组中有几个元素）：  
${#array[@]}  
  
#遍历（For循环法）：  
for var in ${arr[@]};  
do  
    echo $var  
done 

#遍历（带数组下标）
arr=(1 2 3 4 5) # 注意是用空格分开，不是逗号！！  
for i in "${!arr[@]}";   
do   
    printf "%s\t%s\n" "$i" "${arr[$i]}"  
done 

#遍历（While循环法）：  
i=0  
while [ $i -lt ${#array[@]} ]  
do  
    echo ${ array[$i] }  
    let i++  
done
