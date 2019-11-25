

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSONRequestMain {
    static int getNumberOfMovies(String substr) {
        /*
         * Endpoint: "https://jsonmock.hackerrank.com/api/movies/search/?Title=substr"
         */
        String response =  callURL(substr);
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        String total = jsonObject.get("total").getAsString();
        return  Integer.valueOf(total);
    }

    public static String callURL(String substr) {
        String myURL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr;
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:"+ myURL, e);
        }

        return sb.toString();
    }

    public static double calculateHoldingValue(String date) {
        String holdingServiceURL = "https://api.myjson.com/bins/1eleys";
        String pricingServiceURL = "https://api.myjson.com/bins/vf9ac";
        double holdingValue = 0;
        try {
            JsonObject holdingObject = readJsonFromUrl(holdingServiceURL);
            Iterator<JsonElement> holdingIterator = holdingObject.get("data").getAsJsonArray().iterator();
            List<Holding> holdings = getAllHolding(date, holdingIterator );

            JsonObject pricingObject = readJsonFromUrl(pricingServiceURL);
            Iterator<JsonElement> priceIterator = pricingObject.get("data").getAsJsonArray().iterator();

            List<Price> prices = getAllPricing(date, priceIterator );

            for(Holding holding: holdings){
                double amount = prices.stream()
                        .filter(price -> holding.security.equals(price.security))
                        .map(Price::getPrice)                        //convert stream to String
                        .findAny()
                        .orElse(0.0);
                holdingValue += holding.quantity * amount;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return holdingValue;
    }

    static class Holding{
        String security;
        long quantity;

        public Holding(String security, long quantity) {
            this.security = security;
            this.quantity = quantity;
        }

        public String getSecurity() {
            return security;
        }

        public void setSecurity(String security) {
            this.security = security;
        }

        public long getQuantity() {
            return quantity;
        }

        public void setQuantity(long quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Holding{" +
                    "security='" + security + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }
    static class Price{
        String security;
        double price;

        public Price(String security, double price) {
            this.security = security;
            this.price = price;
        }

        public String getSecurity() {
            return security;
        }

        public void setSecurity(String security) {
            this.security = security;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Price{" +
                    "security='" + security + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static List<Holding>  getAllHolding(String date, Iterator<JsonElement> iterator){
        List<Holding> holdingList = new ArrayList<>();
        while(iterator.hasNext()){
            JsonObject jsonObject = iterator.next().getAsJsonObject();
            if(jsonObject.get("date").getAsString().equals(date)){
                String security = jsonObject.get("security").getAsString();
                long quantity = jsonObject.get("quantity").getAsLong();
                holdingList.add(new Holding(security,quantity));
            }
        }
        return holdingList;
    }

    public static List<Price>  getAllPricing(String date, Iterator<JsonElement> iterator){
        List<Price> pricingList = new ArrayList<>();
        while(iterator.hasNext()){
            JsonObject jsonObject = iterator.next().getAsJsonObject();
            if(jsonObject.get("date").getAsString().equals(date)){
                String security = jsonObject.get("security").getAsString();
                double price = jsonObject.get("price").getAsDouble();
                pricingList.add(new Price(security,price));
            }
        }
        return pricingList;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JsonObject readJsonFromUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new Gson().fromJson(jsonText, JsonObject.class);
        } finally {
            is.close();
        }
    }
    public static void main(String args[]){
        //System.out.println(getNumberOfMovies("maze"));
        System.out.println(calculateHoldingValue("20190510"));
    }
}
