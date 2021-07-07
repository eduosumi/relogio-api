Descriçao: Api rest com um crud de relogio armazenando em um database H2 (POST / PUT / DELETE / GET), realizando uma comunicaçao com outra api rest (enderecos das marcas de relogios)
 - H2
 - Java
 - Swagger
 - Spring Boot / Data
 - Jackson

Descricao Api Externa: Realizo uma comunicaçao com outra api rest externa, porem esta de forma mockada para nao criar dependencia.
Api externa: GET URI_HOST/marcas/{codigo}/enderecos

Outras Informaçoes: 
 - possui testes unitarios;
 - possui uma estrutura de possiveis status do protocolo http;
 - Inicialmente só possui teste unitario na classe de serviço, porem todos os testes realizados podem ser executados no RelogioApplicationTest.java.
