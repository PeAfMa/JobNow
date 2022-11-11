package model;

public class Aceita
{
	private int ordemDeServico_ID;
	private int ordemDeServico_Empregador;
	private int trabalhador;
	private boolean pago;
	
	//contrutores
	public Aceita()
	{
		ordemDeServico_ID = -1;
		ordemDeServico_Empregador = -1;
		trabalhador = -1;
		pago = false;
	}
	public Aceita(int ordemDeServico_ID, int ordemDeServico_Empregador, int trabalhador, boolean pago) {
		this.ordemDeServico_ID = ordemDeServico_ID;
		this.ordemDeServico_Empregador = ordemDeServico_Empregador;
		this.trabalhador = trabalhador;
		this.pago = pago;
	}
	
	//gets e sets
	public int getOrdemDeServico_ID()
	{
		return ordemDeServico_ID;
	}
	public void setOrdemDeServico_ID(int ordemDeServico_ID)
	{
		this.ordemDeServico_ID = ordemDeServico_ID;
	}
	public int getOrdemDeServico_Empregador()
	{
		return ordemDeServico_Empregador;
	}
	public void setOrdemDeServico_Empregador(int ordemDeServico_Empregador)
	{
		this.ordemDeServico_Empregador = ordemDeServico_Empregador;
	}
	public int getTrabalhador()
	{
		return trabalhador;
	}
	public void setTrabalhador(int trabalhador)
	{
		this.trabalhador = trabalhador;
	}
	public boolean getPago()
	{
		return pago;
	}
	public void setPago(boolean pago)
	{
		this.pago = pago;
	}
	@Override
	public String toString() {
		return "Aceita [ordemDeServico_ID=" + ordemDeServico_ID + ", ordemDeServico_Empregador="
				+ ordemDeServico_Empregador + ", trabalhador=" + trabalhador + ", pago=" + pago + "]";
	}
	
}
