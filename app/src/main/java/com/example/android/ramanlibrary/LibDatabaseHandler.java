package com.example.android.ramanlibrary;

import android.database.sqlite.SQLiteOpenHelper;

import android.database.sqlite.SQLiteDatabase;

import android.content.Context;

import android.database.Cursor;

import android.content.ContentValues;

import java.util.List;

import java.util.ArrayList;


/**
 * Created by SanjanaRaman on 7/8/18.
 */

public class LibDatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bookDB.db";
    public static final String TABLE_BOOKS = "Book";
    //public static final int COLUMN_ID = "ID";
    //public static final int COLUMN_ID = 0;
    public static final String COLUMN_TITLE = "BookTitle";
    public static final String COLUMN_AUTHOR = "BookAuthor";
 //   public static final String COLUMN_GENRE = "BookGenre";

    public LibDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_BOOKS + "(" + COLUMN_TITLE
                + " TITLE, " + COLUMN_AUTHOR + " AUTHOR);";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);

        onCreate(db);
    }

    public void addBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_AUTHOR, book.getAuthor());
        values.put(COLUMN_TITLE, book.getTitle());
     //   values.put(COLUMN_GENRE, String.valueOf(book.getGenre()));
        db.insert(TABLE_BOOKS, null, values);
        db.close();
    }
    public Book findWithTitle(String title) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * FROM " + TABLE_BOOKS + "WHERE" + COLUMN_AUTHOR + " = " + "'" + title + "'";
        Cursor cursor = db.rawQuery(query, null);
        Book book = new Book();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            book.setTitle(cursor.getString(0));
            book.setAuthor(cursor.getString(1));
            cursor.close();
        } else {
            book = null;
        }
        db.close();
        return book;
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();

        String selectQuery = "SELECT * FROM" + TABLE_BOOKS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));

                bookList.add(book);
            } while (cursor.moveToNext());
        }
        return bookList;
    }


/*    public boolean updateBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_AUTHOR, book.getAuthor());
        values.put(COLUMN_TITLE, book.getTitle());
        return db.update(TABLE_BOOKS, values, COLUMN_TITLE + " =? ",
                new String[]{String.valueOf(book.getTitle())});
    }
*/

 /*   public void deleteBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BOOKS, COLUMN_AUTHOR + "=?", new String[](Strin))
    }
*/

    public int getBookCount() {
        String countQuery = "SELECT * FROM" + TABLE_BOOKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
}
