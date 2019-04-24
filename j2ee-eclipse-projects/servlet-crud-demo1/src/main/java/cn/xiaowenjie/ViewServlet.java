package cn.xiaowenjie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
