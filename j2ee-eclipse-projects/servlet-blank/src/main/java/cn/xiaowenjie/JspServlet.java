package cn.xiaowenjie;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JspServlet
 */
public class JspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 数据
		request.setAttribute("name", "这是一个变量");

		// 视图模板是：test.jsp
		// jsp视图引擎把数据和模板渲染成（html）文本返回
		request.getRequestDispatcher("/WEB-INF/template/test.jsp").forward(request, response);
	}
}
