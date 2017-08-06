package com.nishant.springboot.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Predicate;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping(value="/home")
@EnableSwagger2
public class HomeController {

	@RequestMapping(value="/getrequestforstring",method=RequestMethod.GET)
	public String getRequestForString() {
		return "getRequestForString is successful";
	}

	@RequestMapping(value="/getrequestforstring/{id}",method=RequestMethod.GET)
	public String getRequestForStringbyID(@PathVariable Integer id) {
		return "getRequestForString is successful with id="+String.valueOf(id);
	}

	@RequestMapping(value="/postrequestforstring",method=RequestMethod.POST)
	public City postRequestForString(@RequestBody City city) {
		return city;
	}

	@Bean
	public Docket getSwagger() {
		ApiInfo apinfo=new ApiInfo("NNTutorial Swagger", "This is swagger ui page", "1.0", "Terms of service", "India", "License", "License URL");
		Predicate<String> predicate=regex("/home/.*");
		ApiSelectorBuilder apiselectorbuilder=new Docket(DocumentationType.SWAGGER_2).select().paths(predicate);
		return apiselectorbuilder.build().apiInfo(apinfo).useDefaultResponseMessages(false);
	}

}
