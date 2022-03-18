package com.example.apconsumer;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BookController {
    public static String getData(URL url){
        StringBuilder sb = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = br.readLine()) != null){
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<Book> getBookFromFile(String file) throws JSONException {
        List<Book> booksList = new ArrayList<Book>();
        JSONArray jsonArray = new JSONArray(file);
        for (int i = 0; i<jsonArray.length(); i++){
            Book book = new Book();
            book.setId(jsonArray.getJSONObject(i).getInt("id"));
            book.setTitle(jsonArray.getJSONObject(i).getString("title"));
            book.setAuthor(jsonArray.getJSONObject(i).getString("author"));
            book.setCover(jsonArray.getJSONObject(i).getString("cover"));
            booksList.add(book);
        }
        return booksList;
    }
}
