package com.example.michael.browserkoreanmovies;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "southkoreandb.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Returns cursor by votes in descending order
    public Cursor getCursor() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = new String[]{
                "0 _id", "Awards", "Country", "Director", "FullPlot", "Genre",
                "ID", "imdbRating", "imdbVotes", "lastUpdated", "Language",
                "Metacritic", "Poster", "Plot", "Rating", "Released", "Runtime", "Writer", "Title"
        };

        qb.setTables("t");
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, "CAST(imdbVotes AS INTEGER) DESC");
        c.moveToFirst();
        return c;
    }

    public Cursor getHorror() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect = new String[]{
                "0 _id", "Awards", "Country", "Director", "FullPlot", "Genre",
                "ID", "imdbRating", "imdbVotes", "lastUpdated", "Language",
                "Metacritic", "Poster", "Plot", "Rating", "Released", "Runtime", "Writer", "Title"
        };

        qb.setTables("t");
        Cursor c = qb.query(db, sqlSelect, "Genre + = 'Horror' ", null, null, null, "CAST(imdbVotes AS INTEGER) DESC");
        c.moveToFirst();
        return c;
    }
}
