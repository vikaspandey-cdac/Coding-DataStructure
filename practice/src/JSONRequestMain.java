//import com.google.gson.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class JSONRequestMain {
    static int getNumberOfMovies(String substr) {
        /*
         * Endpoint: "https://jsonmock.hackerrank.com/api/movies/search/?Title=substr"
         */
        /*String response =  callURL(substr);
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        String total = jsonObject.get("total").getAsString();
        return  Integer.valueOf(total);*/
        return 0;
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
    public static void main(String args[]){
        System.out.println(getNumberOfMovies("maze"));
    }
}
