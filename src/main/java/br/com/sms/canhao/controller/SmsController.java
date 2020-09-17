package br.com.sms.canhao.controller;

import br.com.sms.canhao.service.SmsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("smssender/api")
public class SmsController {

    private SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping
    public void enviarMensagemIndividual() {
        smsService.enviaMensagem();
    }
}
