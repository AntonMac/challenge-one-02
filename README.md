![thumbnail-Desafio One](https://i.imgur.com/p89udMN.jpeg)




---

# Desafio

Desenvolver um Conversor de Moedas que ofereça interação textual (via console) com os usuários, proporcionando, no mínimo, 6 opções distintas de conversões de moedas em um menu. A taxa de conversão não será estática, mas sim dinamicamente obtida por meio de uma API, garantindo dados precisos e em tempo real para uma experiência mais atualizada e eficaz.

## Objetivos do projeto

- Consumo da API;
- Análise da Resposta JSON;
- Filtro de Moedas;
- Exibição de Resultados aos Usuários;

## Stack de Desenvolvimento

- JDK 17
- Apache Netbeans IDE
- Gson library
- [Exchangerate API](https://www.exchangerate-api.com/)

## Funcionalidades do [Conversor de Moedas - AM - V1.0]

- Da 1ª a 6ª para atender aos requisitos do Desafio, executam conversões pré-definidas. Onde é apenas preciso selecionar a opção e digitar o valor a ser convertido.
    1. Peso argentino(ARS) => Boliviano boliviano (BOB)
    2. Boliviano boliviano (BOB) => Peso argentino(ARS)
    3. Real brasileiro(BRL) => Peso chileno (CLP)
    4. Peso chileno (CLP) => Real brasileiro(BRL)
    5. Peso colombiano (COP) => Dólar americano(USD)
    6. Dólar americano(USD) => Peso colombiano (COP)

- 7ª Apresenta uma Lista de Códigos de Moedas e Solicita os códigos da moeda Base e Alvo. Permitindo uma conversão customizada. Obs. Necessário ter na pasta do Projeto ou onde o arquivo .jar foi buildado o arquivo "Codes-API-BR.txt" que contém a lista.
     7. Listar Todas as Moedas e Escolher por Código

- 8º Exibe o histórico de conversões durante uma sessão de uso.
     8. Mostrar Histórico de Conversões nesta Sessão

- 9º Exportação das conversões feitas para um arquivo csv no formato: "Log_conversoes_[yyyyMMdd_HHmmss].csv"
     9. Exportar Logs de Conversões

- 10ª Essa opção é resultado da maneira como o programa armazena as moedas ao longo do uso para economizar a quota de requisições mensais da API (free acc - 1500). Então, toda vez que uma moeda é selecionada numa sessão, as taxas de câmbio são armazenadas, e caso mais de uma conversão dessa moeda seja feita, não haverá uma nova requisição até o fechamento do app, exceto se solicitar a limpeza do cache de moedas.
    10. Limpar o Cache!
    
- 11ª Fechar o app.
     0. Finalizar

## Observações:

- Lembrar de apontar a classe main do projeto para "ConversorMoedasApp.java" e nas dependências ter instalado o Gson (gson-2.10.1.jar). Neste repo na pasta Dist existe uma versão do jar compilada para Windows 11(Utilize por sua conta e risco). 
- Foi construído pensando em desenvolvimento em camadas, mas não está de maneira completa, pois falta uma camada para persistência de Dados, onde o app poderia Recuperar e ler os logs anteriores, e a Criação de uma Fachada que pudesse ser instanciada corretamente, seja numa CLI ou GUI.
- A chave de acesso da API tem, como dito antes, uma quota muito baixa e sem possibilidade de renovação, é provável que em menos de 20 dias o programa deixe de funcionar, se a chave de acesso não for substituída.

Abraços!

Antonio Macena.

Recife, Abril de 2024
