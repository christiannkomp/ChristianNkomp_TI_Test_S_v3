package com.nkompchristian.rest.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BalanceOperationImpl implements BalanceOperation {

	public static final String BASE_URL = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts";
	public BalanceOperationImpl() {
		// TODO Auto-generated constructor stub
	}
	
	//Header della richiesta Http con i suoi parametri   
	public static HttpEntity<Object> getHttpEntityObject(Object object){
		 HttpHeaders headers = new HttpHeaders();
	     headers.set("Auth-Schema", "S2S");
	     headers.set("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
	     HttpEntity<Object> requestEntity = new HttpEntity<>(object, headers);
	
	     return requestEntity;
	 }
	
	@Override
	public ResponseEntity<Object> balanceRead(int accountId) throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();//Uso la libreria java resttemplate che mi permette di interrogae le API
	        
        URI uri = new URI(BASE_URL + "/"+ accountId); //instanzio Recuperano l'oggetto Url
              
        HttpEntity<Object> requestEntity = getHttpEntityObject(null);
        
        ResponseEntity<Object> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Object.class);//Get e mi ritorna un oggetto
        
        return result;
	}

	@Override
	public ResponseEntity<String> transfert(int accountId) throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();//Uso la libreria java resttemplate che mi permette di interrogae le API
		        
	        URI uri = new URI(BASE_URL + "/"+ accountId + "/payments/money-transfers"); //instanzio Recuperano l'oggetto Url
	        
	        InfoTransfert infotransfert = new InfoTransfert();//instanzio e costruisco l'oggetto per il post
	        infotransfert.setAmount("10000");
	        infotransfert.setCurrency("EUR");
	        infotransfert.setDescription("Questo è il tuo bonifico");
	        infotransfert.setExecutionDate("09/01/2021");
	        infotransfert.setReceiverName("Santa Barbara");
	        
	        HttpEntity<Object> requestEntity = BalanceOperationImpl.getHttpEntityObject(infotransfert);//recupero l'oggetto da mandare in post
	        ResponseEntity<String> result = null;
	      
	        result = restTemplate.postForEntity(uri, requestEntity, String.class);//una String in post
	        
	        return result;
		
	}

	@Override
	public ResponseEntity<Object> transactionRead(int accountId, Date fromAccountingDate, Date toAccountingDate) throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();//Uso la libreria java resttemplate che mi permette di interrogae le API
		
		String pattern = "yyyy-MM-dd";//stringa per formatare la data - l'ho fatto perché chiedeva la data di tipo string
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);//instanzio e costruisco

		String fromDate = simpleDateFormat.format(fromAccountingDate);
		String toDate = simpleDateFormat.format(toAccountingDate);
		
		 URI uri = new URI(BASE_URL + "/"+accountId+"/transactions?fromAccountingDate="+fromDate+"&toAccountingDate="+toDate);//instanzio  recupero l'Url
         
		 HttpEntity<Object> requestEntity = getHttpEntityObject(null);
        
		 ResponseEntity<Object> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Object.class);//Get e mi ritorna un oggetto
        
        
        return result;
	}

}
