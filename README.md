# HelpTE: Uma Solução para Autistas

## Introdução
Os autistas podem ter dificuldade em identificar, compreender e expressar suas emoções e sentimentos, o que pode resultar em problemas de comunicação e relacionamento. Para ajudar a superar esses desafios, criamos o HelpTE.

## Objetivo
O principal objetivo do projeto é desenvolver uma solução que permita às pessoas autistas reconhecer as emoções expressadas através de uma interface de voz e texto.

## Recursos Utilizados
A solução poderia utilizar os seguintes recursos:

1. **API de Reconhecimento de Fala do Microsoft Azure**: Transforma áudio em texto.
2. **API de Processamento de Linguagem Natural do Microsoft Azure**: Identifica as entradas dos usuários (texto/áudio).
3. **ChatGPT**: Interpreta as emoções contidas na entrada do usuário.
4. **API de Análise de Sentimento do Azure**: Determina o tom emocional das palavras expressas pelos usuários, ajudando a entender melhor suas emoções e sentimentos.

No entanto, por se tratar de uma plataforma paga, optamos em usar ferramentas gratuitas e o ChatGPT, que foi solicitado pela Plusoft.

## Conclusão
Acreditamos estar utilizando da melhor forma o Azure em nosso projeto, dando ênfase nas principais funcionalidades do nosso software. Por se tratar de uma plataforma de nuvem altamente confiável, que oferece uma série de recursos de segurança e privacidade de dados, sentimos confiantes em deixar as funções no servidor.

## Links Úteis
- [Comandos para criação dos documentos no MongoDB](MONGODB.txt)
- [API em SpringBoot para persistencia dos dados](https://github.com/JulioFretes/HelpTE)
- [API em Flask para requisições no ChatGPT](https://github.com/montemurro19/flaskApiChatGPT)
- [Aplicativo em React Native](https://github.com/JulioFretes/TranslateEmotions)

## Executando o Sistema e Criando o Pipeline na Azure

### Criação do Pipeline
1. Na criação do pipeline na Azure, adicione o repositório desejado. No nosso caso, utilizamos [este](https://github.com/JulioFretes/HelpTE).
2. Se a criação estiver como modo clássico, selecione o template do Maven e mude a versão do JDK para a versão 17.
3. Caso não seja a versão clássica, adicione este arquivo [YML](#arquivo-yml-do-pipeline).

### Criação do WebApp
1. Para a criação do pipeline, precisaremos de um WebApp Windows com o JDK 17.
2. Após isso, crie o release com o WebApp criado.

### Testando as Requisições
1. Quando o release estiver pronto, pegue o link e teste as requisições no Postman.
2. Siga os passos abaixo para enviar as requisições da seção Endpoints.

## Passo a Passo para Enviar Requisições no Postman

1. **POST `/api/registro`**
    - Abra o Postman e clique em "New Request".
    - Selecione o método "POST" e insira a URL do endpoint `/api/registro`.
    - Vá para a guia "Body", selecione "raw" e "JSON" como tipo de dados.
    - Copie e cole o seguinte JSON no corpo da requisição:

    ```json
    {
        "nome": "Julio Fretes",
        "email": "rm93285@fiap.com.br",
        "idade": 19,
        "senha": "12345678"
    }
    ```
    - Clique em "Send" para enviar a requisição.

2. **POST `/api/login`**
    - Crie uma nova requisição, selecione o método "POST" e insira a URL do endpoint `/api/login`.
    - No corpo da requisição, insira o seguinte JSON:

    ```json
    {
        "email": "rm93285@fiap.com.br",
        "senha": "12345678"
    }
    ```
    - Após enviar a requisição, você receberá um token e um id de usuario no corpo da resposta. Copie este token e id.

3. **PUT `/api/usuario`**
    - Crie uma nova requisição, selecione o método "PUT" e insira a URL do endpoint `/api/usuario`.
    - Vá para a guia "Headers" e adicione uma nova linha. No campo "Key", insira "Authorization". No campo "Value", insira "Bearer " seguido pelo token que você copiou na etapa anterior.
    - No corpo da requisição, insira o seguinte JSON, alterando somente o id pelo que você copiou na etapa anterior:

    ```json
    {
        "id": "654e980654d73a33b380cbc5",
        "nome": "Julio Machado Fretes",
        "email": "rm93285@fiap.com.br",
        "idade": 19,
        "senha": "$2a$10$enEyKOArp5UGrgt2xX9TQ.GBOC8mhDIAfCa.TIlY3oVU3QAhYs7.C",
        "historicos":
        [
            {
                "dataHora":"2023-11-03T10:30:00",
                "frase":"teste",
                "traducao":"teste",
                "isDeletado":true
            },
            {
                "dataHora":"2023-11-03T10:30:00",
                "frase":"teste1",
                "traducao":"teste1",
                "isDeletado":false
            },
            {
                "dataHora":"2023-11-03T10:30:00",
                "frase":"teste2",
                "traducao":"teste2",
                "isDeletado":false
            },
            {
                "dataHora":"2023-11-04T15:22:24.872Z",
                "frase":"teste",
                "traducao":"teste123",
                "isDeletado":false
            }
        ],
        "enabled": true,
        "password": "$2a$10$enEyKOArp5UGrgt2xX9TQ.GBOC8mhDIAfCa.TIlY3oVU3QAhYs7.C",
        "username": "rm93285@fiap.com.br",
        "accountNonExpired": true,
        "credentialsNonExpired": true

## Arquivo YML do Pipeline
    
    pool:
      name: Azure Pipelines
      demands: maven

    steps:
    - task: Maven@3
      displayName: Maven
      inputs:
        mavenPomFile: '$(Parameters.mavenPOMFile)'
        testRunTitle: 'Run 1'
        jdkVersionOption: 1.17

    - task: CopyFiles@2
      displayName: 'Copiar Arquivos'
      inputs:
        SourceFolder: '$(system.defaultworkingdirectory)'
        Contents: '**/target/*.jar'
        TargetFolder: '$(build.artifactstagingdirectory)'

    - task: PublishBuildArtifacts@1
      displayName: 'Publicar Artefato'
      inputs:
        PathtoPublish: '$(build.artifactstagingdirectory)'
        ArtifactName: app
   
