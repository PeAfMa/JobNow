package service;


import dao.TrabalhadorDAO;
import model.Trabalhador;
import spark.Request;
import spark.Response;

public class TrabalhadorService
{
	private TrabalhadorDAO trabalhadorDAO = new TrabalhadorDAO();
	private static int lastId = 100;
	
	
	public Object inserir(Request request, Response response)
	{
		lastId ++;
		String email = request.queryParams("email");
		String telefone = request.queryParams("telefone");
		String login = request.queryParams("login");
		String senha = request.queryParams("senha");
		boolean premium = false;
		String nome = request.queryParams("nome");
		String sobrenome = request.queryParams("sobrenome");
		String CPF = request.queryParams("CPF");
		String avaliacao = "";
		String local = request.queryParams("local");
		Trabalhador trabalhador = new Trabalhador(lastId, email, telefone, login, senha, premium, nome, sobrenome, CPF, avaliacao, local);
		trabalhadorDAO.insert(trabalhador);
		response.status(201);
		response.redirect("http://127.0.0.1:5502/index.html");
		return ("Cadastro efetuado");
	}
	
	public Object login(Request request, Response response)
	{
		String userLogin = request.queryParams("login");
		String serverLogin;
		String userSenha = request.queryParams("senha");
		String serverSenha;
		Trabalhador[] trabalhadores = trabalhadorDAO.listar();
		boolean didLogin = false;
		String resposta = "Verifique seu login e senha e tente novamente";
		
		for(int i = 0;i < trabalhadores.length && !didLogin;i++)
		{ 
			serverLogin = trabalhadores[i].getLogin();
			serverSenha = trabalhadores[i].getSenha();
			int logId;
		
			if(userLogin.equals(serverLogin) && userSenha.equals(serverSenha))
			{
				logId = trabalhadores[i].getId();
				didLogin = true;
			
				resposta = perfil(logId);
			}
		}
		
		return resposta;
	}
	
	public Object update(Request request, Response response)
	{
		
		return null;
	}
	
	public String perfil(int logId)
	{
		Trabalhador trabalhador = (Trabalhador) trabalhadorDAO.get(logId);
		String body = "<body>"
				+ "  <nav class= \"navbar navbar-expand-lg\">"
				+ "    <div class=\"container-fluid\">"
				+ "      <a class=\"navbar-brand\" href=\"http://127.0.0.1:5502/\">JobNow</a>"
				+ "      <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">"
				+ "        <span class=\"navbar-toggler-icon\"></span>"
				+ "      </button>"
				+ "      <div class=\"collapse navbar-collapse\" id=\"navbarNav\">"
				+ "        <ul class=\"navbar-nav\">"
				+ "          <li class=\"nav-item\">"
				+ "            <a class=\"nav-link active\" aria-current=\"page\" href=\"http://127.0.0.1:5502/index.html\">Home</a>"
				+ "          </li>"
				+ "          <li class=\"nav-item\">"
				+ "            <a class=\"nav-link\" href=\"#\">Quem somos</a>"
				+ "          </li>"
				+ "          <li class=\"nav-item\">"
				+ "            <a class=\"nav-link\" href=\"#\">Contato</a>"
				+ "          </li>"
				+ "          <li class=\"nav-item\">"
				+ "            <a class=\"nav-link\" href=\"http://127.0.0.1:5502/premium.html\">Premium</a>"
				+ "          </li>"
				+ "        </ul>"
				+ "      </div>"
				+ "    </div>"
				+ "  </nav>"
				+ "  <div class=\"container-b\">"
				+ "    <div class=\"row\">"
				+ "      <div class=\"col-0 col-lg-1\"></div>"
				+ "      <div class=\"col-lg-4 col-12\">"
				+ "        <div class=\"card-perfil\" style=\"width: 18rem;\">"
				+ "          <div class=\"card-body\">"
				+ "            <h5 class=\"card-title\" name=\"nome\">" + trabalhador.getNome() + "</h5>"
				+ "            <h6 class=\"card-subtitle mb-2\">Trabalhador</h6>"
				+ "            <p class=\"card-text-perfil\">Avaliações: " + trabalhador.getAvaliacao() + "/ 5</p>"
				+ "            <p class=\"card-text-perfil\">Local: " + trabalhador.getLocal() + "</p>"
				+ "            <a href=\"http://127.0.0.1:5502/alterarPerfilTrab.html\" class=\"card-link-perfil\">Alterar Perfil</a>"
				+ "          </div>"
				+ "        </div>"
				+ "      </div>"
				
				
				
				
				+ "      <div class=\"col-lg-6 col-12\">"
				+ "        <div class=\"card-opcoes\" style=\"width: 30rem;\">"
				+ "          <div class=\"card-body\">"
				+ "            <h5 class=\"card-title-opcoes\">Opções de Serviços</h5>"
				+ "            <div class=\"row\">"
				+ "              <div class=\"col-2\">"
				+ "                <a href=\"http://127.0.0.1:5502/trabalho.html\"><button type=\"button\" class=\"button_opcoes btn btn-light\">Faxina</button></a>"
				+ "                <a href=\"http://127.0.0.1:5502/trabalho2.html\"><button type=\"button\" class=\"button_opcoes btn btn-light\">Pintor</button></a>"
				+ "                <button type=\"button\" class=\"button_opcoes btn btn-light\">-</button>"
				+ "              </div>"
				+ "              <div class=\"col-4\">"
				+ ""
				+ "              </div>"
				+ "              <div class=\"col-2\">"
				+ "                <button type=\"button\" class=\"button_opcoes btn btn-light\">-</button>"
				+ "                <button type=\"button\" class=\"button_opcoes btn btn-light\">-</button>"
				+ "                <button type=\"button\" class=\"button_opcoes btn btn-light\">-</button>"
				+ "              </div>"
				+ "            </div>"
				+ "            <a href=\"http://127.0.0.1:5502/trabalhoFavorito.html\" class=\"card-link-perfil\">Favoritos</a>"
				+ "          </div>"
				+ "        </div>"
				+ "      </div>"
				+ "      <div class=\"col-lg-1 col-0\">"
				+ "      </div>"
				+ "    </div>"
				+ "  </div>"
				+ "    "
				+ "";
		return header() + body;
	}
	
	public String header()
	{
		return "<!DOCTYPE html>"
				+ "<html lang=\"en\">"
				+ "<head>"
				+ "  <meta charset=\"UTF-8\">"
				+ "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
				+ "  <title>Home Empregador</title>"
				+ "  <link rel=\"stylesheet\" href=\"http://127.0.0.1:5502/styles.css\">"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">"
				+ "</head>"
				+ "  <footer class=\"footer\">"
				+ "    <img class=\"puc\" src=\"http://127.0.0.1:5502/imagens/Brasao PUC Minas aplicacao_cinza.png\">"
				+ "    <p style=\"text-align: center;\">2022 JobNow - Todos os direitos reservados</p>"
				+ "  </footer>"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3\" crossorigin=\"anonymous\"></script>"
				+ "</body>"
				+ "</html>";
	}
}