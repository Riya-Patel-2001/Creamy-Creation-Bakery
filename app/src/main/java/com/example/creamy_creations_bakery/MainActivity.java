package com.example.creamy_creations_bakery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.creamy_creations_bakery.Adapters.MainAdapter;
import com.example.creamy_creations_bakery.Models.MainModel;
import com.example.creamy_creations_bakery.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.caremal_cake, "Caramel Cake", "10",
                "Caramel cake is a wonderfully sweet and buttery cake flavored with burnt sugar syrup."));

        list.add(new MainModel(R.drawable.choco_berry_cake, "Choco Berry Cake", "11",
                "Take advantage of the season's berry best by making this delicious choco-berry surprise cake topped with cherries."));

        list.add(new MainModel(R.drawable.choco_cake, "Choco Cake", "9",
                "Topped with chocolate buttercream and chocolate chips for 3X the chocolate flavour."));

        list.add(new MainModel(R.drawable.chocolate_truffle, "Chocolate Truffle Cake", "12",
                "The layers of chocolate cake are filled with layers of chocolate truffle, which is super similar to chocolate ganache."));

        list.add(new MainModel(R.drawable.chocolate_vanilla_cake, "Chocolate Vanilla Cake", "8",
                "Soft and fluffy vanilla cake, sandwiched between two layers of chocolate, Now you don't have to choose between vanilla and chocolate, you will get both in one cake."));

        list.add(new MainModel(R.drawable.lemon_cake, "Lemon Cake", "9",
                "A lemon cake with juicy filling inside and a dreamy swiss meringue buttercream outside."));

        list.add(new MainModel(R.drawable.strawberry_cheesecake, "Strawberry CheeseCake", "10",
                "A strawberry cheesecake will give classic and an elegant twist."));

        list.add(new MainModel(R.drawable.white_chocolate_cake, "White Chocolate Cake", "11",
                "Famous signature recipe made with delicious white chocolate."));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}