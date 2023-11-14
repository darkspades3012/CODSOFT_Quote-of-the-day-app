package com.example.quoteofthedayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private ImageView shareImageView;
    private ImageView saveImageView;

    private ImageView savedImageView;
    //private DatabaseReference ref;

    private String[] quotes = {
            "Organizing is a practice of leadership whereby we define leadership as enabling others to achieve shared purpose under conditions of uncertainty.",
            "Mobilizing others to achieve purpose under conditions of uncertainty— what leaders do—challenges the hands, the head, and the heart.",
            "How do you invest in developing leadership but not in creating dependency of that leadership upon you?",
            "Hope is the belief in the probability of the possible rather than the necessity of the probable.",
            "There’s a real sweet spot between challenge and hope – leaders make pathways that keep both firmly in view."// Add more quotes here
    };
    private List<String> savedQuotes = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quotes);
        shareImageView = findViewById(R.id.imageView2);
        saveImageView = findViewById(R.id.imageView4);
        savedImageView = findViewById(R.id.imageView);

        // Set up initial quote
        setRandomQuote();

        // Share button click listener
        shareImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentQuote = quoteTextView.getText().toString();
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"check this beautiful quote");
                intent.putExtra(Intent.EXTRA_TEXT, currentQuote);
                startActivity(Intent.createChooser(intent,"Share via"));
            }
        });


// ...

        saveImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentQuote = quoteTextView.getText().toString();
                savedQuotes.add(currentQuote);
                //FirebaseDatabase database = FirebaseDatabase.getInstance();
                //ref = database.getReference("users").child("codsoft").child("myquotes");
                //DatabaseReference quoteRef = ref.push();
                // quoteRef.setValue(currentQuote);
                Toast.makeText(saveImageView.this, "quote saved", Toast.LENGTH_SHORT).show();
            }
        });


        savedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),savedQuotes.class);
                intent.putStringArrayListExtra("savedQuotes", (ArrayList<String>) savedQuotes);
                startActivity(intent);
            }
        });

    }

    private void setRandomQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.length);
        String randomQuote = quotes[randomIndex];
        quoteTextView.setText(randomQuote);
    }
}

