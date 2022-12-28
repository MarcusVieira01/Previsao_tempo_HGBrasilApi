# ***Previsão do tempo com API HG Weather***

## **Objetivos**

- Leitura do JSON de resposta à requisição à API HG Weather;
- Exibição em página HTML dos dados lidos;
- Envio de e-mail com os dados lidos;
- Otimização de requisições com aplicação de cache (*bonus*);

## **Linguagem e implementação**

Quanto ao back-end, será implementada a solução usando Java e os conceitos de orientação a objetos para a requisição, leitura, parseamento, geração de documento HTML e de cache.

Ao front-end será implementada via HTML e Bootstrap, para exibição dos conteúdos definidos nas classes no back-end.

### **Necessidades para implementação e uso**

A criação de conta na API HG Weather é realizada no link [www.hgbrasil.com](https://hgbrasil.com/) de forma muito simples. A HG Brasil possui também outras APIs para consulta, como dados financeiros.

Os acessos são gratuítos, com limites de acessos e a alguns conteúdos. Há possibilidade de criação de planos pagos com diversos níveis de acesso, conforme descrito no [link](https://hgbrasil.com/apis/planos).

Na raiz, há necessidade de criação do arquivo **api_key.txt** contendo a chave de acesso à API. Com a chave será realizada a requisição completa. A API HG Weather permite a requsição sem a chave, mas limita o body que é contido na resposta.

Também há necessidade de criação do arquivo de configuração de envio de e-mail **email_sender_congif.txt**, com host, conta e senha. Esse arquivo será lido por classe dedicada e dessa forma os dados secretos ficam disponíveis apenas na implementação.

### **Uso da solução**

Para que o arquivo final HTML seja criado, há necessidade de rodar a classe Main que consta dentro do pacote app. Serão realizadas as evocações das classes e métodos pertinentes à requisição, leitura, parseamento e geração do arquivo HTML final.

Para que o e-mail com os dados sejam enviados, há necessidade de criação do arquivo de configuração com os dados para a classe EmailSender possa usar.

Há necessidade de uso dos pacotes .jar abaixo:

Pacote                         | Link (Maven)
:---                           | :---:
activation-1.1.jar (v1.1.1)    | [link](https://mvnrepository.com/artifact/javax.activation/activation/1.1.1)
commons-email-1.1.jar (v1.1)   | [link](https://mvnrepository.com/artifact/org.apache.commons/commons-email/1.1)
javax.mail.jar (v1.6.2)        | [link](https://mvnrepository.com/artifact/com.sun.mail/javax.mail/1.6.2)
json-simple-1.1.1.jar (v1.1.1) | [link](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1)

## **Tarefas:**

Descrição das tarefas pendentes e completas:

Legenda: :x: - Cancelada | :white_check_mark: Concluída | :large_blue_diamond: Pendente | :o: Reaberto

Tarefa                                                                    | Status
:---                                                                      | :---:
Refatorar classe ParseJsonHG para retornar um objeto WeatherActual        | :white_check_mark:
Refatorar classe KeyReader para SecretReader                              | :white_check_mark:
Refatorar a exição do método toString() da classe WeatherActual           | :white_check_mark:
Testar o parsionamento do JSON por secção header, result e forcast        | :x: - Cancelada
Criar classe WeatherForecast                                              | :large_blue_diamond:
Refatorar ParseJsonHG para retornar um objeto WeatherForecast             | :large_blue_diamond:
Refatorar classe SecreatReader para captura de login do e-mail            | :large_blue_diamond:
Refatorar EmailSender para receber o login da classe SecretReader         | :large_blue_diamond:
Criar classe que gera o arquivo HTML para exibição das informações        | :large_blue_diamond:
Realizar o release v0.1                                                   | :large_blue_diamond:

## **Descrição das implementações**

- **Implementação de classe HttpRequestHG:** Classe que fará a requisição HTTP à API HG Weather, via HTTPClient, HTTPRequest e HTTPResponse, além de retornar o contrúdo do body da Response no formato String.

- **Implementação de classe KeyReader (SecretReader):** Classe que fará a leitura do arquivo **api_key.txt** e retornará seu valor no formato String. Ela é usada na classe **HttpRequestHG** como integrante da requisição, passando a chave de acesso. Essa classe existe para que a chave de acesso API HG Weather não seja exposta no repositório, gerando um vazamento de secret.

- **Implementação de classe WeatherActual:** Classe que modela um clima atual, com atributos e métodos de acesso à esses atributos. Possui método toString() para exibição do conteúdo do objeto.

- **Implementação de classe ParseJsonHG:** Classe que realiza o parseamento do JSON do body de resposta para um objeto da classe WeatherActual.

- **Implementação de GitFlow:** Aplicação de filosofia GitFlow com a implementação das branches main, onde ficará o código final após testes, develop, onde ficará o código já com as features integradas, e as branches de features, que receberão os desenvolvimentos das classes e funcionalidades. Essa implementação foi feita e testada com alguns arquivos.

    Após teste da filosofia foi gerado um merge de todas as branches para a main para que, após esses testes, seja seguida a filosofia implementada.

- **Implementação da classe EmailSender:** Implementação de classe que fará o envio de e-mail com os dados lidos e tratados pelo sistema implementado.
