package com.remine.elibrary.utils;

import com.remine.elibrary.R;
import com.remine.elibrary.models.Book;
import com.remine.elibrary.models.News;

import java.util.ArrayList;
import java.util.List;

public class BookData {

    public static List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book(
                1,
                "The Psychology of Money",
                "Morgan Housel",
                R.drawable.book_psychology,
                "Free",
                4.8f,
                "Doing well with money isn't necessarily about what you know. It's about how you behave. And behavior is hard to teach, even to really smart people. The Psychology of Money is an essential read for anyone interested in being better with money. Fast-paced and engaging, this book will teach you how to have a better relationship with money and to make smarter financial decisions."
        ));

        books.add(new Book(
                2,
                "The 7 Habits of Highly Effective People",
                "Stephen R. Covey",
                R.drawable.book_7habits,
                "$9.99",
                4.7f,
                "One of the most inspiring and impactful books ever written, The 7 Habits of Highly Effective People has captivated readers for 25 years. It has transformed the lives of presidents and CEOs, educators and parents—in short, millions of people of all ages and occupations."
        ));

        books.add(new Book(
                3,
                "The Alchemist",
                "Paulo Coelho",
                R.drawable.book_alchemist,
                "$8.99",
                4.6f,
                "Paulo Coelho's enchanting novel has inspired a devoted following around the world. This story, dazzling in its powerful simplicity and inspiring wisdom, is about an Andalusian shepherd boy named Santiago who travels from his homeland in Spain to the Egyptian desert in search of a treasure buried near the Pyramids."
        ));

        books.add(new Book(
                4,
                "Ikigai",
                "Héctor García",
                R.drawable.book_ikigai,
                "$7.99",
                4.5f,
                "According to the Japanese, everyone has an ikigai—a reason for living. And according to the residents of the Japanese village with the world's longest-living people, finding it is the key to a happier and longer life."
        ));

        books.add(new Book(
                5,
                "Rich Dad Poor Dad",
                "Robert Kiyosaki",
                R.drawable.book_richdad,
                "$10.99",
                4.7f,
                "Rich Dad Poor Dad is Robert's story of growing up with two dads — his real father and the father of his best friend, his rich dad — and the ways in which both men shaped his thoughts about money and investing."
        ));

        books.add(new Book(
                6,
                "Steal Like An Artist",
                "Austin Kleon",
                R.drawable.book_artist,
                "$12.99",
                4.4f,
                "An exploration of art, creativity, and the fine line between inspiration and obsession. This book delves into the minds of great artists throughout history."
        ));

        books.add(new Book(
                7,
                "Laws of UX",
                "Jon Yablonski",
                R.drawable.book_ux,
                "$24.97",
                4.6f,
                "A practical guide to apply key principles from psychology to build more intuitive, human-centered products and experiences."
        ));

        books.add(new Book(
                8,
                "A Million To One",
                "Tony Faggioli",
                R.drawable.book_million,
                "$9.97",
                4.3f,
                "A gripping thriller that explores the odds of survival and the human spirit's resilience in the face of impossible challenges."
        ));

        return books;
    }

    public static Book getBookById(int id) {
        for (Book book : getBooks()) {
            if (book.getId() == id) {
                return book;
            }
        }
        return getBooks().get(0);
    }

    public static List<News> getNews() {
        List<News> newsList = new ArrayList<>();

        newsList.add(new News(
                1,
                "5 Takeaways",
                "The Psychology of Money",
                R.drawable.news_1
        ));

        newsList.add(new News(
                2,
                "Book Review",
                "The Psychology of Money",
                R.drawable.news_2
        ));

        return newsList;
    }
}
