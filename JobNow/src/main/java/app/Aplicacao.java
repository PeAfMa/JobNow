package app;

import static spark.Spark.*;
import org.apache.log4j.BasicConfigurator;
import service.EmpregadorService;
import service.TrabalhadorService;

public class Aplicacao
{
	private static TrabalhadorService trabalhadorService = new TrabalhadorService();
	private static EmpregadorService empregadorService = new EmpregadorService();
	
	public static void main(String[] args)
	{
		BasicConfigurator.configure();
		port(5501);
		post("/LoginTrab.html", (request, response) -> trabalhadorService.login(request, response));
		post("/CadastroTrab.html", (request, response) -> trabalhadorService.inserir(request, response));
		post("/CadastroEmp.html", (request, response) -> empregadorService.inserir(request, response));
	}
}





