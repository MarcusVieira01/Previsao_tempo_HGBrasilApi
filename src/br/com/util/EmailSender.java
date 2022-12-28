//Declaração de pacote
package br.com.util;

//Importação de classes externas
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author Marcus Vieira
 * @apiNote Classe que realiza o envio de um e-mail simples ou com HTML, com evocação do método pertinente
 */
public class EmailSender {
    //Declaração de atributos privados
    String emailTo = "marcusvmvieira@gmail.com";
    String nameTo = "Marcus";
    String emailFrom = "marcusrspprodtech@outlook.com";
    String nameFrom = "Marcus";
    String subject = "E-mail exemplo";
    String mensagemSimple = "Teste";
    String mensagemHtml = """
                          <b>TESTE</b>
                          <h1>OLA MUNDO</h1>
                          <img src=\"https://seuladogeek.com.br/wp-content/uploads/2022/02/download-logo-google-photos-1536x864.png\">
                          """;
    String userAuth = "marcusrspprodtech@outlook.com";
    String passwAuth;
    String hostName = "smtp.office365.com";
    int stmpPort = 587;
    Boolean ssl = false;
    Boolean tls = true;
    

    /**
     * Método que realiza o envio de e-mail com HTML
     * @throws EmailException
     */
    public void htmlEmailSender() throws EmailException{
        //Instancia de novo objeto de email com HTML via construtor HtmlEmail()
        HtmlEmail htmlEmail = new HtmlEmail();

        //Endereçamento
        htmlEmail.addTo(emailTo, nameTo);
        htmlEmail.setFrom(emailFrom, nameFrom);

        //Mensagem
        htmlEmail.setSubject(subject);
        htmlEmail.setHtmlMsg(mensagemHtml);
        
        //Configuração do client
        htmlEmail.setSSL(ssl);
        htmlEmail.setTLS(tls);
        htmlEmail.setAuthentication(userAuth, passwAuth);
        htmlEmail.setHostName(hostName);
        htmlEmail.setSmtpPort(stmpPort);
        
        //Debug no console
        htmlEmail.setDebug(true);
        //Evocação de método de envio do e-mail
        htmlEmail.send();
    }

    /**
     * Método que realiza o envio de e-mail simples
     * @throws EmailException
     */
    public void simpleEmailSender() throws EmailException{
        //Instancia de novo objeto de email simples via construtor SimpleEmail()
        SimpleEmail mail = new SimpleEmail();

        //Endereçamento
        mail.addTo(emailTo, nameTo);
        mail.setFrom(emailFrom, nameFrom);

        //Mensagem
        mail.setSubject(subject);
        mail.setMsg(mensagemSimple);
        
        //Configuração do client
        mail.setSSL(ssl);
        mail.setTLS(tls);
        mail.setAuthentication(userAuth, passwAuth);
        mail.setHostName(hostName);
        mail.setSmtpPort(stmpPort);

        //Debug no console
        mail.setDebug(true);
        //Evocação de método de envio do e-mail
        mail.send();
    }   
}
