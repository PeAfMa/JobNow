package model;

public class Area_de_Atuacao
{
	private int trabalhador;
	private int id;
	
	//construtores
	public Area_de_Atuacao()
	{
		trabalhador = -1;
		id = -1;
	}
	public Area_de_Atuacao(int trabalhador, int id)
	{
		this.trabalhador = trabalhador;
		this.id = id;
	}
	
	//gets e sets
	public int getTrabalhador() {
		return trabalhador;
	}
	public void setTrabalhador(int trabalhador) {
		this.trabalhador = trabalhador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Area_de_Atuacao [trabalhador=" + trabalhador + ", id=" + id + "]";
	}
}
