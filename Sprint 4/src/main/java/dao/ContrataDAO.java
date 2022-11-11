package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Contrata;

public class ContrataDAO extends DAO
{
	//Inicia a conexão com o postgres
	public ContrataDAO()
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
	public boolean insert(Contrata contrata)
	{
		boolean status = false;
		try
		{
			String sql = "INSERT INTO \"Contrata\" (\"Trabalhador\", \"Empregador\", \"Pago\", \"Local\") VALUES ('" +
					contrata.getTrabalhador() + "', '" + contrata.getEmpregador() + "', '" +  contrata.getPago() + "', '" + contrata.getLocal() + "');";
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
	public boolean update(Contrata contrata)
	{
		boolean status = false;
		try
		{  
			String sql = "UPDATE \"Contrata\" SET \"Trabalhador\" = '" + contrata.getTrabalhador() + "', \"Empregador\" = '" + contrata.getEmpregador() + "', \"Pago\" = '" + contrata.getPago() + "', \"Local\" = '" +
					contrata.getLocal() + "';";
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
	public boolean remove(Contrata contrata)
	{
		boolean status = false;
		try
		{  
			String sql = "DELETE FROM \"Contrata\" WHERE \"Trabalhador\" = '" + contrata.getTrabalhador() + "' AND \"Empregador\" = '"  + contrata.getEmpregador() + "';";
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
	public Contrata get(int Trabalhador, int Empregador)
	{
		Contrata contrata = null;
		try
		{
			String sql = "SELECT * FROM \"Contrata\" WHERE \"Trabalhador\" = '" + Trabalhador + "' AND \"Empregador\" = '"  + Empregador + "';";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			contrata = new Contrata(rs.getInt("Trabalhador"), rs.getInt("Empregador"), rs.getBoolean("Pago"), rs.getString("Local"));
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return contrata;
	}
	
	//lista todos os elementos da tabela
	public Contrata[] listar()
	{
		Contrata[] contrataes = null;
		try
		{
			String sql = "SELECT * FROM \"Contrata\";";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				rs.last();
				contrataes = new Contrata[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0;rs.next();i++)
				{
					contrataes[i] = new Contrata(rs.getInt("Trabalhador"), rs.getInt("Empregador"), rs.getBoolean("Pago"), rs.getString("Local"));
				}
				st.close();
			}
	
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return contrataes;
	}
}
