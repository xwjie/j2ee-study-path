package cn.xiaowenjie;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService ;

	public CrudServlet() {
	    this.userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        Collection<User> users = this.userService.queryAllUser();

        // 输出格式，纯文本
		response.getWriter().append(users.toString());
	}

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

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.getWriter().append(users.toString());
    }

}
