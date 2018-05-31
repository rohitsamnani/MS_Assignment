package com.stanley.service.pricelistener;

import java.util.Map;

public interface PriceListener {


    public void priceUpdate(String symbol,double price);

	public Map<String, Double> getPriceUpdate();


}
