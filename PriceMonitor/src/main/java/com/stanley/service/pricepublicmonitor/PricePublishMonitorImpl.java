package com.stanley.service.pricepublicmonitor;

import java.util.Map;

import com.stanley.service.alert.AlertService;
import com.stanley.service.alert.AlertServiceImpl;
import com.stanley.service.bank.Bank;
import com.stanley.service.company.Company;

public class PricePublishMonitorImpl implements PricePublishMonitor {


    public boolean priceCompare(Bank bank,Company company){

     Map<String , Double > resultBank = bank.getAllSymbolsStats();

     Map<String , Double > resultCompany = company.getAllSymbolsStats();

     if(!mapsAreEqual(resultBank,resultCompany) ){
         AlertService alertService = new AlertServiceImpl();
                 alertService.alert(" There is price mismatch between bank and company  ");
                 return false;
     }
     	return true;



    }
    public boolean mapsAreEqual(Map<String, Double> bankSymbolePriceMap, Map<String, Double> companySymbolePriceMap) {

        try{
            for (String k : companySymbolePriceMap.keySet())
            {
                if (!bankSymbolePriceMap.get(k).equals(companySymbolePriceMap.get(k))) {
                    return false;
                }
            } 
            for (String y : bankSymbolePriceMap.keySet())
            {
                if (!companySymbolePriceMap.containsKey(y)) {
                    return false;
                }
            } 
        } catch (NullPointerException np) {
            return false;
        }
        return true;
    }
    
 


}

