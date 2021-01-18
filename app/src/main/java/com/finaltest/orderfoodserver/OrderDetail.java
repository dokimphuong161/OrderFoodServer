package com.finaltest.orderfoodserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.finaltest.orderfoodserver.Common.Common;
import com.finaltest.orderfoodserver.ViewHolder.OrderDetailAdapter;

public class OrderDetail extends AppCompatActivity {

    TextView order_id,order_phone,order_address,order_total,order_comment;
    String order_id_value="";
    RecyclerView lstFoods;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        order_id = (TextView) findViewById(R.id.order_id);
        order_phone = (TextView) findViewById(R.id.order_phone);
        order_address = (TextView) findViewById(R.id.order_address);
        order_total = (TextView) findViewById(R.id.order_total);
        order_comment = (TextView) findViewById(R.id.order_comment);

        lstFoods = (RecyclerView) findViewById(R.id.lstFood);
        lstFoods.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        lstFoods.setLayoutManager(layoutManager);

        if(getIntent()!=null)
            order_id_value = getIntent().getStringExtra("OrderId");

        //Set value
        order_id.setText(order_id_value);
        order_phone.setText(Common.currenRequest.getPhone());
        order_total.setText(Common.currenRequest.getTotal());
        order_address.setText(Common.currenRequest.getAddress());
        order_comment.setText(Common.currenRequest.getComment());

        OrderDetailAdapter adapter = new OrderDetailAdapter(Common.currenRequest.getFoods());
        adapter.notifyDataSetChanged();
        lstFoods.setAdapter(adapter);

    }
}