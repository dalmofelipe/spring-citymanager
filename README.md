# spring-citymanager

Projeto apresentado na Academia Java Microsserviços.

Vamos escrever um sistema capaz de gerenciar um município.

Nosso MVP sera pautado em trés funcionalidades principais: o gerenciamento de secretarias, projetos e orçamentos.

### Orçamento 

```
Budget
id(PK), 
totalAmount, -> Valor total da entrada de recurso; 
spentAmount, -> Valor já comprometido dessa entrada;
possibleDestinations, -> Lista com os possíveis destinos desse recurso ENUM FOLDER -> ver secretaria; 
origin; -> Origem (ENUM: FEDERAL, STATE, COUNTY)
```

**POST /budgets** - Cria um orcamento validando todos os campos não nulos e brancos.

**GET /budgets** - Lista todos os recursos disponíveis. E possível filtrar por possibleDestinations;

**PATCH /budgets/{id}/expense** - Registra um uso daquele orcamento (acrescenta no spentAmount caso seja menor do que a diferença (total - spent).

### Secretarias

```
Secretariat
id(PK),
folder, -> unique Folder (ENUM: HEALTH, EDUCATION, SPORTS, INFRASTRUCTURE... etc) 
secretary, -> nome do(a) secretario(a)
populationGrade, -> valor numérico correspondente 4 uma nota da população pra aquela secretaria 
underInvestigation -> valor booleano que torna uma secretaria impossibilitada de executar projetos
```

**POST /secretariats** - Cria uma secretaria, validando se já existe uma com a mesma pasta e os demais campos que não devem ser nulos ou brancos.

**GET /secretariats** - Lista todas as secretarias

**GET /secretariats/{id}** - Busca uma secretaria pelo id

**PATCH /secretariats/{id}/investigation** - Altera o atributo underInvestigation.

Após implementar os dois primeiros microsserviços, você precisa modelar um para tratar dos projetos, considere as seguintes premissas.

- Um projeto deve pertencer 4 uma secretaria existente e que não esteja sob investigação,
- Um projeto sé pode ser aprovado caso haja orcamento disponível para executá-lo, orçamento este que deve ser de uma pasta condizente com a do projeto;
- O gasto com o projeto devera ser contabilizado do DB do MS de Orcamento

### Projeto 

```
Project
id(PK),
secretariatld,
cost, -> Custo do projeto
title, -> Titulo do projeto
description, -> O que o projeto fara
folder -> em que pasta sera incluído aquele projeto.
```

O exercício sera contemplado de forma satisfatória quando for possível registrar um projeto seguindo todas as premisses e os seguintes

requisitos forem cumpridos:

- Anexe em seu repositório, um desenho da comunicação entre esses microsserviços. - Documente todas as APIs com Swagger. - Implemente autenticação com JWT em todas as APIs.
- Crie uma collection no cliente HTTP (Postman) que for usado e 0 anexe em seu repositório.
- Cubra com testes unitários pelo menos 50% da sua camada de serviço.

### Dicas:

- Use o banco relacional de sua preferência - Nem todas as chamadas precisam ser síncronas
- Caso conheça você pode usar alguma estratégia assíncrona de comunicação, caso contrario, as chamadas REST conseguem resolver.
- Você pode criar outro MS para orquestrar a comunicação caso julgue necessário.
