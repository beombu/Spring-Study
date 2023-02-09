package com.beomchul.springboot.mywebapp.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/basicauth")
	//@CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.GET) //특정 url에 cors에러 해결법
	public String basicAuthCheck() {
		return "Success";
	}

	@GetMapping(path = "/hello-world")
	//@CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.GET) //특정 url에 cors에러 해결법
	public String helloWorld() {
		return "Hello World v2";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}

	@GetMapping(path = "/hello-world/path-variable/{username}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String username) {
		return new HelloWorldBean(String.format("Hello World, %s", username));
	}
}