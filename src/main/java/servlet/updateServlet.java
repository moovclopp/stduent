package servlet;

import entity.Students;
import redis.clients.jedis.Jedis;
import util.RedisUtil;
import util.SerializationUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class updateServlet extends javax.servlet.http.HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5610707159615925505L;

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Jedis jedis = RedisUtil.getJedis();
        String id=request.getParameter("id");
        String key = "Student";

        byte[] bs = jedis.get(key.getBytes());
        Map<String, Students> map =(Map<String, Students>) SerializationUtil.deserialize(bs);
        if(map==null){
        	Map<String, Students> map1 = new HashMap<String,Students>();
        	 Students student=map1.get(id);
             request.setAttribute("student", student);
        }
        else{
        Students student=map.get(id);
        request.setAttribute("student", student);}
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
}
