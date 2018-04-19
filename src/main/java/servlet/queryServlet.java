package servlet;

import entity.Students;
import redis.clients.jedis.Jedis;
import util.RedisUtil;
import util.SerializationUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class queryServlet extends javax.servlet.http.HttpServlet {
	private Integer currentPage=1;//当前页
	private Integer pagesize=10;//最大显示记录数
	private Integer totalPage;//总页数
	private Integer count;//总记录数
	private String ref=null;//当前记录
    /**
	 * 
	 */
	private static final long serialVersionUID = 6640173297341251949L;

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Jedis jedis = RedisUtil.getJedis();
        String key = "Student";
        byte[] bs = jedis.get(key.getBytes());
        Map<String, Students> map =(Map<String, Students>) SerializationUtil.deserialize(bs);
        if(map==null){
        	 Map<String, Students> map1 = new HashMap<String,Students>(); 
        	 Iterator<Map.Entry<String, Students>> it = map1.entrySet().iterator();
             while (it.hasNext()) {
                 Map.Entry<String, Students> entry = it.next();
                 System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }}
        else{
        Iterator<Map.Entry<String, Students>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Students> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }}
        count=map.size();
		  if((count%pagesize)==0){
			  totalPage=(count/pagesize);
		  }else{
			  totalPage=(count/pagesize)+1;
		  }
		  System.out.println(count);

		 if(currentPage!=null){
		      currentPage=Integer.valueOf(request.getParameter("currentPage"));
		      System.out.println("currentPage2"+currentPage);
		       if(currentPage<1){
				     currentPage=1;
				}if(currentPage>totalPage){
					currentPage=1;
		 }
	}
		 
		  Map<String,Students> newmap=new HashMap<String, Students>();
		  if(map.size()>pagesize){
			  	
			  	for(int i=1;i<=pagesize;i++){
			  			ref=String.valueOf(pagesize*(currentPage-1)+i);
			  			newmap.put(ref, map.get(ref));
			  			System.out.println("newmap"+newmap);
			  	}
			  	
			  	request.setAttribute("map", newmap);
			  	System.out.println("newmap");
			}else{
				request.setAttribute("map", map);
				System.out.println("map");
			}
		  request.setAttribute("currentPage", currentPage);
		  request.setAttribute("totalPage", totalPage);
		  request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
}
