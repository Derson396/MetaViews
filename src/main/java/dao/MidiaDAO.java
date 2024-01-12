package dao;
import java.sql.*;
import model.Midia;
public class MidiaDAO {
private Connection conexao;
	
	public MidiaDAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "teste";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirMidia(Midia midia) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO Midia (idMidia, duracao, nome, tipo,classificacaoIndicatica,sinopse,dataLancamento) "
					       + "VALUES ("+midia.getIdM()+ ", '" + midia.getDuracao() + "', '" +midia.getNome()+"', '" 
					       + midia.getTipo() + "', '" + midia.getClassificacaoIndicatoria() +midia.getSinopse()+midia.getDataLancamento()+ "');");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarMidia(Midia midia) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE usuario SET duracao = '" + midia.getDuracao() + "', nome = '"  
				       + midia.getNome() + "', tipo = '" + midia.getTipo() + "'"+"',classificacaoIndicatica = '"+ midia.getClassificacaoIndicatoria()+"'"+"',sinopse = '"+midia.getSinopse()+"'"+"',dataLancamento = '"+midia.getDataLancamento()+"'"
					   + " WHERE codigo = " + midia.getIdM();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirUsuario(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM usuario WHERE codigo = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Midia[] getUsuarios() {
		Midia[] Midias = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario");		
	         if(rs.next()){
	             rs.last();
	             Midias = new Midia[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                Midias[i] = new Midia(rs.getInt("idMidia"), rs.getFloat("duracao"),rs.getString("nome"), 
	                		                  rs.getInt("tipo"), rs.getInt("classificacaoIndicatica"),rs.getString("sinopse"),rs.getDate("dataLancamento"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return Midias;
	}

	
	public Midia[] getUsuariosMasculinos() {
		Midia[] usuarios = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE usuario.sexo LIKE 'M'");		
	         if(rs.next()){
	             rs.last();
	             usuarios = new Midia[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
		                usuarios[i] = new Midia(rs.getInt("idMidia"), rs.getFloat("duracao"),rs.getString("nome"), 
      		                  rs.getInt("tipo"), rs.getInt("classificacaoIndicatica"),rs.getString("sinopse"),rs.getDate("dataLancamento"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}
}
