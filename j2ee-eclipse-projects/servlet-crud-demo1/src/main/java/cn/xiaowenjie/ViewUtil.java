package cn.xiaowenjie;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

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
