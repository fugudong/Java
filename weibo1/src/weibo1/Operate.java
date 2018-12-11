package weibo1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Operate {
	
	/**
	 * 
	 * @return
	 */
	public boolean addBlog(Blog microBlog) {
		// TODO Auto-generated method stub
		String sql = "insert into blog (title,content,logger) " +
				" values(?,?,?) ";
		Object[] obj = new Object[]{
				microBlog.getTitle(),
				microBlog.getContent(),
				microBlog.getLogger()
		}; 
		boolean result = DBConn.executeNonQuery(sql, obj);
		return result;
	}
	
	public boolean addBlog(String title,String content,int logger) {
		// TODO Auto-generated method stub
		String sql = "insert into blog (title,content,logger) " +
				" values(?,?,?) ";
		Object[] obj = new Object[]{
				title,
				content,
				logger
		}; 
		
		boolean result = DBConn.executeNonQuery(sql, obj);
		return result;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteBlog(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from blog where id = ?";
		Object[] obj = new Object[]{
			id	
		};
		boolean result = DBConn.executeNonQuery(sql, obj);
		return result;
	}
	
	public Blog getByID(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from blog where id = '"+id+"'";
		ResultSet rs = null;
		Blog blog = new Blog();
		
		try {
			rs = DBConn.executeQuery(sql);
			while(rs.next())
			{
				blog.setId(id);
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setCounter(rs.getInt("counter"));
				blog.setLogger(rs.getInt("logger"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blog;
	}
	
	public int CounterByID(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from blog left join logger on logger.name_id = blog.logger where blog.id = '"+id+"'";
		ResultSet rs = null;
		Blog blog = new Blog();
		
		try {
			rs = DBConn.executeQuery(sql);
			while(rs.next())
			{
				blog.setId(id);
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setCounter(rs.getInt("counter"));
				blog.setLogger(rs.getInt("logger"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blog.getCounter();
	}
	public int CounterByLogger(int name_id) {
		// TODO Auto-generated method stub
		String sql = "select * from logger left join blog on logger.name_id = blog.logger where logger.name_id = '"+name_id+"'";
		ResultSet rs = null;
		Blog blog = new Blog();
		
		try {
			rs = DBConn.executeQuery(sql);
			while(rs.next())
			{
				blog.setId(name_id);
				blog.setTitle(rs.getString("fans"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blog.getLogger();
	}
	public boolean UpdateCounter(int id,int counter){
		String sql = "update blog set counter = ?" +
		" where id =?";
        Object[] obj = new Object[]{
		  counter,id
        };
        System.out.println("update counter"+counter);
		boolean result = DBConn.executeNonQuery(sql, obj);
		return result;
	}
	public boolean fans(int name_id,int fans){
		String sql = "update logger set fans = ?" +
		" where logger.name_id =?";
        Object[] obj = new Object[]{
		  fans,name_id
        };
		boolean result = DBConn.executeNonQuery(sql, obj);
		return result;
	}
	public ArrayList<Blog> getAllList() {
		// TODO Auto-generated method stub
		String sql = "select * from blog ";
		ResultSet rs = null;
		ArrayList<Blog> alOrder = new ArrayList<Blog>();
		
		try {
			rs = DBConn.executeQuery(sql);
			while(rs.next())
			{
				Blog blogKey = new Blog();
				
				alOrder.add(blogKey);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alOrder;
	}
	public boolean updateOrder(Blog microBlog) {
		// TODO Auto-generated method stub
		String sql = "update blog set title = ? , content = ?" +
				" where id =?";
		Object[] obj = new Object[]{
				microBlog.getTitle(),
				microBlog.getContent(),
				microBlog.getId()
		};
		boolean result = DBConn.executeNonQuery(sql, obj);
		return result;
	}
}
