package com.pjm.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.bson.Document;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;





@Controller
public class WelcomController {
	@GetMapping("/helloworld")
	public String welcome(String name,int age, Model model) throws IOException {
		String url = "https://api.bithumb.com/public/orderbook/";
		MongoClientURI mongoClientURI = new MongoClientURI("mongodb://jjang0610:qlqjs12#@coindata-shard-00-00-nde1g.mongodb.net:27017,coindata-shard-00-01-nde1g.mongodb.net:27017,coindata-shard-00-02-nde1g.mongodb.net:27017/coin?ssl=true&replicaSet=CoinData-shard-0&authSource=admin");
		MongoClient mongoClient = new MongoClient(mongoClientURI);
		MongoDatabase database = mongoClient.getDatabase("coin");
		MongoCollection<Document> mongoCollection = database.getCollection("orderbook");
		
		URL obj = new URL(url);
		URLConnection conn = obj.openConnection();
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(conn.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuilder stringBuilder = new StringBuilder();
			String inputStr;
			while((inputStr = bufferedReader.readLine())!= null) {
				stringBuilder.append(inputStr);
			}
			JSONObject jsonObject = new JSONObject(new String(stringBuilder));
			System.out.println(jsonObject);
//			System.out.println(stringBuilder);
//			JSONObject jsonObject = new JSONObject(stringBuilder.toString());
//			System.out.println(jsonObject);
//			mongoCollection.insertOne(jsonObject);
//			DBObject dbObject = (DBObject)JSON.parse(new String(stringBuilder));
//			Document document = new Document();
//			document.append("test", "test");
//			mongoCollection.insertOne(document);
//			mongoClient.close();
//			model.addAttribute("json",jsonObject);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "welcome";
	}
}
