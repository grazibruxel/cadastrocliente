package com.replit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {
        @RequestMapping("/")
        public String index() {
            return "Olá Colinas de Graziela Cadastro Clientes!";
        }
}
