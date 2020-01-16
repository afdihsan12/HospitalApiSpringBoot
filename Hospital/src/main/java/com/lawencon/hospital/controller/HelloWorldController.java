package com.lawencon.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Controller
public class HelloWorldController {

@RequestMapping(path = "greetings", method = RequestMethod.GET)
public String greetings() {
	return "hello world";
}
@RequestMapping(path = "greetings/{nama}", method = RequestMethod.GET)
public String gretings(@PathVariable("nama") String nama) {
	return "hello "+nama;
}

}
