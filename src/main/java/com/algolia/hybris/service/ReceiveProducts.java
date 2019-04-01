package com.algolia.hybris.service;




import com.algolia.hybris.model.Contact;
import com.algolia.search.APIClient;
import com.algolia.search.ApacheAPIClientBuilder;
import com.algolia.search.Index;
import com.algolia.search.exceptions.AlgoliaException;
import com.algolia.search.objects.Query;
import com.algolia.search.responses.SearchResult;

public class ReceiveProducts {
	
	
	APIClient client =new ApacheAPIClientBuilder("Q3X1S8F5T1", "956f69b1c39df0f10da712808c0ca987").build();
	

	public SearchResult<Contact> getResult() throws AlgoliaException {
		Index<Contact> index = client.initIndex("contacts", Contact.class);
		@SuppressWarnings("unchecked")
		SearchResult<Contact> search = index.search(new Query("query string")).setNbHits(100).setHitsPerPage(10);
		
		return search;
	}
}