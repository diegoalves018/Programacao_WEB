package DAO;

import java.util.*;
import java.sql.*;

public class UsuarioDao {

	private static final String sql="select *from usuario where email=? and senha=?";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/cadastro?useTimezone=true&serverTimezone=America/Sao_Paulo";
    private static final String USUARIO = "root";
    private static final String SENHA = "admin";
   
    public static Connection getConnection(){
    	Connection con=null;
        try{
            Class.forName(DRIVER);
                con=DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch(Exception ex){System.out.println(ex);}
		return con;
	}
    
    public boolean check(String email, String senha) {
		Connection con=null;
	    try{
		Class.forName("com.mysql.cj.jdbc.Driver");
  	
    	 con= DriverManager.getConnection( URL, USUARIO, SENHA );
    	 PreparedStatement ps=con.prepareStatement(sql);
    	 ps.setString(1,email);
    	 ps.setString(2,senha);
    	 ResultSet rs=ps.executeQuery();
    	 if(rs.next()) {
    		 return true;
    	 }
    	   	 
    }catch(Exception ex){System.out.println(ex);}
		
		return false;
	}
    
    
	public static int save(Usuario e){
		int status=0;
		
		try{
			Connection con=UsuarioDao.getConnection();
			if(existeUsuario(e)) {
				throw new RuntimeException("E-mail já cadastrado");
			}
			PreparedStatement ps=con.prepareStatement("insert into usuario(nome,senha,email,dataNascimento) values (?,?,?,?)");			
			ps.setString(1,e.getNome());
			ps.setString(2,e.getSenha());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getDataNascimento());
					
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	private static boolean existeUsuario(Usuario user) {

		List<Usuario> list=UsuarioDao.getTodosCadastros();
		for(Usuario e:list){
			if (e.getEmail().equals(user.getEmail())) {
				return true;
			}
		}

		return false;
	}
	
	public static int update(Usuario e){
		int status=0;
		try{
			Connection con=UsuarioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update usuario set nome=?,senha=?,email=?,dataNascimento=? where id=?");
			ps.setString(1,e.getNome());
			ps.setString(2,e.getSenha());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getDataNascimento());
			ps.setInt(5,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=UsuarioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from usuario where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static Usuario getCadastradosId(int id){
		Usuario e=new Usuario();
		
		try{
			Connection con=UsuarioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from usuario where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setNome(rs.getString(2));
				e.setSenha(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setDataNascimento(rs.getString(5));
			}
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	
	public static List<Usuario> getTodosCadastros(){
		List<Usuario> list=new ArrayList<Usuario>();
		
		try{
			Connection con=UsuarioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from usuario");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Usuario e=new Usuario();
				e.setId(rs.getInt(1));
				e.setNome(rs.getString(2));
				e.setSenha(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setDataNascimento(rs.getString(5));
				list.add(e);
			}
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return list;
	}
	
}