package service;


import dao.EmpregadorDAO;
import model.Empregador;
import spark.Request;
import spark.Response;

public class EmpregadorService
{
	private EmpregadorDAO empregadorDAO = new EmpregadorDAO();
	private static int id = 100;
	
	public Object inserir(Request request, Response response)
	{
		id ++;
		String email = request.queryParams("email");
		String telefone = request.queryParams("telefone");
		String login = request.queryParams("login");
		String senha = request.queryParams("senha");
		boolean premium = false;
		String nome = request.queryParams("nome");
		String sobrenome = request.queryParams("sobrenome");
		String CPF = request.queryParams("CPF");
		String avaliacao = "";
		Empregador empregador = new Empregador(id, email, telefone, login, senha, premium, nome, sobrenome, CPF, avaliacao);
		empregadorDAO.insert(empregador);
		response.status(201);
		return ("Cadastro efetuado");
	}
}