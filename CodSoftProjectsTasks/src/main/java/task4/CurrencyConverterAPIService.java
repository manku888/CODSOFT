package task4;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverterAPIService {

    public double fetchExchangeRate(String baseCurrency, String targetCurrency) throws IOException {
        URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + baseCurrency);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Error: Response code " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject jsonObject = new JSONObject(response.toString());
        JSONObject rates = jsonObject.getJSONObject("rates");

        return rates.getDouble(targetCurrency);
    }
}


