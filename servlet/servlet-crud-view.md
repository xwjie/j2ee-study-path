# 返回试图

在上面的例子基础之上，我们返回试图。

可以在上一个servlet上实现，也可以单独新增一个servlet，为了方便学习，我们单独创建一个servlet。servlet的 `url mapping` 为 `/view/*`

> 主要学习试图是什么，试图就是模板+数据+模板引擎=字符串（我们例子里面字符串是html格式）

## 新建servlet

```java
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;
    private ViewUtil viewUtil;

    public ViewServlet() {
        this.userService = new UserService();

        this.viewUtil = new ViewUtil();
        this.viewUtil.init();
    }

    /**
     * 查询数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("get users view...");

        Collection<User> users = this.userService.queryAllUser();

        Map<String, Object> datas = new HashMap<String, Object>();

        datas.put("users", users);
        datas.put("test", "测试数据");

        outPut(response, "users", datas);
    }


    private void outPut(HttpServletResponse response, String templateName, Map<String, Object> datas) throws IOException {
        response.setContentType("text/html; charset=UTF-8;");

        // 输出格式，纯文本
        response.getWriter().append(this.viewUtil.render(this.getServletContext(), templateName, datas));
    }

}
```

## 返回试图

```java
public class ViewUtil {

    private VelocityEngine ve;

    public void init() {
        this.ve = new VelocityEngine();

        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "webapp");
        ve.setProperty("webapp.resource.loader.class", "org.apache.velocity.tools.view.servlet.WebappLoader");
        ve.setProperty("input.encoding", "UTF-8");
        ve.setProperty("output.encoding", "UTF-8");
        ve.setProperty("webapp.resource.loader.path", "/WEB-INF/views");
    }


    public String render(ServletContext servletContext, String templateName, Map<String, Object> dataMap) {
        ve.setApplicationAttribute("javax.servlet.ServletContext", servletContext);
        ve.init();

        // 对于的试图模板
        Template t = ve.getTemplate(templateName + ".vm");
        VelocityContext ctx = new VelocityContext();

        // 数据
        dataMap.forEach((key, value) -> ctx.put(key, value));

        StringWriter sw = new StringWriter();
        t.merge(ctx, sw);
        return sw.toString();
    }
}
```

## 配置

- web.xml 配置

```xml
<!-- 试图servlet -->
<servlet>
    <servlet-name>ViewServlet</servlet-name>
    <display-name>ViewServlet</display-name>
    <description></description>
    <servlet-class>cn.xiaowenjie.ViewServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>ViewServlet</servlet-name>
    <url-pattern>/view/*</url-pattern>
</servlet-mapping>
```

- pom.xml 配置

```xml
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity</artifactId>
    <version>1.7</version>
</dependency>

<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-tools</artifactId>
    <version>2.0</version>
</dependency>
```

## 试图模板

```html
<h1>这是模板$test</h1>
#foreach ($i in $users)
<h2>$i.name</h2>
#end
```

> 不知道为什么，users渲染不出来。。。

## 参考

[velocity整合servlet](https://www.cnblogs.com/zhangshitong/p/6004343.html)
[使用 velocity 模板引擎](http://www.voidcn.com/article/p-kskjuict-bnw.html)