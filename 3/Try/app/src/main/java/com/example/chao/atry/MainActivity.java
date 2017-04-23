package com.example.chao.atry;

import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;

import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "info";


    TextView textView;
    String page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.TextView);

        new MyAsyncTask().execute();


    }


    private class MyAsyncTask extends AsyncTask<String,String,String> {

        protected String doInBackground(String... agrs) {

            try {

                URL url = new URL("http://www.chemistwarehouse.com.au/search?searchtext=healthy%20care%20grape&searchmode=allwords");
                URLConnection con = url.openConnection();
                InputStream in = con.getInputStream();
                String encoding = con.getContentEncoding();
                encoding = encoding==null?"UTF-8":encoding;
                String body = IOUtils.toString(in,encoding);

                page = body;

                ArrayList<String> prices;
                ArrayList<String> names;
                prices=findPrice(page);
                names=findName(page);

                page="";




                if(prices!=null && names!=null){
                    for(int i=0;i<prices.size();i++){

                     page=page+"name:\t"+names.get(i)+"  \tprice:\t"+prices.get(i)+"\n\n";

                    }
                }
                if(page.equals("")){
                    page="Not found!";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }


        protected ArrayList<String> findName(String page){

            String name ="";
            ArrayList<String> names=new ArrayList<>();

            String[] page0;

            page0=page.split("<div class=\"product-name\">");

            if(page0.length!=1) {
                for (int i = 1; i < page0.length; i++) {
                    String temp="";
                    name="";
                    if(page0[i].contains("</div>")){
                        temp=page0[i].split("</div>")[0];
                    }

                   String[] tt = temp.split("<span class=\"searchHighlight\">");

                    ArrayList<String> n = new ArrayList<>(Arrays.asList(tt));
                    for(int j=0;j<tt.length;j++){

                        String[] t = tt[j].split("</span>");

                        for (int k=0;k<t.length;k++){
                            name=name+t[k];
                        }
                    }

                    names.add(name);
                }

            }



            if(names.size()!=0) {
                return names;
            }else{
                return null;
            }
        }


        protected ArrayList<String> findPrice(String page){

            String price="";
            ArrayList<String> prices=new ArrayList<>();

            String[] page0;

            page0=page.split("<div class=\"prices\">");

            if(page0.length!=1) {
                for (int i = 1; i < page0.length; i++) {

                    if(page0[i].contains("<span class=\"Price\">")){
                        price=page0[i].split("<span class=\"Price\">")[1];
                    }
                    if(price.contains("\n")){
                        price=price.split("\n")[0];
                    }

                    prices.add(price);
                }
            }



            if(prices.size()!=0){
                return prices;
            }else {
                return null;

            }
        }


        protected void onPostExecute(String result){

            textView.setText(page);

        }

    }


}
