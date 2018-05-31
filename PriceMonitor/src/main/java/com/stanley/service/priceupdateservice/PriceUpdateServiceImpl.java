package com.stanley.service.priceupdateservice;

import com.stanley.service.pricelistener.PriceListener;

public class PriceUpdateServiceImpl implements  PriceUpdateService {


   public  void subscribeToBankPriceUpdates(PriceListener priceListener){
        System.out.print("Bank Subscribe");
    }
    public void subscribeToCompanyPriceUpdates(PriceListener priceListener){
        System.out.print("Company Subscribe");
    }


}
