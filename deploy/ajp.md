# AJP协议

AJP协议是apache和tomcat直接传输数据的独有协议。

nginx和tomcat直接是用http协议输送的（好像也可以配置ajp协议，但一般没有这样配置）。而apache和tomcat之间，不使用http协议，而是用ajp协议，因为http协议是文本（基于http， 默认端口8080
），而ajp协议是二进制（基于tcp， 默认端口8009），效率更快更好。

实际部署中，tomcat应该是隐藏在nginx/apache后面，不应该对外公开，不应该能让外部直接访问到。可以用防火墙隔离，在使用apache的情况下，可以把tomcat的http端口关闭掉，只留下ajp端口。


## apache 的 ajp 配置

参见 [Apache+Tomcat+AJP](http://www.cppblog.com/windcsn/archive/2011/07/18/151313.html)

可以使用自带的 `mod_jk` 模块

> Mod_JK是Apache的一个模块，其通过AJP协议实现Apache与Tomcat之间的通讯，而Tomcat默认监听AJP连接器的8009端口来接受AJP的连接请求；一般这些请求来自前端的Apache服务器。

