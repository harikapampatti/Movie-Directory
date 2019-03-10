package com.okro.controller;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Movie {
	@Autowired
    @Qualifier("omdbWebServiceClient")
    private OmdbWebServiceClient omdbWebServiceClient;
    
	
	
	@RequestMapping(value = "/search")
	public String searchMovieByTitle(
			@RequestParam(value = "mtitle", required = false) String mtitle,
			@RequestParam(value = "key	", required = false) String key
			) throws IOException{
		//HttpRequest req=
		String jsonResponse=OmdbWebServiceClient.searchTitle(mtitle, "e88bfb10");
		if(jsonResponse==null){
			return "Result Not Found";
		}
		return jsonResponse;
	}
	

}
