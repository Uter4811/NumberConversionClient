package ru.company;


import java.io.IOException;
import java.math.BigInteger;
import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;
import  com.dataaccess.webservicesserver.*;
import java.math.BigInteger;





//private String bodyPath;// адрес где лежит хмл
// String endPoint;// локалхост куда я отправляю
// String body;// содержимое хмл
public class Request {
   /*public static void main(String[] args) throws IOException {
        Request request = new Request();
        request.action();

    }*/
    private String bodyPath;
    private String endPoint;
    private String body;

    public Request() {
        this.bodyPath = bodyPath;
        this.endPoint = endPoint;
    }

    //будет считываться шаблон сообщения.
    public void init() {
        body = XMLReader.read(bodyPath);
    }
    public void action() {

        NumberConversion service = new NumberConversion();
        NumberConversionSoapType port = service.getNumberConversionSoap();
        int z = 1 + (int) (Math.random()*300);

        Client cl = new Client(z);
        long number = cl.transfer;
        String res = port.numberToWords(BigInteger.valueOf(number));
        System.out.println(res);





    }
    public void end() {

    }

}