const inputField = document.getElementById("input");
inputField.addEventListener("keydown", (e) => {
  if (e.code === "Enter") {
    let input = inputField.value;
    inputField.value = "";
    output(input);
  }
});

function output(input) {
  let product;
  let text = input.toLowerCase().replace(/[^\w\s\d]/gi, "");
  text = text
    .replace(/ a /g, " ")
    .replace(/whats/g, "what is")
    .replace(/please /g, "")
    .replace(/ please/g, "")
    .replace(/r u/g, "are you");

  if (compare(utterances, answers, text)) {
    // Search for exact match in triggers
    product = compare(utterances, answers, text);
  } 
  else {
    product = alternatives[Math.floor(Math.random() * alternatives.length)];
  }

  addChatEntry(input, product);
}

function compare(utterancesArray, answersArray, string) {
  let reply;
  let replyFound = false;
  for (let x = 0; x < utterancesArray.length; x++) {
    for (let y = 0; y < utterancesArray[x].length; y++) {
      if (utterancesArray[x][y] === string) {
        let replies = answersArray[x];
        reply = replies[Math.floor(Math.random() * replies.length)];
        replyFound = true;
        break;
      }
    }
    if (replyFound) {
      break;
    }
  }
  return reply;
}

function addChatEntry(input, product) {
  const messagesContainer = document.getElementById("messages");
  let userDiv = document.createElement("div");
  userDiv.id = "user";
  userDiv.className = "user response";
  userDiv.innerHTML = `<span>${input}</span>`;
  messagesContainer.appendChild(userDiv);

  let botDiv = document.createElement("div");
  let botText = document.createElement("span");
  botDiv.id = "bot";
  botDiv.className = "bot response";
  botText.innerText = "Typing...";
  botDiv.appendChild(botText);
  messagesContainer.appendChild(botDiv);

  messagesContainer.scrollTop =
    messagesContainer.scrollHeight - messagesContainer.clientHeight;

  setTimeout(() => {
    botText.innerText = `${product}`;
  }, 2000);
}

// input options
const utterances = [
 
    ["como voce esta", "Como esta", "como esta", "como voce esta"],
    ["hi", "Ola", "ola", "bom dia", "boa tarde", "boa noite", "oi"],
   
    ["quem e voce"],
    
   
    ["tudo bem?", "tudo bem"],
    ["login", "como fazer login", "funciona", "instruções","instrucoes","instruçoes", "site", "Login"],
    ["trabalhador", "Trabalhador", "emprego"],
    ["empregador", "administrador", "contratador"],
    ["ordem", "ordem de serviço", "ordem de servico"],
    ["perfil"]
    

   
   

  ];
  
  // Possible responses corresponding to triggers
  
  const answers = [
     [
      "Bem... e voce?",
      "Otimo, e voce?",
      "Fantastico, e voce?"
    ],
    [
      "Ola! Sou o chatbot do JobNow! Como posso lhe ajudar?"
    ],
    
    ["Sou o chatbot do JobNow! Como posso lhe ajudar"],

    ["Tudo Sim!."],

   ["primeiramente diga como deseja fazer o login, como empregador ou trabalhador?"],
   ["para fazer login como trabalhador vá para a pagina:http://127.0.0.1:5502/LoginTrab.html e digite seus dados"],
   ["para fazer login como empregador vá para a pagina:http://127.0.0.1:5502/LoginEmp.html e digite seus dados"],
  ["para criar uma ordem de serviço faça login em uma conta como contratador e acesse a pagina: http://127.0.0.1:5502/ordemServico.html"],
  ["para ver seu perfil por favor faça login com sua conta e acesse a pagina: http://127.0.0.1:5502/homeEmpregado.html no caso de trabalhador e  http://127.0.0.1:5502/homeEmpregador.html no caso de empregador"],
  
    
    
    
  
  ];
  
  // Random for any other user input
  
  const alternatives = [
    "Desculpe, nao entendi",
    "Poderia repetir?",
    "Comando não recebido",
    "Tente novamente",
  ];