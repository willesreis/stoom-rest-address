# Stoom Rest Address #

## Trabalhando com o Docker ##

### Criação da imagem ###

No diretório raiz do projeto, foi criada a imagem conforme abaixo
```
cd stoom-ret-address/
sudo docker build -t springio/stoom-rest-address .
```

### Execução da imagem ###

No diretório raiz do projeto, digite
```
cd stoom-ret-address/
sudo docker run -p 8080:8080 -t springio/stoom-rest-address
```

## Acessando a documentação da API ##

### Conteúdo principal ###
Encontrado no endereço: [http://localhost:8080/v2/api-docs]

### Interface do usuário ###
Acesse o endereço: [http://localhost:8080/swagger-ui.html]