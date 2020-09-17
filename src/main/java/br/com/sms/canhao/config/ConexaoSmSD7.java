package br.com.sms.canhao.config;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Slf4j
@Configuration
public class ConexaoSmSD7 {

    public void enviarSms(String message, String number) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"to\":\" " + number + " " +
                "\",\n\t\"content\":\" " + message + " \"," +
                "\n\t\"from\":\"SMSINFO\"," +
                "\n\t\"dlr\":\"yes\",\n\t\"dlr-method\":\"GET\", \n\t\"dlr-level\":\"2\", " +
                "\n\t\"dlr-url\":\"http://yourcustompostbackurl.com\"\n}");

        log.info(body.toString());

        Request request = new Request.Builder()
                .url("https://rest-api.d7networks.com/secure/send")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Basic YXRkYzUzNTQ6bmltc244dlI=")
                .build();

        try {

            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
