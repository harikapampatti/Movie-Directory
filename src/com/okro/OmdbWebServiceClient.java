package com.okro.controller;

import java.io.BufferedReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
@Controller
public class OmdbWebServiceClient {
	
	
	public static final String SEARCH_URL="http://www.omdbapi.com/?i=tt3896198&apikey=e88bfb10";
	
	public static String searchTitle(String title,String key) throws IOException {
		String requestUrl =SEARCH_URL.replaceAll("TITLE", title).replaceAll("APIKEY", key);
		return sendGetRequest(requestUrl);
	}
	
	public static String sendGetRequest(String requestURL) throws IOException {
		StringBuffer response= new StringBuffer();
		try {
			URL url= new URL(requestURL);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept","/*");
			connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			
			InputStream stream =connection.getInputStream();
			InputStreamReader reader=new InputStreamReader(stream);
			BufferedReader b= new BufferedReader(reader);
			String line;
			while((line=b.readLine())!=null) {
				response.append(line);
			}
			b.close();
		}catch(MalformedURLException e) {
			
		}
		return response.toString();
	}
	}
