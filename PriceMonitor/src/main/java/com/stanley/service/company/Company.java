package com.stanley.service.company;

import java.util.HashMap;
import java.util.Map;

import com.stanley.service.clients.Client1;
import com.stanley.service.pricelistener.PriceListener;
import com.stanley.service.priceupdateservice.PriceUpdateService;

public class Company {
	private Map<String,Double> companySymbolePriceMap;
	private PriceUpdateService priceUpdateService;
	private PriceListener priceListener;
	private Map<String,Double> updatedSymbolePriceMap;
	private Client1 client1= new Client1();
	
	public Company( Map<String,Double> companySymbolePriceMap,PriceUpdateService priceUpdateService,PriceListener priceListener){
		this.companySymbolePriceMap=new HashMap<String, Double>(companySymbolePriceMap);
		this.priceListener=priceListener;
		this.priceUpdateService=priceUpdateService;
	}
	public Company(){
		
	}
	
    public void subscribe(){
        priceUpdateService.subscribeToCompanyPriceUpdates(priceListener);
    }

    //after every 30 second need to call this method to get updated values from priceListener
    public void getupdatedPrice(){
    	updatedSymbolePriceMap =  priceListener.getPriceUpdate();
    	
    	//updating symbolpriceMap
        for (String key : updatedSymbolePriceMap.keySet()) {
        	companySymbolePriceMap.put(key,updatedSymbolePriceMap.get(key));
        }
    }
    
    public Map<String,Double> getAllSymbolsStats(){
    	return companySymbolePriceMap;
    }
    
    //need to send after every 30 second
    public void sendUpdatedSymbolPriceValue(){
    		if(updatedSymbolePriceMap!=null)
    		client1.setNewPrice(updatedSymbolePriceMap);
    }


}
