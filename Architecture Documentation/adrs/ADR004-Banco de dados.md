## Versions

| Author                   | Date         | Version  | Update             | 
| ------------------------ | ------------ | -------- | ------------------ |
| Jardel Back Kuhnen       | 05/11/2021   | 1.0      | Created the ADR.   |

## Status
accepted

## Context
Necessidade de armazenamento em um repositório de dados, que será consumido pela aplicação e futuramente por algum tipo
de tecnologia capaz de realizar análise de dados.

## Decision
Será adotado banco de dados NoSql, e para esse tipo de banco utilizaremos o MongoDB.

## Consequences Positive
Facilidade na modelagem de dados. 
Facilidade no compartilhamento de dados com aplicações terceiras.
Baixa laténcia na leitura de dados.
Possibilidade na criação de clusters para realizar escala horizontal. 
Banco de dados muito conhecido na comunidade. 
Possibilidade de utilização de serviços paas para nosql.

## Consequences Negative
Desconhecimento da equipe em utilização de banco NoSql.
Caso ao longo do tempo o projeto venha a possuir grande relacionamento ou correlação entre os dados possa ser necessário 
utilização de sql.

## Tags
Baylei, pet, sql, nosql, mongodb
