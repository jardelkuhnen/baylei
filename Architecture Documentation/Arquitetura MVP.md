# Arquitetura Prevista

##### Para definir a arquitetura do MVP, foram utilizados alguns critérios, sendo eles: 
 
 - Qual a quantidade de transações estimadas para a aplicação em um ambiente normal?
	Está prevista uma transação por segundo.
 - Em que tipo de dispositivo o usuário utilizará inicialmente a aplicação? 
	Inicialmente será utilizado via navegador web.
 - Como será realizado o deploy da aplicação?
	Aplicação com conceito cloud native.
- Qual arquitetura será adotada para o MVP? 
 	Será adotado cliente servidor, onde terá um serviço backend monolítico disponibilizando as apis que serão consumidas pela aplicação frontend.	

Abaixo segue desenho explicativo dos componentes que compõe a aplicação:

![alt text](images/components%20diagram.png)

 
## Frontend
Será desenvolvido utilizando a lib ReactJs. Frontend irá consumir as apis produzidas pela aplicação backend, através de comunicação http.
O deploy da aplicação será realizado em um ambiente Kubernetes. O ambiente kubernetes poderá ser criado em algum provedor de nuvem. 


## Backend
Será desenvolvido utilizando a linguagem Java, utilizando o framework Spring pra construção das apis.
Os deploys serão realizados em um ambiente Kubernetes.
Toda comunicação com a api será realizada via http.
Como banco de dados será utilizando uma instancia de MongoDb.


## Requisitos Funcionais
 O sistema deve possuir cadastro de cliente
 O sistema deve possuir cadastro de planos de promoções
 O sistema deve possuir cadastro de produtos
 O sistema deve possuir cadastro de configurações
 O sistema deve possuir cadastro de venda dos produtos
 O sistema deve possuir relatórios de vendas, estoque e previsão de vendas
 
 
## Requisitos não funcionais
 O tempo para os cadastros não deve exceder 1 segundo
 O o TMR (Tempo médio de Resposta) não deve exceder 10 segundos para venda
 O sistema deve ter uma interface amigável com usuario, facilitando assim a usabilidade do mesmo
 O sistema deve armazenar os dados de clientes, produtos e vendas por pelo menos 2 anos afim de ter base histórica
 O sistema deve atender as normas da LGPD, pois armazena dados sensíveis de usuários
 O sistema deve estar disponível 99.9% do tempo
 
 
## Arquitetura Proposta

Para este projeto, visando a qualidade inicial bem como a evolução do projeto e de suas dependencias ao longo do tempo, 
será utilizado a arquitetura hexagonal como padrão da aplicação.

![ScreenShot](images/hexagonal-architecture.png)