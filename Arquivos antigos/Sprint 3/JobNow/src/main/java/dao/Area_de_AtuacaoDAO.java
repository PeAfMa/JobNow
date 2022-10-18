package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Area_de_Atuacao;

public class Area_de_AtuacaoDAO extends DAO
{
	//Inicia a conexão com o postgres
	public Area_de_AtuacaoDAO()
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
	public boolean insert(Area_de_Atuacao AdA)
	{
		boolean status = false;
		try
		{
			String sql = "INSERT INTO \"Area de Atuacao\" (\"Trabalhador\", \"ID\") VALUES ('" +
					AdA.getTrabalhador() + "', '" + AdA.getId() + "');";
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
	public boolean update(Area_de_Atuacao AdA)
	{
		boolean status = false;
		try
		{  
			String sql = "UPDATE \"Area de Atuacao\" SET \"Trabalhador\" = '" + AdA.getTrabalhador() + "', \"ID\" = '" + AdA.getId() + "';";
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
		public boolean remove(Area_de_Atuacao AdA)
		{
			boolean status = false;
			try
			{  
				String sql = "DELETE FROM \"Area de Atuacao\" WHERE \"ID\" = '" + AdA.getId() + "';";
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
	public Area_de_Atuacao get(int Trabalhador, int ID)
	{
		Area_de_Atuacao AdA = null;
		try
		{
			String sql = "SELECT * FROM \"Area de Atuacao\" WHERE \"Trabalhador\" = '" + Trabalhador + "' AND \"ID\" = '"  + ID + "';";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			AdA = new Area_de_Atuacao(rs.getInt("Trabalhador"), rs.getInt("ID"));
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return AdA;
	}
	
	//lista todos os elementos da tabela
	public Area_de_Atuacao[] listar()
	{
		Area_de_Atuacao[] AdAs = null;
		try
		{
			String sql = "SELECT * FROM \"Area de Atuacao\";";
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				rs.last();
				AdAs = new Area_de_Atuacao[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0;rs.next();i++)
				{
					AdAs[i] = new Area_de_Atuacao(rs.getInt("Trabalhador"), rs.getInt("ID"));
				}
				st.close();
			}
	
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return AdAs;
	}
}
