package model;

public class Contrata
{
	private int trabalhador;
	private int empregador;
	private boolean pago;
	private String local;
	
	//construtores
	public Contrata()
	{
		trabalhador = -1;
		empregador = -1;
		pago = false;
		local = "";
	}
	public Contrata(int trabalhador, int empregador, boolean pago, String local)
	{
		this.trabalhador = trabalhador;
		this.empregador = empregador;
		this.pago = pago;
		this.local = local;
	}
	
	//gets e sets
	public int getTrabalhador()
	{
		return trabalhador;
	}
	public void setTrabalhador(int trabalhador)
	{
		this.trabalhador = trabalhador;
	}
	public int getEmpregador()
	{
		return empregador;
	}
	public void setEmpregador(int empregador)
	{
		this.empregador = empregador;
	}
	public boolean getPago()
	{
		return pago;
	}
	public void setPago(boolean pago)
	{
		this.pago = pago;
	}
	public String getLocal()
	{
		return local;
	}
	public void setLocal(String local)
	{
		this.local = local;
	}
	@Override
	public String toString() {
		return "Contrata [trabalhador=" + trabalhador + ", empregador=" + empregador + ", pago=" + pago + ", local="
				+ local + "]";
	}

	
}
