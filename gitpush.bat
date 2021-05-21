@echo off

title GIT一键提交
color 3
echo 当前目录是：%cd%
echo;

echo 开始添加变更：git add .
git add .
echo;

set /p declation=输入提交的commit信息:
git commit -m "%declation%"
echo;

set /p current_branch=将变更情况提交到远程自己分支git push origin master? or develop?: 
git push origin "%current_branch%"
echo;
