package com.example.michael.browserkoreanmovies;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.readystatesoftware.android.sqliteassethelper.BuildConfig;

public class MyCursorAdapter extends CursorAdapter {

    public MyCursorAdapter(Context context, Cursor cursor, int flags) {

        super(context, cursor, 0);
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    public void bindView(View view, Context context, Cursor cursor) {

        TextView FullPlotWidget = (TextView) view.findViewById(R.id.FullPlot);
        TextView GenreWidget = (TextView) view.findViewById(R.id.Genre);
        TextView imdbRatingWidget = (TextView) view.findViewById(R.id.imdbRating);
        TextView ReleasedWidget = (TextView) view.findViewById(R.id.Released);
        TextView TitleWidget = (TextView) view.findViewById(R.id.Title);

        String Awards = cursor.getString(cursor.getColumnIndexOrThrow("Awards"));
        String Country = cursor.getString(cursor.getColumnIndexOrThrow("Country"));
        String Director = cursor.getString(cursor.getColumnIndexOrThrow("Director"));
        String FullPlot = cursor.getString(cursor.getColumnIndexOrThrow("FullPlot"));
        String Genre = cursor.getString(cursor.getColumnIndexOrThrow("Genre"));
        String ID = cursor.getString(cursor.getColumnIndexOrThrow("ID"));
        String imdbRating = cursor.getString(cursor.getColumnIndexOrThrow("imdbRating"));
        String imdbVotes = cursor.getString(cursor.getColumnIndexOrThrow("imdbVotes"));
        String lastUpdated = cursor.getString(cursor.getColumnIndexOrThrow("lastUpdated"));
        String Language = cursor.getString(cursor.getColumnIndexOrThrow("Language"));
        String Metacritic = cursor.getString(cursor.getColumnIndexOrThrow("Metacritic"));
        String Poster = cursor.getString(cursor.getColumnIndexOrThrow("Poster"));
        String Plot = cursor.getString(cursor.getColumnIndexOrThrow("Plot"));
        String Rating = cursor.getString(cursor.getColumnIndexOrThrow("Rating"));
        String Released = cursor.getString(cursor.getColumnIndexOrThrow("Released"));
        String Runtime = cursor.getString(cursor.getColumnIndexOrThrow("Runtime"));
        String Writer = cursor.getString(cursor.getColumnIndexOrThrow("Writer"));
        String Title = cursor.getString(cursor.getColumnIndexOrThrow("Title"));

        TitleWidget.setText(Title + " (" + parseDate(Released) + ")");
        GenreWidget.setText(parseGenre(Genre) + " | " + parseDirector(Director));
        imdbRatingWidget.setText(parseRating(imdbRating) + " on IMDB with " + parseVotes(imdbVotes) + " votes");
        FullPlotWidget.setText("\n" + parsePlot(Plot, FullPlot) + "\n");
    }

    public String parseDate(String date) {
        if (date.equals(BuildConfig.FLAVOR)) {
            return "Date Unavailable";
        }
        return date.split("-")[0];
    }

    public String parseGenre(String genre) {
        if (genre.equals(BuildConfig.FLAVOR)) {
            return "Genre Unavailable";
        }
        return genre;
    }

    public String parseDirector(String genre) {
        if (genre.equals(BuildConfig.FLAVOR)) {
            return "Director Unavailable";
        }
        return genre;
    }

    public String parseRating(String rating) {
        if (rating.equals(BuildConfig.FLAVOR)) {
            return "?";
        }
        return rating;
    }

    public String parseVotes(String votes) {
        if (votes.equals(BuildConfig.FLAVOR)) {
            return "?";
        }
        return votes;
    }

    public String parsePlot(String plot, String FullPlot) {
        if (FullPlot.isEmpty() && plot.isEmpty()) {
            return "No plot information available";
        }
        return plot;
    }
}
