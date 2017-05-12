package developerkampus.appcrud.config;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import developerkampus.appcrud.MainActivity;

/**
 * Created by Wambakun on 12/05/2017.
 */

public class InsertUser extends AsyncTask<String,Void,String> {
    MainActivity R = new MainActivity();

    private Context context;
    private String link = Http.url;
    public InsertUser (Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... arg0) {
        String NamaLengkap          = arg0[0];
        String Username         = arg0[1];
        String Password      = arg0[2];
        String Alamat       = arg0[3];
        String NoTelp       = arg0[4];


        String data;
        BufferedReader bufferedReader;
        String result;
        try {
            data = "?nama_lengkap=" + URLEncoder.encode(NamaLengkap, "UTF-8");
            data += "&username=" + URLEncoder.encode(Username, "UTF-8");
            data += "&password=" + URLEncoder.encode(Password, "UTF-8");
            data += "&alamat=" + URLEncoder.encode(Alamat, "UTF-8");
            data += "&notelp=" + URLEncoder.encode(NoTelp, "UTF-8");


            link = link + "insert_user.php" + data;

            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            return result;
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        String jsonStr = result;
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String query_result = jsonObj.getString("result");
                if (query_result.equals("berhasil")) {
                    Toast.makeText(context, "Register Berhasil", Toast.LENGTH_SHORT).show();
                    ((Activity)(context)).finish();
                } else if (query_result.equals("gagal")) {
                    Toast.makeText(context, query_result, Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("result", query_result);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.e("Error ", "Couldn't get any JSON data.");
        }
    }

}
