package com.apigestionregions.Apigestionregions.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@Controller
public class SwaggerControleur {
    @RequestMapping(method = RequestMethod.GET)
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }
}
