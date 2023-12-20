package task4;

import java.util.ArrayList;
import java.util.List;

public class CurrencyList {
    private List<Currency> currencies;

    public CurrencyList() {
        currencies = new ArrayList<>();
        initializeCurrencies();
    }

    private void initializeCurrencies() {
        // Add more countries and their respective currency codes here
        currencies.add(new Currency("India", "INR"));
        currencies.add(new Currency("United States", "USD"));
        currencies.add(new Currency("European Union", "EUR"));
        currencies.add(new Currency("United Kingdom", "GBP"));
        currencies.add(new Currency("Canada", "CAD"));
        currencies.add(new Currency("Japan", "JPY"));
        currencies.add(new Currency("Australia", "AUD"));
        currencies.add(new Currency("Switzerland", "CHF"));
        currencies.add(new Currency("China", "CNY"));
        currencies.add(new Currency("Sweden", "SEK"));
        currencies.add(new Currency("South Korea", "KRW"));
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }
}

