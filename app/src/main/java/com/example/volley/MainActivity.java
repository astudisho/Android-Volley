package com.example.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private TextView tvContent;
    private RequestQueue rqQueue;
    private final String Url = "http://www.google.com";
    private final CharSequence ErrorMessage = "Error retrieving info from web";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = findViewById(R.id.tvContent);
        rqQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                Url,
                this.GetResponseListener(),
                this.GetErrorListener()
        );

        rqQueue.add(stringRequest);
    }

    private Response.Listener GetResponseListener(){
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tvContent.setText(response);
            }
        };
    }

    private  Response.ErrorListener GetErrorListener(){
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText( getApplicationContext(), ErrorMessage, Toast.LENGTH_LONG).show();
            }
        };
    }
}
