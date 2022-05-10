package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
    MovieManager manager = new MovieManager();

    Movie movie1 = new Movie("img1", "Бладшот", "боевик");
    Movie movie2 = new Movie("img2", "Вперед", "мультфильм");
    Movie movie3 = new Movie("img3", "Отель \"Белград\"", "комедия");
    Movie movie4 = new Movie("img4", "Джентельмены", "боевик");
    Movie movie5 = new Movie("img5", "Человек-Невидимка", "ужасы");


    public void fillWithFilms(MovieManager manager) {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

    }

    @Test
    public void shouldCheckLastMovie() {
        this.fillWithFilms(manager);
        String expected = "Человек-Невидимка";
        String actual = manager.findLast()[0].getName();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckDefaultLimit() {
        int expected = 10;
        int actual = manager.getLimit();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckBelowDefaultLimit() {
        this.fillWithFilms(manager);
        int expected = 5;
        int actual = manager.findLastLength();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetLimit() {
        MovieManager manager = new MovieManager(4);
        this.fillWithFilms(manager);
        int expected = 4;
        int actual = manager.getLimit();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckBelowLimit() {
        MovieManager manager = new MovieManager(7);
        this.fillWithFilms(manager);
        int expected = 5;
        int actual = manager.findLastLength();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetFromTheLast() {
        MovieManager manager = new MovieManager(3);
        this.fillWithFilms(manager);

        Movie[] expected = {movie5, movie4, movie3};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}
