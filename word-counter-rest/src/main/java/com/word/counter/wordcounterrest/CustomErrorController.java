package com.word.counter.wordcounterrest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomErrorController implements ErrorController {


    @RequestMapping("/error")
    @ResponseBody
    ResponseEntity<String> error(HttpServletRequest request) {
        return ResponseEntity.badRequest().body("Mapping error! Please check your parameters for errors.");
    }


}