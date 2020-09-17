package br.com.sms.canhao.service;

import br.com.sms.canhao.config.ConexaoSmSD7;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SmsService {

    ConexaoSmSD7 conexaoSmSD7;

    public void enviaMensagem() {
        String mensagem = "Mensagem a ser enviada aqui...";
        String numero = "5561xxxxxxxxx";
        conexaoSmSD7.enviarSms(mensagem, numero);
    }
}
