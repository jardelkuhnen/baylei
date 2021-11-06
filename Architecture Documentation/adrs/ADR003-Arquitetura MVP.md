## Versions

| Author                   | Date         | Version  | Update             | 
| ------------------------ | ------------ | -------- | ------------------ |
| Jardel Back Kuhnen       | 05/11/2021   | 1.0      | Created the ADR.   |

## Status
accepted

## Context
Para que o produto tenha uma longa vida, e que ao longo do tempo seja possível realizar manutenção, de maneira facilitada.
Para isso o produto precisa ter uma arquitetura que seja possível evoluir ao longo do tempo, facilite o desenvolvimento 
de testes e que seja clara aos desenvolvedores.

## Decision
Será adotado a arquitetura Hexagonal;

## Consequences Positive
Facilidade na implementação de testes. 
Facilidade na implementação de coesão de cada componente.
Inversão de dependência, onde o core da aplicação não depende das tecnologias externas utilizadas.
Maior facilidade na troca de tenologia visto que a aplicação é composta por adapters, que podem ser intercambiaveis. 


## Consequences Negative
Curva de aprendizado da equipe a se adaptar na criação dos arquivos necessários para atender aos requisitos da arquitetura.
Inicio da arquitetura se torna um pouco árduo, visto que é necessário realizar a quebra de responsabilidade em cada adapter.

## Tags
Baylei, pet, Architecture, Hexagonal