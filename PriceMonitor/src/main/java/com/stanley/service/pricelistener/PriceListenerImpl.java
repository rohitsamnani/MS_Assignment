package com.stanley.service.pricelistener;

import java.util.HashMap;
import java.util.Map;

public class PriceListenerImpl implements  PriceListener {

    private Map<String,Double> symbolePriceMap = new HashMap<String,Double>();


    public synchronized void  priceUpdate(String symbol,double price){
        symbolePriceMap.put(symbol,price);
    }

    //whenever company call for this method, symbolpricemap return updated value till that time and reset Map again
    public synchronized Map<String,Double> getPriceUpdate(){
    	Map<String,Double> temp = symbolePriceMap;
    	symbolePriceMap=new HashMap<String,Double>();
    	return temp;
    }

}
