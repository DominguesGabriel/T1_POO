# ACMEVoting

## Descrição
O projeto ACMEVoting é um sistema desenvolvido para acompanhar as eleições de prefeitos e vereadores, gerenciando o cadastro de partidos e candidatos, além de registrar os votos recebidos.

## Funcionamento do Programa

1. **Cadastro de Partidos**:
   - O programa solicita a entrada de dados para cada partido, que deve incluir o número e o nome. 
   - O loop de entrada de dados continua até que o usuário digite `-1`, indicando que não há mais partidos a serem cadastrados.

2. **Cadastro de Candidatos**:
   - Após o cadastro dos partidos, o programa solicita a entrada dos dados dos candidatos, que devem incluir o número, nome e município.
   - Assim como no cadastro de partidos, a entrada continua até que o usuário digite `-1`.

3. **Cadastro de Votos**:
   - O sistema permite registrar os votos para candidatos já cadastrados. O usuário deve informar o número do candidato e a quantidade de votos.
   - O loop se encerra com a entrada de `-1`.

4. **Consultas e Relatórios**:
   - O programa também oferece funcionalidades para consultar informações sobre partidos e candidatos, além de mostrar estatísticas de votação.

## Arquivos de Entrada e Saída
- **Arquivo de Entrada (`input.txt`)**:
  - O arquivo `input.txt` deve conter os dados de entrada necessários para o funcionamento do programa. 
  - Cada linha deve seguir os formatos especificados (por exemplo, para partidos: `número,nome`).

- **Arquivo de Saída (`output.txt`)**:
  - Os resultados e informações gerados pelo programa serão gravados no arquivo `output.txt`.

## Testes
- O sistema foi desenvolvido seguindo as especificações do exercício e será testado utilizando o arquivo de entrada. Comparações entre a saída gerada pelo programa e um arquivo de teste serão feitas para validar o funcionamento.

## Como Executar
1. Compile o código Java.
2. Execute a aplicação.
3. Certifique-se de que os arquivos `input.txt` e `output.txt` estejam no mesmo diretório da aplicação.

## Considerações Finais
Este projeto é uma parte do meu aprendizado em Programação Orientada a Objetos e foi desenvolvido com o auxílio do professor Marcelo H. Yamaguti.

