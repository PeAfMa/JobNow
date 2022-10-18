package model;

public class Ordem_de_Servico
{
	private int empregador;
	private int id;
	private String local;
	private String trabalho;
	private double preco;
	
	//construtores
	public Ordem_de_Servico()
	{
		empregador = -1;
		id = -1;
		local = "";
		trabalho = "";
		preco = -1;
	}
	public Ordem_de_Servico(int empregador, int id, String local, String trabalho, double preco)
	{
		this.empregador = empregador;
		this.id = id;
		this.local = local;
		this.trabalho = trabalho;
		this.preco = preco;
	}
	
	//gets e sets
	public int getEmpregador()
	{
		return empregador;
	}
	public void setEmpregador(int empregador)
	{
		this.empregador = empregador;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getLocal()
	{
		return local;
	}
	public void setLocal(String local)
	{
		this.local = local;
	}
	public String getTrabalho()
	{
		return trabalho;
	}
	public void setTrabalho(String trabalho)
	{
		this.trabalho = trabalho;
	}
	public double getPreco()
	{
		return preco;
	}
	public void setPreco(double preco)
	{
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Ordem_de_Servico [empregador=" + empregador + ", id=" + id + ", local=" + local + ", trabalho="
				+ trabalho + ", preco=" + preco + "]";
	}
}
