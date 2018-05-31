package test.junit;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stanley.service.bank.Bank;
import com.stanley.service.company.Company;
import com.stanley.service.pricelistener.PriceListener;
import com.stanley.service.pricelistener.PriceListenerImpl;
import com.stanley.service.pricepublicmonitor.PricePublishMonitorImpl;
import com.stanley.service.priceupdateservice.PriceUpdateService;
import com.stanley.service.priceupdateservice.PriceUpdateServiceImpl;

public class JTest {
	Map<String, Double> symbolePriceMap;
	PriceUpdateService priceUpdateService;
	PriceListener priceListener;
	Bank bank;
	Company company;

	@Before
	public void setUp() {
		symbolePriceMap = new HashMap<String, Double>();
		priceUpdateService = new PriceUpdateServiceImpl();
		priceListener = new PriceListenerImpl();

	}

	@Test
	public void testCase(){
		setMap();
		bank=new Bank(symbolePriceMap,priceUpdateService,priceListener);
		company=new Company(symbolePriceMap,priceUpdateService,priceListener);
		
		//check first time when all values are new in bank and company(not updated)
		assertTrue(new PricePublishMonitorImpl().priceCompare(bank,company));
		
		//bank updating price
		bank.priceUpdate("US Dollar", 90.00);
		
		//bank updated its price but company didn't know about price so there will be difference between bank's and company's stats
		assertTrue(!new PricePublishMonitorImpl().priceCompare(bank,company));
		
		//After 30 seconds company fetching updated data
		company.getupdatedPrice();
		
		//now company also has updated data, check if bank and comapny both has updated data or not
		assertTrue(new PricePublishMonitorImpl().priceCompare(bank,company));
		
		
	}

	private void setMap() {
		symbolePriceMap.put("US Dollar", 65.2);
		symbolePriceMap.put("Euro", 85.0);
		symbolePriceMap.put("British Pound", 100.12);
		symbolePriceMap.put("Candian Dollar", 120.10);

	}

	@After
	public void destroy() {
		symbolePriceMap = null;
		priceUpdateService = null;
		priceListener = null;
	}

}
