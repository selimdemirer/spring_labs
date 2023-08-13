package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class Config {

    @Bean
    public Currency currencyBean(){

        Currency currency = new Currency();

        currency.setCode("USD");
        currency.setName("Dollar");

        return currency;
    }

    @Bean
    public Current currentBean(Currency currency){ //DI=As a parameter

        Current current = new Current();

        current.setAccountId(UUID.randomUUID());
        current.setAmount(new BigDecimal(250));

        current.setCurrency(currency);

        return current;
    }

    @Bean
    public Saving savingBean(){

        Saving saving = new Saving();

        saving.setAccountId(UUID.randomUUID());
        saving.setAmount(new BigDecimal(250));

        saving.setCurrency(currencyBean()); //DI=Calling method

        return saving;
    }


}
