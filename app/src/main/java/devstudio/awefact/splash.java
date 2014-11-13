package devstudio.awefact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class splash extends Activity {
    private static int SPLASH_TIME_OUT = 5000;
    /*Calendar c = Calendar.getInstance();
    SimpleDateFormat dd = new SimpleDateFormat("dd");
    SimpleDateFormat MM = new SimpleDateFormat("MM");
    String day = dd.format(c.getTime());
    String month = MM.format(c.getTime());*/
    String dateURL = "http://numbersapi.com/random/trivia?json";
    String triviaURL = "http://numbersapi.com/random/year?json";
    String mathURL = "http://numbersapi.com/random/date?json";
    String RandomYear = "http://numbersapi.com/random/year?json";
    /*String dateURL = "http://numbersapi.com/"+month+"/"+day+"/date?json";
    String triviaURL = "http://numbersapi.com/"+day+"?json";
    String mathURL = "http://numbersapi.com/"+day+"/math?json";*/
    Runnable context;
    public static RequestQueue rq;
    public static JsonObjectRequest jsonRequestdate;
    public static JsonObjectRequest jsonRequesttrivia;
    public static JsonObjectRequest jsonRequestmath;
    public static JsonObjectRequest jsonRandomYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                context = this;
                rq = Volley.newRequestQueue(splash.this);
                jsonRequestdate = new JsonObjectRequest(Request.Method.GET, dateURL, null, new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Object txt = response.get("text");
                            MyActivity.listoffactadapter.add(txt.toString());
                        } catch (JSONException e) {
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText((Context) context, volleyError.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

                jsonRequesttrivia = new JsonObjectRequest(Request.Method.GET, triviaURL, null, new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Object txt = response.get("text");
                            MyActivity.listoffactadapter.add(txt.toString());
                        } catch (JSONException e) {
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText((Context) context, volleyError.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

                jsonRequestmath = new JsonObjectRequest(Request.Method.GET, mathURL, null, new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Object txt = response.get("text");
                            MyActivity.listoffactadapter.add(txt.toString());
                        } catch (JSONException e) {
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText((Context) context, volleyError.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                jsonRandomYear = new JsonObjectRequest(Request.Method.GET, RandomYear, null, new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Object txt = response.get("text");
                            MyActivity.listoffactadapter.add(txt.toString());
                        } catch (JSONException e) {
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText((Context) context, volleyError.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                rq.add(jsonRequestdate);
                rq.add(jsonRequesttrivia);
                rq.add(jsonRequestmath);
                rq.add(jsonRandomYear);
                Intent i = new Intent(splash.this, MyActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
