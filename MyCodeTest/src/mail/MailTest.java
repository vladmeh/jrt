package mail;

import java.io.*;
import java.net.Socket;

/**
 * SMTP (Simple Mail Transfer Protocol) является протоколом передачи электронной почты по сетям tcp/ip. Он включает в себя набор несложных правил, с помощью которых происходит процесс общения почтовых клиента и сервера. Клиент подключается к почтовому серверу по 25 порту, далее происходит примерно такой диалог:

 Server: (ожидает соединения)
 Client: (Подключается к порту 25 сервера)
 Server:220 mail.company.tld ESMTP CommuniGate Pro 5.1.4i is glad to see you!
 Client:HELO somecompany.ru //представляемся серверу
 Server:250 domain name should be qualified
 Client:MAIL FROM: <someusername@somecompany.ru> //от кого письмо
 Server:250 someusername@somecompany.ru sender accepted
 Client:RCPT TO:<user1@company.tld> //кому письмо
 Server:250 user1@company.tld ok
 Client: DATA //после пойдёт тело письма
 Server:354 Enter mail, end with «.» on a line by itself
 Client:Hi!
 Client:. //точкой определяем конец письма
 Server:250 769947 message accepted for delivery
 Client:QUIT //разрываем соединение
 Server:221 mail.company.tld CommuniGate Pro SMTP closing connection
 Server: (закрывает соединение)
 */
public class MailTest {
    static PrintStream ps = null;          // посылка сообщений
    static DataInputStream dis = null;     // получение сообщений

    public static void send(String str) throws IOException
    {
        ps.println(str);      // посылка строки на SMTP
        ps.flush();           // очистка буфера
        System.out.println("Java sent: " + str);
    }

    public static void receive() throws IOException
    {
        String readstr = dis.readUTF();  // получение ответа от SMTP
        System.out.println("SMTP respons: " + readstr);
    }

    public static void main (String args[]) throws IOException, InterruptedException {
        String HELO = "HELO gazprom.ru";
        String MAIL_FROM = "MAIL FROM: user@gazprom.ru ";
        String RCPT_TO = "RCPT TO: vlmeh@yandex.ru ";
        String DATA = "DATA";    // начало сообщения
        String FROM = "from: user@gazprom.ru";
        String SUBJECT = "subject: tema ";
        String BODY = "Hello my friend! Java sent this!";
        String END = ".";

        Socket smtp = null;     // сокет SMTP

        try {  // заметка: 25 - это стандартный номер порта SMTP
            smtp = new Socket("mx.yandex.ru", 25);
            OutputStream os = smtp.getOutputStream();
            ps = new PrintStream(os);
            InputStream is = smtp.getInputStream();
            dis = new DataInputStream(is);
        }
        catch (IOException e)
        {
            System.out.println("Error connection: " + e);
        }

        try {  // скажем SMTP helo
            receive();          // получение ответа SMTP
            send(HELO);
            receive();          // получение ответа SMTP
            send(MAIL_FROM);    // посылка на SMTP
            receive();          // получение ответа SMTP
            send(RCPT_TO);      // посылка адресату SMTP
            receive();
            send(DATA);         // начинается посылка на SMTP
            receive();          // получение ответа SMTP
            send(FROM);
            send(SUBJECT);
            send(BODY);         // посылка тела сообщения
            send(END);
            receive();
            smtp.close();
        }
        catch (IOException e)
        {
            System.out.println("Error sending: " + e);
        }

        System.out.println("Mail sent!");
    }
}
