package weibo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	
	public static Connection getConnection(){
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");	
			String url="jdbc:mysql://localhost:3306/weibo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";	
			con =DriverManager.getConnection(url,"root","1234,fgd");
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return con;
	}
	/** 
     * ��ɾ��
     */ 
    public static int executeNonQuery(String sql) { 

        int result = 0; 
        Connection conn = null; 
        Statement stmt = null; 

        try { 
        	
            conn = getConnection(); 
            stmt = conn.createStatement(); 
            result = stmt.executeUpdate(sql); 
            
        } catch (SQLException err) { 
        	
            err.printStackTrace(); 
            free(null, stmt, conn); 

        } finally { 

            free(null, stmt, conn); 

        } 

        return result; 

    } 

 

    /** 

     * ��ɾ�ġ�Add��Delete��Update��

     * 

     * @param sql 

     * @param obj 

     * @return int 

     */ 

    public static boolean executeNonQuery(String sql, Object... obj) { 

        boolean result = false; 
        Connection conn = null; 
        PreparedStatement pstmt = null; 

        try { 

            conn = getConnection(); 
            pstmt = conn.prepareStatement(sql); 

            for (int i = 0; i < obj.length; i++) { 
                pstmt.setObject(i + 1, obj[i]); 
            }
            int key = pstmt.executeUpdate(); 
            if(key == 1)
            {
            	result = true;
            }
        } catch (SQLException err) { 
        	
            err.printStackTrace(); 
            free(null, pstmt, conn);            
        } finally {        	
            free(null, pstmt, conn);           
        } 
        return result; 

    } 


    /** 

     * �顾Query��

     * 

     * @param sql 

     * @return ResultSet 

     */ 

    public static ResultSet executeQuery(String sql) { 

        Connection conn = null; 
        Statement stmt = null; 
        ResultSet rs = null; 

        try { 

            conn = getConnection(); 
            stmt = conn.createStatement(); 
            rs = stmt.executeQuery(sql); 

        } catch (SQLException err) { 

            err.printStackTrace(); 
            free(rs, stmt, conn); 

        } 

        return rs; 

    } 

 
    /** 

     * �顾Query��

     * 

     * @param sql 

     * @param obj 

     * @return ResultSet 

     */ 

    public static ResultSet executeQuery(String sql, Object... obj) { 

        Connection conn = null; 
        PreparedStatement pstmt = null; 
        ResultSet rs = null; 

        try { 

            conn = getConnection(); 
            pstmt = conn.prepareStatement(sql); 

            for (int i = 0; i < obj.length; i++) { 

                pstmt.setObject(i + 1, obj[i]); 

            } 

            rs = pstmt.executeQuery(); 

        } catch (SQLException err) { 

            err.printStackTrace(); 
            free(rs, pstmt, conn); 

        } 

        return rs; 

    } 

 
    /** 

     * �жϼ�¼�Ƿ����

     * 

     * @param sql 

     * @return Boolean 

     */ 

    public static Boolean isExist(String sql) { 

        ResultSet rs = null; 

        try { 

            rs = executeQuery(sql); 
            rs.last(); 
            int count = rs.getRow(); 
            
            if (count > 0) { 

                return true; 

            } else { 

                return false; 

            } 

        } catch (SQLException err) { 

            err.printStackTrace(); 
            free(rs); 
            return false; 

        } finally { 

            free(rs); 

        } 

    } 

 
    /** 

     * �жϼ�¼�Ƿ����

     * 

     * @param sql 

     * @return Boolean 

     */ 

    public static Boolean isExist(String sql, Object... obj) { 

        ResultSet rs = null; 

        try { 

            rs = executeQuery(sql, obj); 
            rs.last(); 
            int count = rs.getRow(); 

            if (count > 0) { 

                return true; 

            } else { 

                return false; 

            } 

        } catch (SQLException err) { 

            err.printStackTrace(); 
            free(rs); 
            return false; 

        } finally { 

            free(rs); 

        } 

    } 


    /** 

     * ��ȡ��ѯ��¼��������

     * 

     * @param sql 

     * @return int 

     */ 

    public static int getCount(String sql) { 

        int result = 0; 
        ResultSet rs = null; 

        try { 

            rs = executeQuery(sql); 
            rs.last(); 
            result = rs.getRow(); 

        } catch (SQLException err) { 

            free(rs); 
            err.printStackTrace(); 

        } finally { 

            free(rs); 

        } 

        return result; 

    } 

 
    /** 

     * ��ȡ��ѯ��¼��������

     * 

     * @param sql 

     * @param obj 

     * @return int 

     */ 

    public static int getCount(String sql, Object... obj) { 

        int result = 0; 
        ResultSet rs = null; 
        try { 

            rs = executeQuery(sql, obj); 
            rs.last(); 
            result = rs.getRow(); 

        } catch (SQLException err) { 

            err.printStackTrace(); 

        } finally { 

            free(rs); 

        } 

        return result; 

    } 


    /** 

     * �ͷš�ResultSet����Դ

     * 

     * @param rs 

     */ 

    public static void free(ResultSet rs) { 

        try { 

            if (rs != null) { 

                rs.close(); 

            } 

        } catch (SQLException err) { 

            err.printStackTrace(); 

        } 

    } 


    /** 

     * �ͷš�Statement����Դ

     * 

     * @param st 

     */ 

    public static void free(Statement st) { 

        try { 

            if (st != null) { 

                st.close(); 

            } 

        } catch (SQLException err) { 

            err.printStackTrace(); 

        } 

    } 
 

    /** 

     * �ͷš�Connection����Դ

     * 

     * @param conn 

     */ 

    public static void free(Connection conn) { 

        try { 

            if (conn != null) { 

                conn.close(); 

            } 

        } catch (SQLException err) { 

            err.printStackTrace(); 

        } 

    } 


    /** 

     * �ͷ�����������Դ

     * 

     * @param rs 

     * @param st 

     * @param conn 

     */ 

    public static void free(ResultSet rs, Statement st, Connection conn) { 

        free(rs); 
        free(st); 
        free(conn); 

    } 
	
}
