package com.nkompchristian.rest.test;
import java.net.URISyntaxException;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.nkompchristian.rest.model.BalanceOperation;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SpringBootDemoApplicationTests 
{   
    @Autowired
    private BalanceOperation balanceOperation;
    
    //Lettura saldo
    @Test
    public void testBalanceRead() throws URISyntaxException 
    {
    	ResponseEntity<Object> requestEntity = balanceOperation.balanceRead(14537780);//Chiamo il metodo BalanceRead con Spring
    	      
        System.out.println("Result ="+ requestEntity);
        Assert.assertEquals(200,  requestEntity.getStatusCodeValue());//Risultato ritorna un request Entity, recupero lo statut della richiesta deve essere uguale a 200
    }
    
    //Bonifico
    @Test
    public void testsendTransfert() throws URISyntaxException 
    {
        
        	ResponseEntity<String> requestEntity = balanceOperation.transfert(14537780);//Chiamo il metodo transfert con Spring
            
            Assert.assertEquals(400, requestEntity.getStatusCodeValue());//Risultato ritorna un request Entity, recupero lo statut della richiesta deve essere uguale a 400
            System.out.print(requestEntity.getBody());
            Assert.assertEquals(true, requestEntity.getBody().contains("REQ010"));
      
       
    }
    
    //Lettura transazioni
    @Test
    public void testtransactionRead() throws URISyntaxException 
    {        
    	Date fromdate = new Date();
    	Date todate = new Date();
    	
    	ResponseEntity<Object> requestEntity = balanceOperation.transactionRead(14537780, fromdate, todate); //Chiamo il metodo transactionRead con Spring         
        System.out.println("Result ="+ requestEntity);
        Assert.assertEquals(200, requestEntity.getStatusCodeValue());//Risultato ritorna un request Entity, recupero lo statut della richiesta deve essere uguale a 200
    }
}
