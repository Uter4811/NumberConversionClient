package ru.company;

// подключаем классы-заглушки веб-сервиса
import com.dataaccess.webservicesserver.*;

// нужно для передачи парметра в веб-сервис
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Request request = new Request();
        request.action();
    }
}


   /* // подключаемся к тегу service в wsdl описании
    NumberConversion service = new NumberConversion();
    // получив информацию из тега service подключаемся к самому веб-сервису
    NumberConversionSoapType port = service.getNumberConversionSoap();

    // вызываем метод веб-сервиса
    long number = 1
    String res = port.numberToWords(BigInteger.valueOf(number));
        System.out.println(res);*/
