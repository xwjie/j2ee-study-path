package cn.xiaowenjie;

import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrudServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getClass());
		System.out.println(response.getClass());

		// tomcat容器下，对于的类是以下的类，实际上使用，使用HttpServletRequest，HttpServletResponse已经足够
		RequestFacade requestFacade = (RequestFacade) request;
		ResponseFacade responseFacade = (ResponseFacade) response;

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
