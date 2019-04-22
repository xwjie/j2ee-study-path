import cn.xiaowenjie.CrudServlet;

public class Test {

    public static void main(String[] args) {
        System.out.println(CrudServlet.extractUrlId("/curd"));
        System.out.println(CrudServlet.extractUrlId("/curd/"));
        System.out.println(CrudServlet.extractUrlId("/curd/1"));
    }
}
