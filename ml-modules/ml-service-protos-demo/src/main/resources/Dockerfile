# 生成的新镜像以centos镜像为基础
FROM centos:latest
# 作者
MAINTAINER by liangzhong(liangzhong.tan@outlook.om)
# 升级系统
RUN yum -y update
# 安装 openssh-server
RUN yum -y install openssh-server
# 修改/etc/ssh/sshd_config
RUN sed -i 's/UsePAM yes/UsePAM no/g' /etc/ssh/sshd_config
#将密钥文件复制到/etc/ssh/目录中
RUN ssh-keygen -t rsa -f /etc/ssh/ssh_host_rsa_key
RUN ssh-keygen -t ecdsa -f /etc/ssh/ssh_host_ecdsa_key
RUN ssh-keygen -t ed25519 -f /etc/ssh/ssh_host_ed25519_key
#变更root密码为1117
RUN echo "root:1117"|chpasswd
#开放窗口的22端口
EXPOSE 22
RUN /usr/sbin/sshd -D