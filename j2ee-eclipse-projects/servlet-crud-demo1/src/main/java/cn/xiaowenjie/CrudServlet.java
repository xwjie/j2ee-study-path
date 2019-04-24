package cn.xiaowenjie;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CrudServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;

    public CrudServlet() {
        this.userService = new UserService();
    }

    /**
     * 查询数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 从url上获取id
        String id = extractUrlId(request.getRequestURI());

        System.out.println("get user, id:" + id);

        if (id == null) {
            Collection<User> users = this.userService.queryAllUser();
            outPut(response, users);
        } else {
            User user = this.userService.queryById(Integer.parseInt(id));
            outPut(response, user);
        }
    }

    /**
     * 输出数据
     * @param response
     * @param obj
     * @throws IOException
     */
    private void outPut(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("text/json; charset=utf-8");

        if (obj != null) {
            // 输出格式，纯文本
            response.getWriter().append( toJson(obj) ) ;
        }
    }

    /**
     * 转换为json字符串
     * TODO: 实际上应该单独一个工具类出来
     * @param obj
     * @return
     */
    private static String toJson(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * 得到 url 后面的参数
     *
     * @param url
     * @return
     */
    public static String extractUrlId(String url) {
        String[] params = url.split("/");
        // System.out.println(Arrays.toString(params));

        if (params.length <= 2) {
            return null;
        } else {
            return params[2];
        }
    }

    /**
     * 新建数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // POST方法里面调用getParameter方法
        // 如果没有 Content-Type: application/x-www-form-urlencoded 参数必须在url上
        // 如果有，参数在url或者body上都可以
        // 实际上不太需要纠结这些细节，spring等框架封装好了

        // FIXME 实际上做好判空等异常
        int age = Integer.parseInt(request.getParameter("age"));
        String name = request.getParameter("name");

        User user = this.userService.createUser(name, age);
        System.out.println("user create success:" + user);

        // 创建成功，可以返回新对象
        // RESTFUL 的规范是返回201（body无东西），对象创建成功  201 Created.
        // 也可以返回 204，无内容
        response.setStatus(201);
    }

    /**
     * 修改数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = extractUrlId(request.getRequestURI());

        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }

        User user = this.userService.queryById(Integer.parseInt(id));

        if (user == null) {
            throw new IllegalArgumentException("id not exist");
        }

        user.setName(request.getParameter("name"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
    }

    /**
     * 删除数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getRequestURI());

        String id = extractUrlId(request.getRequestURI());

        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }

        User user = this.userService.deleteUser(Integer.parseInt(id));

        outPut(response, user);
    }

}
