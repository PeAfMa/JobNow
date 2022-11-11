package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Trabalhador;

public class TrabalhadorDAO extends DAO
{
	//inicia a conexão com o postgres
	public TrabalhadorDAO()
	{
		super();
		conectar();
	}
	
	//encerra a conexão com o postgres
	public void finalize()
	{
		close();
	}
	
	//insere um elemento na tabela
	public boolean insert(Trabalhador trabalhador)
	{
		boolean status = false;
		try
		{
			String sql = "INSERT INTO \"Trabalhador\" (\"ID\", \"Email\", \"Telefone\", \"Login\", \"Senha\", \"Premium\", \"Nome\", \"Sobrenome\", \"CPF\", \"Avaliação\", \"Local\") VALUES ('" +
					trabalhador.getId() + "', '" + trabalhador.getEmail() + "', '" +  trabalhador.getTelefone() + "', '" + trabalhador.getLogin() + "', '" + trabalhador.getSenha() + "', '" + trabalhador.getPremium() +
					"', '" + trabalhador.getNome() + "', '" + trabalhador.getSobrenome() + "', '" + trabalhador.getCpf() + "', '" + trabalhador.getAvaliacao() + "', '" +
					trabalhador.getLocal() + "');";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		}
		catch (SQLException u)
		{
			throw new RuntimeException(u);
		}
		return status;
	}
	
	//atualiza um elemento da tabela
	public boolean update(Trabalhador trabalhador)
	{
		boolean status = false;
		try
		{  
			String sql = "UPDATE \"Trabalhador\" SET \"Email\" = '" + trabalhador.getEmail() + "', \"Telefone\" = '" + trabalhador.getTelefone() + "', \"Login\" = '" + trabalhador.getLogin() + "', \"Senha\" = '" +
					trabalhador.getSenha() + "', \"Premium\" = '" + trabalhador.getPremium() + "', \"Nome\" = '" + trabalhador.getNome() + "', \"Sobrenome\" = '" + trabalhador.getSobrenome() + "', \"CPF\" = '" +
					trabalhador.getCpf() + "', \"Avaliação\" = '" + trabalhador.getAvaliacao() + "', \"Local\" = '" + trabalhador.getLocal() + "' WHERE \"ID\" = '" +
					trabalhador.getId() + "';";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	//remove um elemento da tabela
	public boolean remove(Trabalhador trabalhador)
	{
		boolean status = false;
		try
		{  
			String sql = "DELETE FROM \"Trabalhador\" WHERE \"ID\" = '" + trabalhador.getId() + "';";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	//recupera um elemento da tabela
	public Trabalhador get(int id)
	{
		Trabalhador trabalhador = null;
		try
		{
			String sql = "SELECT * FROM \"Trabalhador\" WHERE \"ID\"='" + id + "';";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			trabalhador = new Trabalhador(rs.getInt("ID"), rs.getString("Email"), rs.getString("Telefone"), rs.getString("Login"), rs.getString("Senha"), rs.getBoolean("Premium"), rs.getString("Nome"), rs.getString("Sobrenome"),
					rs.getString("CPF"), rs.getString("Avaliação"), rs.getString("Local"));
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return trabalhador;
	}
	
	//lista todos os elementos da tabela
	public Trabalhador[] listar()
	{
		Trabalhador[] trabalhadores = null;
		try
		{
			String sql = "SELECT * FROM \"Trabalhador\";";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				rs.last();
				trabalhadores = new Trabalhador[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0;rs.next();i++)
				{
					trabalhadores[i] = new Trabalhador(rs.getInt("ID"), rs.getString("Email"), rs.getString("Telefone"), rs.getString("Login"), rs.getString("Senha"), rs.getBoolean("Premium"), rs.getString("Nome"), rs.getString("Sobrenome"),
							rs.getString("CPF"), rs.getString("Avaliação"), rs.getString("Local"));
				}
				st.close();
			}
	
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return trabalhadores;
	}
}
