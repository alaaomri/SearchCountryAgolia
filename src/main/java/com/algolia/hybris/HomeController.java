package com.algolia.hybris;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algolia.hybris.model.Contact;
import com.algolia.hybris.service.ReceiveProducts;
import com.algolia.search.APIClient;
import com.algolia.search.ApacheAPIClientBuilder;
import com.algolia.search.Index;
import com.algolia.search.exceptions.AlgoliaException;
import com.algolia.search.objects.Query;
import com.algolia.search.responses.SearchResult;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private ReceiveProducts rcvpr =new ReceiveProducts();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public String getcountries(Locale locale, Model model) throws AlgoliaException {
		logger.info("Welcome home! The client locale is {}.", locale);
		System.out.println("here ok1 "); 
		System.out.println("here ok2 "); 
		Date date = new Date();
		List<Contact> listContact =this.getResult().getHits();
		int num = this.getResult().getFacets().size();
		System.out.println("here ok3 "+num);
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("listContact", listContact );
		return "country";
	}
	
	
	APIClient client =new ApacheAPIClientBuilder("Q3X1S8F5T1", "956f69b1c39df0f10da712808c0ca987").build();
	

	public SearchResult<Contact> getResult() throws AlgoliaException {
		Index<Contact> index = client.initIndex("countries", Contact.class);
		@SuppressWarnings("unchecked")
		SearchResult<Contact> search = index.search(new Query("")).setNbHits(100).setHitsPerPage(10);
		return search;
		}
	
}
