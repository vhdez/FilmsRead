package org.sla;

class FilmsRead {

    public static void main(String[] args) {
        String boxOfficeFilmsData = args[0];
        String homeVideoData = args[1];
        BoxOfficeFilm.read(boxOfficeFilmsData);
        HomeVideo.read(homeVideoData);
        Film.describeAll();
    }
}
