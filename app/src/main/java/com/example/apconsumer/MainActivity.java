package com.example.apconsumer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        new Task().execute("http://172.17.36.175:81/api/Books");
    }
    class Task extends AsyncTask<String,Void, List<Book>>{
        @Override
        protected List<Book> doInBackground(String... strings) {
            List<Book> booksList = new ArrayList<Book>();
            try {
                String file = BookController.getData(new URL(strings[0]));
                booksList = BookController.getBookFromFile(file);

            } catch (MalformedURLException | JSONException e) {
                e.printStackTrace();
            }
            return booksList;
        }

        @Override
        protected void onPostExecute(List<Book> books) {
            super.onPostExecute(books);
            ArrayList<String> lv_arr = new ArrayList<String>();
            for(int i=0; i<books.size(); i++){
                lv_arr.add(books.get(i).toString());
            }
            listView.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.list_ter, lv_arr));
        }
    }
}