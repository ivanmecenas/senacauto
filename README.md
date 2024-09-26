### Arquitetura do Projeto

#### Backend - Java

    backend
    	| core
    	|-- src
    	|---- main
    	|------ java/br/com/senacauto
    	|------ resources
    	|---- test
    	|------ java/br/com/senacauto
    	|------ resources
    	| rest
    	|-- src
    	|---- main
    	|------ java/br/com/senacauto
    	|------ resources
    	|------ webapp/WEB-INF
    	|---- test
    	|------ java/br/com/senacauto
    	|------ resources

  

#### Frontend - React

	| frontend
	|-- src
	|---- app
	|------ components
	|-------- menus
	|---------- administrativo
	|---------- agendamento
	|---------- ajustes
	|---------- cadastros
	|---------- meuAgendamento
	|---------- relatorioAgendamento
	|---------- tipoAcesso
	|-------- pages
	|---------- agendamento
	|------------ AtualizarAgendamento
	|------------ CriarAgendamento
	|------------ OrganizarAgendamento
	|---------- login
	|------------ Login
	|------------ NovoUsuario
	|------------ RecuperarSenha
	|---------- meuAgendamento (transporte)
	|------------ SolicitarMeuAgendamento (transporte)
	|------------ CancelarMeuAgendamento (transporte)
	|---------- perfil
	|------------ AjustarPerfil
	|------------ CadastrarPerfil
	|---------- pessoa
	|------------ AjustarPessoa
	|------------ CadastrarPessoa
	|--------- relatorio
	|------------ ConsumoCombustivel
	|------------ HistoricoAgendamento
	|------------ UsoVeiculo
	|---------- sistema
	|------------ SplashScreen
	|---------- Configuracao
	|---------- veiculo
	|------------ AjustarVeiculo
	|------------ CadastrarVeiculo
	|---- assets
	|------ images
	|-------- png
	|-------- svg
	|------ styles

  
  


### Como subir o banco de dados MySql no Docker

#### Baixar a imagem do docker hub
	docker pull mysql/mysql-server

#### Subir o MySql com base na imagem baixada (só executar se não tiver nenhum container do banco criado, em qualquer status)

	docker run -d --name mysql -e MYSQL_USER=root -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=senacauto_db -p 3306:3306 mysql/mysql-server

#### Será criado um container docker com nome mysql, o sistema está apontando para esse alias. Para saber se o container está executando, digite:

	docker ps -a

##### vai listar todos os containers docker em execução

#### Para parar o banco no docker

	docker stop mysql

#### Para subir o banco no docker

	docker start mysql
