# Crypto Library 🔐

Um MVP para criptografia e descriptografia de informações sensiveis rapidamente utilizando Java, RSA e 3DES.

# 📁 Estrutura de Pastas - Arquitetura da aplicação

    src/main/java
    ├── application # Controla todas as entradas e saidas de dados recebidas pela aplicação através de uma classe FACADE.
    ├── infrastructure # Mantém todas configurações relacionadas ao tamanho máximo do output gerado na criptografia e criação das Keys.   
    ├── service    # Mantém as nossas implementações e regras relacionadas a criptografia e descriptografia.

# 🟡 Configuração Necessaria

```sh
Gradle >= 8.4 && Java >= 17 instalado && a IDE de sua preferência.
```

# 🔵 Desenvolvimento Local - Execução e Debug

```sh
não é necessario nenhum servidor Web, você pode testar a aplicação utilizando a classe LocalTest.java
```

# Tecnologias utilizadas
![image](https://github.com/user-attachments/assets/bf1ad750-9f2c-47f7-a26c-ef6c8a3814a6)
  
# 📄 Release Notes (versionamento de código)
- [Release/1.0.0](https://github.com/cunhaDev/crypto-library/tree/Release/1.0.0)
> Implementação das features de criptografia e descriptografia, documentação de apoio.
- [Release/2.0.0](https://github.com/cunhaDev/crypto-library/tree/Release/2.0.0)
> Inclusão da classe LocalTest para facilitação de testes e debugs, criação da documentação.
- [Release/3.0.0](https://github.com/cunhaDev/crypto-library/tree/Release/3.0.0)
> Refatoração da CI, melhorias de código e configuração para publicação do artefato no nexus.
- [Release/4.0.0](https://github.com/cunhaDev/crypto-library/tree/Release/4.0.0)
> Ajuste em documentação e testes unitarios
- [Release/5.0.0](https://github.com/cunhaDev/crypto-library/tree/Release/5.0.0)
> Ajuste em construtor da classe CryptographyFacade e inclusão de testes unitarios

# WorkFlow interno da biblioteca
![image](https://github.com/user-attachments/assets/71075bc5-527a-4adc-ac40-3ba3b3ce1e7a)

# Como sua aplicação vai interagir com a nossa Biblioteca
![image](https://github.com/user-attachments/assets/a7a5fafe-5ce0-4769-a1eb-76e30ce2a8d7)

# Como implementar em seu projeto
- Aplicações Gradle, adicione o seguinte código ao seu arquivo build.gradle em repositories:
```sh
maven {
    url 'http://localhost:8081/repository/maven-releases/'
    allowInsecureProtocol = true
}
```
- Aplicações Gradle, adicione o seguinte código ao seu arquivo build.gradle em dependencies:
```sh
implementation 'com.xpe.projetoaplicado:crypto-library:1.0.0'
```

- Aplicações Maven, adicione o seguinte código ao seu arquivo pom.xml em repositories:
```sh
<repository>
    <id>nexus-repository</id>
    <url>http://localhost:8081/repository/maven-releases/</url>
</repository>
```
- Aplicações Maven, adicione o seguinte código ao seu arquivo pom.xml em dependencies:
```sh
<dependency>
  <groupId>com.xpe.projetoaplicado</groupId>
  <artifactId>crypto-library</artifactId>
  <version>1.0.0</version>
</dependency>
```

# Como fazer uso
## Criptografia
- Para criptografar informações, faça a chamada da classe **CryptographyFacade** e utilize o método **encrypt**:
```java
CryptographyFacade cryptographyFacade = new CryptographyFacade();
String encryptedText = cryptographyFacade.encrypt("your data");
```
## Descriptografia
- Para descriptografar informações, faça a chamada da classe **CryptographyFacade** e utilize o método **decrypt** informando o resultado obtido anteriormente ao realizar
a criptografia.
```java
CryptographyFacade cryptographyFacade = new CryptographyFacade();
String decryptedText = cryptographyFacade.decrypt("encryptedText");
```

# Possiveis Erros e como corrigi-los
## Padding error in decryption
- Este erro ocorreu pois a criptografia falhou por algum erro interno, é aconselhavel que realize novamente a criptografia para obter o resultado correto.

## Internal Server Erro
- Este erro pode ter ocorrido devido algum bug em nossa biblioteca, fique de olho nas Releases para utilizar sempre a versão mas estavel.

# 📚 Leitura recomendada
- [Relatório de Apresentação do Projeto](https://docs.google.com/document/d/1mfVI9MFjkF80qcao8E0AMcBTxs167App/edit)
- [Arquitetura em Camadas](https://escolalbk.com.br/glossario/o-que-e-layered-architecture-arquitetura-em-camadas/)
- [Design Pattern FACADE](https://refactoring.guru/pt-br/design-patterns/facade)
- [Conhecendo RSA](https://www.baeldung.com/java-rsa)
- [Conhecendo 3DES](https://www.baeldung.com/java-3des)
- [Publicando uma Biblioteca Gradle no Nexus](https://medium.com/@simionrazvan/how-to-create-a-gradle-library-and-publish-it-on-nexus-34be19b520aa)
- [Configurando um Servidor Nexus na AWS](https://dev.to/otobong_edoho_7796fec1f41/how-to-publish-a-java-artifact-built-with-gradle-to-a-nexus-repository-part-1-17p6)
