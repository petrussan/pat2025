import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Api01 {
    public Api01() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: "+responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
                );
                String s;
                StringBuilder response = new StringBuilder();
                while ((s = in.readLine())!=null) {
                    response.append(s);
                }
                in.close();
                System.out.println("Response:");
                System.out.println(response.toString());
            } else { 
                System.out.println("Gagal akses");
            }
            conn.disconnect();               
        } catch (Exception e) {
            e.printStackTrace();
        }





    }
    
}
