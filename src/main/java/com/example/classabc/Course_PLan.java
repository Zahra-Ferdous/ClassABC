package com.example.classabc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Course_PLan extends AppCompatActivity {

    private TextView tv;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__plan);

        tv = findViewById(R.id.course_plan_textId);

        queue = Volley.newRequestQueue(this);

        JSONparse();
    }
    private void JSONparse(){
        String url ="https://api.myjson.com/bins/10gzxo";

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            String code,credit,prereq,hours,sub;

                            tv.append("Course Code : CSE 2200\nCredits : 1.5\nPrerequisite : None\nContact Hour : 0L + 3P Hours/Week\n\nTopics :\n");

                            JSONArray jAra = response.getJSONArray("course");

                            for(int i =0; i<jAra.length() ; i++){
                                JSONObject topic = jAra.getJSONObject(i);

                                sub = topic.getString("sub");

                                tv.append((i+1)+". "+ sub +"\n");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                } ,
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );

        queue.add(req);
    }
}
