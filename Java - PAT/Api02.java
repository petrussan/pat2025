import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.*;

public class Api02 {
    public void getREST() throws Exception {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
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

                JSONArray myArray = new JSONArray(response.toString());
                for (int i=0;i<myArray.length();i++) {
                    JSONObject o = myArray.getJSONObject(i);
                    System.out.print("Title: ");
                    System.out.println(o.getString("title"));
                }

            } else { 
                System.out.println("Gagal akses");
            }
            conn.disconnect();               
        }


    }
    
}
