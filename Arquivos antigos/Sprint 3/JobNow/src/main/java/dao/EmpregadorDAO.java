package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Empregador;

public class EmpregadorDAO extends DAO
{
	//Inicia a conexão com o postgres
	public EmpregadorDAO()
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
	public boolean insert(Empregador empregador)
	{
		boolean status = false;
		try
		{
			String sql = "INSERT INTO \"Empregador\" (\"ID\", \"Email\", \"Telefone\", \"Login\", \"Senha\", \"Premium\", \"Nome\", \"Sobrenome\", \"CPF/CNPJ\", \"Avaliação\", \"Recomendação\") VALUES ('" +
					empregador.getId() + "', '" + empregador.getEmail() + "', '" +  empregador.getTelefone() + "', '" + empregador.getLogin() + "', '" + empregador.getSenha() + "', '" + empregador.getPremium() +
					"', '" + empregador.getNome() + "', '" + empregador.getSobrenome() + "', '" + empregador.getCpf_cnpj() + "', '" + empregador.getAvaliacao() + "', '" + empregador.getRecomendacao() + "');";
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
	
	//atualiza um elemento na tabela
	public boolean update(Empregador empregador)
	{
		boolean status = false;
		try
		{  
			String sql = "UPDATE \"Empregador\" SET \"Email\" = '" + empregador.getEmail() + "', \"Telefone\" = '" + empregador.getTelefone() + "', \"Login\" = '" + empregador.getLogin() + "', \"Senha\" = '" +
					empregador.getSenha() + "', \"Premium\" = '" + empregador.getPremium() + "', \"Nome\" = '" + empregador.getNome() + "', \"Sobrenome\" = '" + empregador.getSobrenome() + "', \"CPF/CNPJ\" = '" +
					empregador.getCpf_cnpj() + "', \"Avaliação\" = '" + empregador.getAvaliacao() + "', \"Recomendação\" = '" + empregador.getRecomendacao() +"' WHERE \"ID\" = '" +
					empregador.getId() + "';";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	//remove um elemento na tabela
	public boolean remove(Empregador empregador)
	{
		boolean status = false;
		try
		{  
			String sql = "DELETE FROM \"Empregador\" WHERE \"ID\" = '" + empregador.getId() + "';";
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
	public Empregador get(int id)
	{
		Empregador empregador = null;
		try
		{
			String sql = "SELECT * FROM \"Empregador\" WHERE \"ID\"='" + id + "';";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			empregador = new Empregador(rs.getInt("ID"), rs.getString("Email"), rs.getString("Telefone"), rs.getString("Login"), rs.getString("Senha"), rs.getBoolean("Premium"), rs.getString("Nome"), rs.getString("Sobrenome"),
					rs.getString("CPF/CNPJ"), rs.getString("Avaliação"), rs.getInt("Recomendação"));
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return empregador;
	}
	
	//lista todos os elementos da tabela
	public Empregador[] listar()
	{
		Empregador[] empregadores = null;
		try
		{
			String sql = "SELECT * FROM \"Empregador\";";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				rs.last();
				empregadores = new Empregador[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0;rs.next();i++)
				{
					empregadores[i] = new Empregador(rs.getInt("ID"), rs.getString("Email"), rs.getString("Telefone"), rs.getString("Login"), rs.getString("Senha"), rs.getBoolean("Premium"), rs.getString("Nome"), rs.getString("Sobrenome"),
							rs.getString("CPF/CNPJ"), rs.getString("Avaliação"), rs.getInt("Recomendação"));
				}
				st.close();
			}
	
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return empregadores;
	}
}
