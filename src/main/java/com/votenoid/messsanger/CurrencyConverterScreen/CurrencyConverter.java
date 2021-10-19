package com.votenoid.messsanger.CurrencyConverterScreen;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.votenoid.messsanger.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrencyConverter extends AppCompatActivity {

    private TextView body;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.currency_converter);
        body = findViewById(R.id.body);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi placeHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<User>> callUsers = placeHolderApi.getUsers();
        callUsers.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> data = response.body();
                    StringBuilder builder = new StringBuilder();
                    for (User users : data) {
                        String textBox = users.getEmail() + "/n";
                        builder.append(textBox);
                    }
                    body.setText(builder.toString());

                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });


    }
}
