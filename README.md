# API-Tarefas
API Rest, em JAVA com Spring Boot,  Spring Data JPA e MySQL, documentação feita com Postman

#CRIAÇÂO DE TAREFA
- ENDPOINT
Ex: POST - http://localhost:8080/api/tarefas

JSON de Exemplo, (Body - Raw)
{
  "nome": "Desenvolvimento da API",
  "dataEntrega": "2025-12-12",
  "responsavel": "Lucas - 4732738"
}

#LISTAGEM DE TAREFAS
--Listagem Geral
-ENDPOINT
Ex: GET - http://localhost:8080/api/tarefas

--Listagem Especifica
-ENDPOINT
Ex: GET - http://localhost:8080/api/tarefas/11

#ATUALIZAÇÃO DE INFORMAÇÕES
-ENDPOINT
Ex: PUT - http://localhost:8080/api/tarefas/11

JSON de Exemplo, (Body - Raw)
{
  "nome": "Desenvolvimento da API ( Atualizada )",
  "dataEntrega": "2025-12-12",
  "responsavel": "Lucas - 4732738"
}

#EXCLUSÃO DE TAREFAS
-EDNPOINT
Ex: DELETE - http://localhost:8080/api/tarefas/11
