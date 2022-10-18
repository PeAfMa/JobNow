package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Ordem_de_Servico;

public class Ordem_de_ServicoDAO extends DAO
{
	//Inicia a conexão com o postgres
	public Ordem_de_ServicoDAO()
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
	public boolean insert(Ordem_de_Servico OdS)
	{
		boolean status = false;
		try
		{
			String sql = "INSERT INTO \"Ordem de Servico\" (\"Empregador\", \"ID\", \"Local\", \"Trabalho\", \"Preço\") VALUES ('" +
					OdS.getEmpregador() + "', '" + OdS.getId() + "', '" +  OdS.getLocal() + "', '" + OdS.getTrabalho() + "', '" + OdS.getPreco() + "');";
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
	public boolean update(Ordem_de_Servico OdS)
	{
		boolean status = false;
		try
		{  
			String sql = "UPDATE \"Ordem de Servico\" SET \"Local\" = '" + OdS.getLocal() + "', \"Trabalho\" = '" + OdS.getTrabalho() + "', \"Preço\" = '" + OdS.getPreco() +"' WHERE \"ID\" = '" +
					OdS.getId() + "';";
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
	public boolean remove(Ordem_de_Servico OdS)
	{
		boolean status = false;
		try
		{  
			String sql = "DELETE FROM \"Ordem de Servico\" WHERE \"ID\" = '" + OdS.getId() + "';";
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
	public Ordem_de_Servico get(int id)
	{
		Ordem_de_Servico OdS = null;
		try
		{
			String sql = "SELECT * FROM \"Ordem de Servico\" WHERE \"ID\"='" + id + "';";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			OdS = new Ordem_de_Servico(rs.getInt("Empregador"), rs.getInt("ID"), rs.getString("Local"), rs.getString("Trabalho"), rs.getDouble("Preço"));
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return OdS;
	}
	
	//lista todos os elementos da tabela
	public Ordem_de_Servico[] listar()
	{
		Ordem_de_Servico[] OdSs = null;
		try
		{
			String sql = "SELECT * FROM \"Ordem de Servico\";";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				rs.last();
				OdSs = new Ordem_de_Servico[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0;rs.next();i++)
				{
					OdSs[i] = new Ordem_de_Servico(rs.getInt("Empregador"), rs.getInt("ID"), rs.getString("Local"), rs.getString("Trabalho"), rs.getDouble("Preço"));
				}
				st.close();
			}
	
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return OdSs;
	}
}
