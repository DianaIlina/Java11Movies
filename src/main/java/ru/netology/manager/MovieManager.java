package ru.netology.manager;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int limit;

    public int getLimit() {
        return limit;
    }

    public MovieManager() {
        this.limit = 10;
    }

    public MovieManager(int newLimit) {
        this.limit = newLimit;
    }

    public void add(Movie newMovie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = newMovie;
        movies = tmp;
    }

    public Movie[] findAll() {
        for (Movie movie : movies) {
            System.out.println(movie.getName());
        }
        return movies;
    }

    public int findLastLength() {
        int resultLength;
        if (movies.length > limit) {
            resultLength = limit;
        } else {
            resultLength = movies.length;
        }
        return resultLength;
    }

    public Movie[] findLast() {
        Movie[] result = new Movie[this.findLastLength()];
        for (int i = 0; i < result.length; i++) {
            result[i] = movies[movies.length - 1 - i];
            System.out.println(result[i].getName());
        }
        return result;
    }

}
