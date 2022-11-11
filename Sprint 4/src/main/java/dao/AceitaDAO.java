package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Aceita;

public class AceitaDAO extends DAO
{
	//Inicia a conexão com o postgres
	public AceitaDAO()
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
	public boolean insert(Aceita aceita)
	{
		boolean status = false;
		try
		{
			String sql = "INSERT INTO \"Aceita\" (\"Ordem de Serviço_ID\", \"Ordem de Serviço_Empregador\", \"Trabalhador\", \"Pago\") VALUES ('" +
					aceita.getOrdemDeServico_ID() + "', '" + aceita.getOrdemDeServico_Empregador() + "', '" +  aceita.getTrabalhador() + "', '" + aceita.getPago() + "');";
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
	public boolean update(Aceita aceita)
	{
		boolean status = false;
		try
		{  
			String sql = "UPDATE \"Aceita\" SET \"Ordem de Serviço_ID\" = '" + aceita.getOrdemDeServico_ID() + "', \"Ordem de Serviço_Empregador\" = '" + aceita.getOrdemDeServico_Empregador() + "', \"Trabalhador\" = '" + aceita.getTrabalhador() + "', \"Pago\" = '" +
					aceita.getPago() + "';";
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
	public boolean remove(Aceita aceita)
	{
		boolean status = false;
		try
		{  
			String sql = "DELETE FROM \"Aceita\" WHERE \"Ordem de Serviço_ID\" = '" + aceita.getOrdemDeServico_ID() + "' AND \"Ordem de Serviço_Empregador\" = '"  + aceita.getOrdemDeServico_Empregador() + "' AND \"Trabalhador\" = '" + aceita.getTrabalhador() + "';";
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
	public Aceita get(int OSID, int OSE,  int Trabalhador)
	{
		Aceita aceita = null;
		try
		{
			String sql = "SELECT * FROM \"Aceita\" WHERE \"Ordem de Serviço_ID\" = '" + OSID + "' AND \"Ordem de Serviço_Empregador\" = '"  + OSE + "' AND \"Trabalhador\" = '" + Trabalhador + "';";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			aceita = new Aceita(rs.getInt("Ordem de Serviço_ID"), rs.getInt("Ordem de Serviço_Empregador"), rs.getInt("Trabalhador"), rs.getBoolean("Pago"));
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return aceita;
	}
	
	//lista todos os elementos da tabela
	public Aceita[] listar()
	{
		Aceita[] aceitaes = null;
		try
		{
			String sql = "SELECT * FROM \"Aceita\";";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				rs.last();
				aceitaes = new Aceita[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0;rs.next();i++)
				{
					aceitaes[i] = new Aceita(rs.getInt("Ordem de Serviço_ID"), rs.getInt("Ordem de Serviço_Empregador"), rs.getInt("Trabalhador"), rs.getBoolean("Pago"));
				}
				st.close();
			}
	
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return aceitaes;
	}
}
