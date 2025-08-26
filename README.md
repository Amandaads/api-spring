##                   API DE FILMES 
Está é uma api de filmes, você é capaz de cadastrar, listar, atualizar e deletar filmes.

## Funcionalidades
- OBS: Para status de filmes temos "**EM_ANDAMENTO**" "**FAVORITADO**" "**CONCLUIDA**"
- 2 rotas GET - (get all e get id)
- 1 rota POST 
- 1 rota PUT 
- 1 rota DELETE

https://web.postman.co/workspace/Teste-api~b87dec64-8a67-4edf-91ee-d98743cb9176/collection/42651028-510307f1-1622-4196-8e6d-03143883593e?action=share&source=copy-link&creator=42651028


## Rodando os testes

Para testar a api, há 2 formas e também tem como consultar o banco de dados em memória h2
 
- Postman - **Necessário ter o aplicativo instalado** -
    Para auxilio segue exportação da collection criada com rotas no Postman, basta importar para seu próprio app 
    [📥 Baixar coleção Postman](apiProduct/src/main/docs/API_FILME.postman_collection.json)

    > Certifique-se de estar na mesma rede da aplicação (localhost) para que as requisições funcionem corretamente.

- Swagger - com a rota http://localhost:8080/swagger-ui.html
- Consultar via H2






## Aprendizados

Esta API foi construida para a matéria de desenvolvimento web-backend, ao longo das aulas fomos instruidos e ensinados a desenvolver, de modo básico, mas muito enriquecedor.



## Melhorias

Ao longo da construção da API, achei interessante implementar swagger como forma de documentação e a visualização de testes serem mais amigaveis. E uma melhoria futura implementar um front-end.




