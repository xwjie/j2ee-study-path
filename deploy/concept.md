# 概念了解

## 虚拟主机概念

一般情况下，一个域名指定一个ip（机器），指向一个应用。虚拟主机就是多个域名指向同一个ip。利用nginx或者apache的配置使得指向不同的应用处理。

最明显的区分，就是用域名可以访问，用ip不能访问（访问过去出现的不是自己的应用界面）

## 负载均衡概念

多个机器之间共同处理请求。负载均衡的策略是重点。

可以在4层交换里面用硬件使用(4层），更多的是用nginx、apache实现的软件配置（7层）。

- 四层、七层负载均衡

负载均衡又有4层和7层之分。

> 所谓四层就是基于 IP + 端口的负载均衡；\
> 七层就是基于 URL 等应用层信息的负载均衡；\
> 同理，还有基于 MAC 地址的二层负载均衡和基于 IP 地址的三层负载均衡。

[四层、七层负载均衡的区别](https://jaminzhang.github.io/lb/L4-L7-Load-Balancer-Difference/)

[nginx四层、七层负载均衡的区别](https://www.jianshu.com/p/1308c7e0f425)

- 负载均衡的策略

[nginx负载均衡的5种策略](https://www.cnblogs.com/andashu/p/6377323.html)


最常见的配置是轮询和hash，hash里面又分为ip hash，url hash，指定header字段（如cookie某个字段）hash。

> 经过4层交换后，由于ip都是4层交换的ip，使用ip hash的时候会出错，需要把用户真实的ip放在头上面，如`x-request-ip`, nginx上根据这个ip负载均衡。这个时候配置就不是 `ip_hash` , 而是 `hash $request_x_request_ip`。

- seesion 共享

负载均衡之后，就牵涉到session一致性，就是共享会话。一般可以用springboot的 `Spring-Session+Redis` 实现session共享。就是把session数据不放到各自的应用服务器（如tomcat），因为放到各自服务器无非互相访问，而是放到一个统一的地方（redis）。

> 配置负载均衡的时候，后台服务器收到的域名默认为upstream配置的名字，这点容易导致问题，需要谨慎验证。

## 反向代理概念

就是一个应用里面，不同的url最终在不同的服务器上处理，和负载均衡要区分清楚。

工作中经常使用，务必要会配置，不过配置相对简单。

反向代理一个重要场景是解决前台 `跨域` 问题。参见我的视频教程，[ajax跨域完全讲解
](https://www.imooc.com/view/947)，互联网上最好的跨域教程，初学者最少看3遍，而且要实际动手。

- cookie 代理问题

反向代理的时候，cookie的代理是一个容易出错的地方（域名是代理前的域名，路径是代理前的路径），需要了解cookie的工作机制。

[https://www.jianshu.com/p/aeed2a56a3eb](https://www.jianshu.com/p/aeed2a56a3eb)