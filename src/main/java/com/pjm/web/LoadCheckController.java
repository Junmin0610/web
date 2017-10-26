package com.pjm.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bson.Document;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.yaml.snakeyaml.util.UriEncoder;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;





@Controller
public class LoadCheckController {
	@GetMapping("/check")
	public String welcome(String url,Model model) throws IOException {
		String type = "";
		String target = "";
		if(url!=null) {
			URL URL = new URL(UriEncoder.encode(url));
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(URL.openStream(), "UTF-8"))) {
				for (String line; (line = reader.readLine()) != null;) {
					Pattern p1 = Pattern.compile("(body onload\\=\\\"\\alert\\(\\'body)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
					Pattern p2 = Pattern.compile("(window\\.onload)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
					Pattern p3 = Pattern.compile("(window\\.addEventListener\\(\\'load\\')", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
					Pattern p4 = Pattern.compile("(\\$\\(window\\)\\.load)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
					Pattern p5 = Pattern.compile("(\\$\\(window\\)\\.on\\(\\'load\\')", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
					Pattern p6 = Pattern.compile("(require load)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
					Matcher m1 = p1.matcher(line);
					Matcher m2 = p2.matcher(line);
					Matcher m3 = p3.matcher(line);
					Matcher m4 = p4.matcher(line);
					Matcher m5 = p5.matcher(line);
					Matcher m6 = p6.matcher(line);
					
					if (m1.find()) {
						System.out.println("TYPE-1 : " +m1.group(1).toString());
						type = "TYPE-1";
						target = m1.group(1).toString();
					}
					if (m2.find()) {
						System.out.println("TYPE-2 : " +m2.group(1).toString());
						type = "TYPE-2";
						target = m2.group(1).toString();
					}
					if (m3.find()) {
						System.out.println("TYPE-2 : " +m3.group(1).toString());
						type = "TYPE-2";
						target = m3.group(1).toString();
					}
					if (m4.find()) {
						System.out.println("TYPE-3 : " +m4.group(1).toString());
						type = "TYPE-3";
						target = m4.group(1).toString();
					}
					if (m5.find()) {
						System.out.println("TYPE-3 : " +m5.group(1).toString());
						type = "TYPE-3";
						target = m5.group(1).toString();
					}
					if (m6.find()) {
						System.out.println("TYPE-4 : " +m6.group(1).toString());
						type = "TYPE-4";
						target = m6.group(1).toString();
					}
					
				}
			}
		}else {
			url="";
		}
		
		
		
		
		model.addAttribute("type",type);
		model.addAttribute("target" , target);
		model.addAttribute("url",url );
		return "check";
	}
}
