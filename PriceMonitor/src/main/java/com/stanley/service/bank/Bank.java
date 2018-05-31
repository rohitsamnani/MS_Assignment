package com.stanley.service.bank;

import java.util.HashMap;
import java.util.Map;

import com.stanley.service.pricelistener.PriceListener;
import com.stanley.service.priceupdateservice.PriceUpdateService;

public class Bank {
	private Map<String,Double> bankSymbolePriceMap;
	private PriceUpdateService priceUpdateService;
	private PriceListener priceListener;
	
	public Bank(Map<String,Double> bankSymbolePriceMap,PriceUpdateService priceUpdateService,PriceListener priceListener){
		
		this.bankSymbolePriceMap= new HashMap<String, Double>(bankSymbolePriceMap);
		this.priceListener=priceListener;
		this.priceUpdateService=priceUpdateService;
	}

	public Bank(){
		
	}
	
    public void subscribe(){
        priceUpdateService.subscribeToBankPriceUpdates(priceListener);
    }
    
    //whenever price will update for a symbol need to call this method
    public void priceUpdate(String symbol,Double price){
    	bankSymbolePriceMap.put(symbol, price);
    	priceListener.priceUpdate(symbol, price);
    	
    }

    //get all symbols stats for comparing with 
    public Map<String, Double> getAllSymbolsStats() {
		 return bankSymbolePriceMap;
	}

}
