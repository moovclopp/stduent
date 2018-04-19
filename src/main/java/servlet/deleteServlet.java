package servlet;

import entity.Students;
import redis.clients.jedis.Jedis;
import util.RedisUtil;
import util.SerializationUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class deleteServlet extends javax.servlet.http.HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2011784296730584190L;

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Jedis jedis = RedisUtil.getJedis();
        String id=request.getParameter("id");
        String key = "Student";

        byte[] bs = jedis.get(key.getBytes());

        Map<String, Students> map =(Map<String, Students>) SerializationUtil.deserialize(bs);
        if(map==null){
        	Map<String, Students> map1 = new HashMap<String, Students>();
        	map1.remove(id);
            jedis.set(key.getBytes(), SerializationUtil.serialize(map1));
        }else
        {
        map.remove(id);
        jedis.set(key.getBytes(), SerializationUtil.serialize(map));}
        getServletConfig().getServletContext().getRequestDispatcher("/queryServlet?currentPage=1").forward(request, response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
}
