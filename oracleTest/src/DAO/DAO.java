package DAO;

import java.sql.*;


//E= DTO, T= DAO
public abstract class DAO <E> {
	
	protected static Connection conn = null;
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;
	protected Statement stmt = null;
	
	
	public abstract boolean insert(E e);
	public abstract boolean update(E e);
	public abstract boolean delete(E e);
	public abstract Object selectAll();
	
}
