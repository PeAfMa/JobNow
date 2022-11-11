package model;

public class Empregador
{
	private int id;
	private String email;
	private String telefone;
	private String login;
	private String senha;
	private boolean premium;
	private String nome;
	private String sobrenome;
	private String cpf_cnpj;
	private String avaliacao;
	
	//construtores
	public Empregador()
	{
		id  = -1;
		email = "";
		telefone = "";
		login = "";
		senha = "";
		premium = false;
		nome = "";
		sobrenome = "";
		cpf_cnpj = "";
		avaliacao = "";
	}
	public Empregador(int id, String email, String telefone, String login, String senha, boolean premium, String nome,
			String sobrenome, String cpf_cnpj, String avaliacao)
	{
		this.id = id;
		this.email = email;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		this.premium = premium;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf_cnpj = cpf_cnpj;
		this.avaliacao = avaliacao;
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
	public String getCpf_cnpj()
	{
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj)
	{
		this.cpf_cnpj = cpf_cnpj;
	}
	public String getAvaliacao()
	{
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao)
	{
		this.avaliacao = avaliacao;
	}
	@Override
	public String toString() {
		return "Empregador [id=" + id + ", email=" + email + ", telefone=" + telefone + ", login=" + login + ", senha="
				+ senha + ", premium=" + premium + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpf_cnpj="
				+ cpf_cnpj + ", avaliacao=" + avaliacao + "]";
	}
}
