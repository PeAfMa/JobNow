package model;

public class Trabalhador
{
	private int id;
	private String email;
	private String telefone;
	private String login;
	private String senha;
	private boolean premium;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String avaliacao;
	private int recomendacao;
	private String local;
	
	//construtores
	public Trabalhador()
	{
		id  = -1;
		email = "";
		telefone = "";
		login = "";
		senha = "";
		premium = false;
		nome = "";
		sobrenome = "";
		cpf = "";
		avaliacao = "";
		recomendacao = -1;
		local = "";
	}
	public Trabalhador(int id, String email, String telefone, String login, String senha, boolean premium, String nome,
			String sobrenome, String cpf, String avaliacao, int recomendacao, String local)
	{
		this.id = id;
		this.email = email;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		this.premium = premium;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.avaliacao = avaliacao;
		this.recomendacao = recomendacao;
		this.local = local;
	}
	
	//gets e sets
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getTelefone()
	{
		return telefone;
	}
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	public String getLogin()
	{
		return login;
	}
	public void setLogin(String login)
	{
		this.login = login;
	}
	public String getSenha()
	{
		return senha;
	}
	public void setSenha(String senha) 
	{
		this.senha = senha;
	}
	public boolean getPremium()
	{
		return premium;
	}
	public void setPremium(boolean premium)
	{
		this.premium = premium;
	}
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getSobrenome()
	{
		return sobrenome;
	}
	public void setSobrenome(String sobrenome)
	{
		this.sobrenome = sobrenome;
	}
	public String getCpf()
	{
		return cpf;
	}
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}
	public String getAvaliacao()
	{
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao)
	{
		this.avaliacao = avaliacao;
	}
	public int getRecomendacao()
	{
		return recomendacao;
	}
	public void setRecomendacao(int recomendacao)
	{
		this.recomendacao = recomendacao;
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
		return "Trabalhador [id=" + id + ", email=" + email + ", telefone=" + telefone + ", login=" + login + ", senha="
				+ senha + ", premium=" + premium + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf
				+ ", avaliacao=" + avaliacao + ", recomendacao=" + recomendacao + ", local=" + local + "]";
	}
}
