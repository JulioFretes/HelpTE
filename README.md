# HelpTE

[Comandos para criação dos documentos no MONGODB](MONGODB.txt)

## Endpoints

POST
`/api/registro`


    
    {
        "nome": "Julio Fretes",
        "email": "rm93285@fiap.com.br",
        "idade": 19,
        "senha": "12345678"
    }
    
POST
`/api/login`


    {
        "email": "rm93285@fiap.com.br",
        "senha": "12345678"
    }

PUT
`/api/usuario`

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
        "credentialsNonExpired": true,
        "accountNonLocked": true
    }



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
   
