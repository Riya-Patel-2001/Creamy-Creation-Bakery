package com.example.creamy_creations_bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.creamy_creations_bakery.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    RadioGroup radioGroup;
    Button btnConfirmPayment;
    Button insertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        insertBtn = findViewById(R.id.insertBtn);
        radioGroup = findViewById(R.id.radio_group);
        btnConfirmPayment = findViewById(R.id.btnConfirmPayment);

        final int image = getIntent().getIntExtra("image",0);
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("desc");

        binding.detailImage.setImageResource(image);
        binding.priceLbl.setText(String.format("%d", price));
        binding.foodName.setText(name);
        binding.detailDescription.setText(description);

        DBHelper helper = new DBHelper(this);

        binding.insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean isInserted = helper.insertOrder(
                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        name,
                        description
                        );
               if(isInserted){
                   Toast.makeText(DetailActivity.this,"Data Success",Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(DetailActivity.this,"Error",Toast.LENGTH_SHORT).show();
               }
            }
        });

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, OrderActivity.class));
            }
        });

        btnConfirmPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                if(checkedId == -1){
                    Message.message(getApplicationContext(),"Please select one payment method");
                }
                else{
                    findRadioButton(checkedId);
                }
            }
        });



    }

    public void findRadioButton(int checkedId) {
        switch (checkedId){
            case R.id.radio_one:
                Message.message(getApplicationContext(),"Payment through Visa card");
                break;
            case R.id.radio_three:
                Message.message(getApplicationContext(),"Payment through Google Pay");
                break;
        }
    }
}