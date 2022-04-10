package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
    MovieManager manager = new MovieManager();


    public void fillWithFilms(MovieManager manager) {
        manager.add(new Movie("img1", "Бладшот", "боевик"));
        manager.add(new Movie("img2", "Вперед", "мультфильм"));
        manager.add(new Movie("img3", "Отель \"Белград\"", "комедия"));
        manager.add(new Movie("img4", "Джентельмены", "боевик"));
        manager.add(new Movie("img5", "Человек-Невидимка", "ужасы"));
    }

    @Test
    public void shouldCheckLastMovie() {
        MovieManager manager = new MovieManager(1);
        this.fillWithFilms(manager);
        String expected = "Человек-Невидимка";
        String actual = manager.getFromTheLast()[0].getName();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckDefaultLimit() {
        int expected = 10;
        int actual = manager.limit;
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
        int actual = manager.limit;
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
}
