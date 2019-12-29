# j2ee容器

开发j2ee项目，使用eclipse比intellij idea方便。建议使用eclipse。记得使用web开发版本。

[下载Eclipse IDE for Enterprise Java Developers](https://www.eclipse.org/downloads/packages/)

## 目标

- 理解servlet概念
  - 是规范，是接口，可以运行在实现了servlet规范的容器上。不同的容器如tomcat，jetty等，有不同的实现。
- 知道http 7大方法以及servlet中对应的方法
- 使用servlet处理crud请求
- 区分post/get使用场景
- 学习rest测试工具的使用（这里使用chrome的restlet插件）
- 学习视图（view）和模板的使用
- servlet3 和 servlet2.5 区别

## 知识点

- javax.servlet.http.HttpServletRequest
- javax.servlet.http.HttpServletResponse
- javax.servlet.http.HttpServletRequestWrapper
- javax.servlet.http.HttpServletResponseWrapper
- org.apache.catalina.connector.RequestFacade
- org.apache.catalina.connector.ResponseFacade



## 工程列表

### Servlet处理请求

所有请求都是servlet处理。也只有servlet能处理请求。到了tomcat容器的静态资源，也是servlet处理的。

jsp可以做为处理器（直接用xxx.jsp访问的这种），也可以做为模板，这个时候url上看不到jsp的字样，是你编写的servlet处理的，这个时候jsp作为模板一般就没有太多的业务逻辑代码了。需要分清楚这2种情况。我们一般时候说jsp指的是第一种。

做为模板使用的时候。jsp一般就会放到无法直接访问到的地方，也就是 `WEB-INF`目录里面。

- 返回html文本（FirstServlet）
- 返回json（JsonServlet）
- jsp做为处理器（index.jsp)
  - 会生成index_jsp.java，实际上是个servlet。
- 返回JSP视图（返回JSP视图）
  - 也会生成servlet，实际上是请求转发，A方法在调用B方法而已。

### 使用volicity模板

jsp模板基本已经淘汰，使用起来也比较麻烦。我们使用老牌的 volicity 模板。

构建理解模板的概念：模板文本 + 数据 经过 模板引擎解析渲染后，就是最终的文本。

网页上模板最终产生的文本就是html。

### 前台模板



