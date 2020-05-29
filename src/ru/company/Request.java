package ru.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;
import  com.dataaccess.webservicesserver.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;


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

        String responseString = "";
        String outputString = "";
        HttpURLConnection httpConn = null;
        try {
            httpConn = (HttpURLConnection) new URL(endPoint).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buffer = body.getBytes();
        httpConn.setRequestProperty("Content-Length", String.valueOf(buffer.length));
        httpConn.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
        try {
            httpConn.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        OutputStream out = null;
        try {
            out = httpConn.getOutputStream();
            out.write(buffer);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(httpConn.getInputStream(), Charset.forName("UTF-8"));
            BufferedReader in = new BufferedReader(isr);
            while ((responseString = in.readLine()) != null) {
                outputString = outputString + responseString;
            }
            System.out.println(outputString);
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
    public void end() {

    }

}