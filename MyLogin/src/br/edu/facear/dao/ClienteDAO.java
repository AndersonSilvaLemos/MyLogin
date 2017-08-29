package br.edu.facear.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Cliente;

public class ClienteDAO extends GenericDAO{
	private PreparedStatement ps;
	private String SQL_INSERT = "INSERT INTO TBCLIENTE(nome, cpf, email, senha) VALUES (?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE TBCLIENTE(nome, cpf, email, senha) VALUES (?, ?, ?, ?);";
	private String LOGIN_SQL = "SELECT * "
							 + "FROM TBCLIENTE "
			                 + "WHERE EMAIL = ? AND SENHA = ?;";
	private String LISTAR_SQL = "SELECT * FROM TBCLIENTE;";
	
	public Cliente autenticar(String email, String senha) throws ClassNotFoundException, IOException, SQLException{
		Cliente c = null;
		//Abrir uma conexao
		openConnection();
		
		//Preparar o script
		ps = connect.prepareStatement(LOGIN_SQL);
		ps.setString(1, email);
		ps.setString(2, senha);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs != null)
			while(rs.next()){
				c = new Cliente(rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("cpf"), 
						rs.getString("email"), 
						rs.getString("senha"));
			}
		
		
		//Fechar a conexao
		closeConnection();
		
		return c;
	}
	
	/**
	 * Método de inserção de Cliente
	 */
	public void inserir(Cliente c){
		
		try {
			// Abrir conexão
			openConnection();
			
			// Preparar o comando SQL a ser enviado ao BD
			ps = connect.prepareStatement(SQL_INSERT);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getCpf());
			ps.setString(4, c.getSenha());
			
			// Executar o comando de INSERT, logo não se espera retorno
			ps.executeUpdate();
			
			// Fechar conexão
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting");
		}
		
	}
	
	/**
	 * Método de alteração de Cliente
	 */
	public void alterar(Cliente c){
		
		
		
	}
	
	/**
	 * Método de excluir de Cliente
	 */
	public void excluir(Cliente c){
		
		
		
	}
	
	/**
	 * Método de listagem de todos os Cliente
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public List<Cliente> listar() throws ClassNotFoundException, IOException, SQLException{
		List<Cliente> lista = new ArrayList<Cliente>();
		// Abrir conexão
		openConnection();
		
		// Executar o script
		ps = connect.prepareStatement(LISTAR_SQL);
		ResultSet rs = ps.executeQuery();
		
		//Analisar o retorno do script
		if(rs != null){
			while(rs.next()){
				Cliente c = new Cliente(rs.getInt("id"), 
										rs.getString("nome"),
										rs.getString("cpf"), 
										rs.getString("email"), 
										rs.getString("senha"));
				lista.add(c);
			}
		}
		
		closeConnection();
		
		return lista;
	}
	
	public Cliente obterClientePorId(Integer id) {
		
		//Inserir a lógica
		
		return null;
	}
}
