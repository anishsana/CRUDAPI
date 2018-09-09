package application.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.model.Book;

@RestController
public class Controller {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@RequestMapping(method = RequestMethod.GET, value = "/top10words")
	public Map<String, Integer> findTop10Words() {
		Query query = new Query();
		query.fields().include("title");
		List<Book> books = mongoTemplate.find(query, Book.class);
		
		Map<String, Integer> wordMap = new HashMap<>();
		
		for (Book book : books) {
			if (book.getTitle() != null && !book.getTitle().isEmpty()) {
				String[] words = book.getTitle().split("\\s");
				
				for (String word : words) {
					if (wordMap.containsKey(word)) {
						wordMap.put(word, wordMap.get(word) + 1);
					} else {
						wordMap.put(word, 1);
					}
				}
			}				
		}
		
		return wordMap.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue())).limit(10)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
	
}
