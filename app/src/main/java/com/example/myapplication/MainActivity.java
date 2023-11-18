package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.pay).setOnClickListener(v -> pay()
        );
    }

    private void  pay(){

        Checkout co=new Checkout();

        JSONObject object=new JSONObject();

        try {
            object.put("name","Vinod mehta");
            object.put("Description","Platform for internship");
            object.put("image","");
            object.put("currency","INR");

           JSONObject prefill=new JSONObject();
           prefill.put("contact","2345678889");
            prefill.put("email","akashincollege8545@gmail.com");
            object.put("prefill",prefill);

            co.open(MainActivity.this,object);





        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this,"payment succes",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this,"payment failed",Toast.LENGTH_SHORT).show();
    }
}