package com.stanley.service.priceupdateservice;

import com.stanley.service.pricelistener.PriceListener;

public interface PriceUpdateService {

    public void subscribeToBankPriceUpdates(PriceListener priceListener);
    public void subscribeToCompanyPriceUpdates(PriceListener priceListener);

}
