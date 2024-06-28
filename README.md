<h1 align=center>INCLUIDEV EMAIL API</h1>

<div align="center">
  <img src="pictures/banner-readme.png" style="border-radius: 15px;">
</div>

#
### OBJETIVO

> Esse serviço tem como objetivo ser uma ferramenta centralizadora da comunicação via email, atuando como um módulo acoplável ao serviço principal. Seu design visa escalabilidade, desempenho e reutilização dos componentes, distribuindo o processamento necessário para garantir a conclusão eficiente das transações.

#
### FUNCIONALIDADES

- Implementação de Autenticação Basic para garantia de segurança e integridade das comunicações.
- Personalização na validação e tratamento de exceções, assegurando robustez e confiabilidade no sistema.
- Persistência dinâmica de dados para adaptação eficiente às demandas variáveis do ambiente.
- Tratamento de transações com callback, garantindo consistência e integridade em operações críticas.
- Implementação de um serviço de consumo de envio de e-mail modular e reutilizável, garantindo eficiência e flexibilidade na comunicação por meio de diferentes canais.
- Normalização de dados através de Data Objects Transactions para padronização e consistência de informações.
- Utilização do Swagger UI para uma documentação complementar detalhada e acessível.
- Estruturação de tentativas de requisições externas sob controle para manutenção da estabilidade e disponibilidade do sistema.

#
### REPRESENTAÇÃO DE FLUXO

> A representação de fluxo visa graficamente ilustrar o comportamento da aplicação em nível arquitetural, destacando os principais recursos empregados para assegurar o funcionamento eficiente do serviço.

<div align="center">
  <img src="pictures/arquitetura.png" width="700px;">
</div>

#
### REQUISITOS

Para executar nossa plataforma localmente, é necessário ter em seu dispositivo computacional:

  1. Certifique-se que instalou a versão 17 do Java.  [Baixe aqui](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

  2. Certifique-se de que instalou alguma IDE em sua máquina. [Baixe aqui](https://www.jetbrains.com/idea/download/?section=windows)

#
### DOWNLOAD DO PROJETO

Baixe o projeto em seu computador através do comando:

```bash
git clone https://github.com/IncluiDev/inclui-dev-email-api.git
```

**ou**

1. Clique em `<> Code`.
2. Faça o download do arquivo ZIP.
3. Abra o seu explorador de arquivos na localização da instalação.
4. Extraia o arquivo ZIP.

#
### EXECUÇÃO

Sequência de execução do projeto:

1. Acesse a IDE na qual deseja executar o projeto.
2. Clique em "Abrir um projeto já existente".
3. Selecione o local da pasta descompactada do projeto.
4. Confirme a seleção.
5. Localize e clique no botão "Play" (verde) localizado na parte superior da IDE.
6. Um terminal integrado será aberto.
7. Aguarde a instalação das dependências do projeto.
8. Após a conclusão das instalações, o projeto será executado.

#
### VISUALIZAÇÃO

Abra a janela do seu navegador web padrão e acesse o seguinte endereço pela barra de pesquisa:

```bash
http://localhost:8080/swagger-ui/index.html#/
```

#
### CONTRIBUIÇÃO

1. Adicione suas mudanças ao controle de versão:

```bash
git add .
```

E aperte a tecla `Enter`

2. Comite as alterações com uma mensagem descritiva:

```bash
git commit -m "Descrição das mudanças que realizou"
```

E aperte a tecla `Enter`

3. Atualize seu repositório local com a versão mais recente do projeto:

```bash
git pull 
```

E aperte a tecla `Enter`

4. Envie suas alterações locais para o repositório remoto:

```bash
git push <remote_url> <branch_principal>
```

E aperte a tecla `Enter`

#
### EQUIPE

<table align="center">
  <tr>
    <td align="center">
      <a href="https://github.com/kaiquesouzasantos" title="Github Kaique">
        <img src="pictures/KAIQUE.jpeg" width="150px;" alt="Foto de Kaique Souza Santos"/><br>
        <sub>
          <b>Kaique</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

#
### TECNOLOGIAS

![Java](https://img.shields.io/badge/Java-0D1117?style=for-the-badge&logo=openjdk&logoColor=white&labelColor=0D1117)&nbsp;
![Spring](https://img.shields.io/badge/Spring-0D1117?style=for-the-badge&logo=spring&logoColor=107C10&labelColor=0D1117)&nbsp;
![SpringBoot](https://img.shields.io/badge/Spring_Boot-0D1117?style=for-the-badge&logo=springboot&logoColor=239120&labelColor=0D1117)&nbsp;
![Hibernate](https://img.shields.io/badge/Hibernate-0D1117?style=for-the-badge&logo=Hibernate&logoColor=239120&labelColor=0D1117)&nbsp;
![Swagger](https://img.shields.io/badge/Swagger-0D1117?style=for-the-badge&logo=Swagger&logoColor=85EA2D&labelColor=0D1117)&nbsp;
![Maven](https://img.shields.io/badge/apache_maven-0D1117?style=for-the-badge&logo=apachemaven&logoColor=E34F26&labelColor=0D1117)&nbsp;

#
### CREDENCIAIS

- **User**: `owner`
- **Password**: `JLEdTDuhDrvCjpO7bMqYEZMJxlwHgd0yAED6vXbc9BL2kxv2xQ`

ou 
```
HTTP {
  headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Credentials': true,
        'Access-Control-Allow-Origin': '*',
        "Authorization": `Basic b3duZXI6SkxFZFREdWhEcnZDanBPN2JNcVlFWk1KeGx3SGdkMHlBRUQ2dlhiYzlCTDJreHYyeFE=`
      }
}
```
#
### DOMINIO DA API

```
http://localhost:8080
```

#
### DOCUMENTACAO DA API

```
http://localhost:8080/swagger-ui/index.html
```

<p align="center">
  <img src="https://github.com/IncluiDev/.github/blob/main/profile/pictures/rodape-readme.png" style="border-radius: 15px;">
</p>
