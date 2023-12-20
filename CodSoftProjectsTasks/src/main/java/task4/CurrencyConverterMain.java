package task4;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CurrencyConverterMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            CurrencyList currencyList = new CurrencyList();

            List<Currency> currencies = currencyList.getCurrencies();

            System.out.println("Available currencies:-");
            for (Currency currency : currencies) {
                System.out.println(currency.getCountry() + " - " + currency.getCode());
            }

            System.out.println("\nEnter the base currency (choose from the list above):");
            String baseCurrency = scanner.nextLine().toUpperCase();

            System.out.println("Enter the target currency (choose from the list above):");
            String targetCurrency = scanner.nextLine().toUpperCase();

            CurrencyConverterAPIService service = new CurrencyConverterAPIService();
            double exchangeRate = service.fetchExchangeRate(baseCurrency, targetCurrency);

            System.out.println("Enter the amount to convert:");
            double amountToConvert = scanner.nextDouble();

            double convertedAmount = amountToConvert * exchangeRate;

            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


