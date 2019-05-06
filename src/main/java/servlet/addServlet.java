package servlet;

import entity.Students;
import redis.clients.jedis.Jedis;
import util.RedisUtil;
import util.SerializationUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class addServlet extends javax.servlet.http.HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4562747061636791510L;
	private static Map<String, Students> student=new HashMap<String,Students>();
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Jedis jedis = RedisUtil.getJedis();
        Students students=new Students();

        students.setId(request.getParameter("id"));
        students.setName(request.getParameter("name"));
        students.setBirthday(request.getParameter("birthday"));
        students.setDescription(request.getParameter("description"));
        students.setAvgscore(request.getParameter("avgscore"));
        student.put(request.getParameter("id"), students);

        String key = "Student1";
        byte[] bs = jedis.get(key.getBytes());
        Map<String,Students> map =(Map<String, Students>) SerializationUtil.deserialize(bs);
        if(map==null){
        	Map<String,Students> map1 =new HashMap<String,Students>();
        	map1.put(request.getParameter("id"), students);
            jedis.set(key.getBytes(), SerializationUtil.serialize(map1));}
        else{
        	map.put(request.getParameter("id"), students);
            jedis.set(key.getBytes(), SerializationUtil.serialize(map));
        }
      
        getServletConfig().getServletContext().getRequestDispatcher("/queryServlet?currentPage=1").forward(request, response);
        RedisUtil.returnResource(jedis);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
}
