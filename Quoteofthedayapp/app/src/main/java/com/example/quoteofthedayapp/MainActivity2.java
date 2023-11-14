package com.example.quoteofthedayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyQuotesAdapter adapter;

    private DatabaseReference ref;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> savedQuotes = new ArrayList<>();

        // Create the adapter with an empty list initially
        adapter = new MyQuotesAdapter(savedQuotes);
        recyclerView.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("users").child("codsoft").child("myquotes");

        // Set up ValueEventListener to retrieve saved quotes
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> savedQuotes = new ArrayList<>();
                for (DataSnapshot quoteSnapshot : snapshot.getChildren()) {
                    String quote = quoteSnapshot.getValue(String.class);
                    savedQuotes.add(quote);
                }

                // Update the adapter with the retrieved quotes
                adapter.setQuotes(savedQuotes);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle the error if needed
            }


        });
    }

}


