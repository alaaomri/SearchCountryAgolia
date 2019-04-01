package com.algolia.hybris.config;

import com.algolia.search.APIClient;
import com.algolia.search.ApacheAPIClientBuilder;

public class Configuration {
	
	APIClient client;
	
	Configuration(){
		client =new ApacheAPIClientBuilder("Q3X1S8F5T1", "956f69b1c39df0f10da712808c0ca987").build();

	}

}
