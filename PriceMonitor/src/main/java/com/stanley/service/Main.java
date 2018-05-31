/*package com.stanley.service;

import java.util.HashMap;
import java.util.Map;

public class Main {
	static Map<String, Double> symbolePriceMap;
	static PriceUpdateService priceUpdateService;
	static PriceListener priceListener;
	static Bank bank;
	static Company company;
	
	public static void construct() {
		symbolePriceMap = new HashMap<String, Double>();
		priceUpdateService = new PriceUpdateServiceImpl();
		priceListener = new PriceListenerImpl();

	}
	public static void test(){
		setMap();
		bank=new Bank(symbolePriceMap,priceUpdateService,priceListener);
		company=new Company(symbolePriceMap,priceUpdateService,priceListener);
	
		System.out.println(new PricePublishMonitorImpl().priceCompare(bank,company));
		bank.priceUpdate("US Dollar", 90.00);
		
		System.out.println(new PricePublishMonitorImpl().priceCompare(bank,company));
		
		company.getupdatedPrice();
		System.out.println(new PricePublishMonitorImpl().priceCompare(bank,company));
	
		
	
	}

	private static void setMap() {
		symbolePriceMap.put("US Dollar", 65.2);
		symbolePriceMap.put("Euro", 85.0);
		symbolePriceMap.put("British Pound", 100.12);
		symbolePriceMap.put("Candian Dollar", 120.10);

	}

	
	public void destroy() {
		symbolePriceMap = null;
		priceUpdateService = null;
		priceListener = null;
	}

	public static void main(String[] args) {
		construct();
		test();
	}

}
*/