package ru.netology.manager;

public class MovieManager {
    public Movie[] movies = new Movie[0];
    int limit;

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
            tmp[0] = movies[0];
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

    public Movie[] getFromTheLast() {
        Movie[] result = new Movie[this.findLastLength()];
        for (int i = 0; i < result.length; i++) {
            result[i] = movies[movies.length - 1 - i];
            System.out.println(result[i].getName());
        }
        return result;
    }

}