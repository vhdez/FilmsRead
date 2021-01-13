package org.sla;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class BoxOfficeFilm extends Film {
    // Fields
    private int peak;

    // Constructors
    BoxOfficeFilm(int rank, String title, int releaseYear, long gross, int peak) {
        super(rank, title, gross,  releaseYear);
        this.peak = peak;
    }

    // Setters/Getters

    int getPeak() {
        return peak;
    }

    void setPeak(int peak) {
        this.peak = peak;
    }

    // Methods
    public String toString() {
        String description = "Box Office rank #" + this.getRank();
        description = description + " is \"" + this.getTitle() + "\"" ;
        description = description + " from year " + this.getYear();
        description = description + " grossing $" + this.getGross();
        description = description + " and peaking at rank #" + this.getPeak();
        return description;
    }

    static void read(String dataFilePath) {
        // try to create Scanner
        Scanner scanner = null;
        try {
            File file = new File(dataFilePath);
            scanner = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problem opening file: " + dataFilePath);
        }
        if (scanner == null) {
            // I can't scan without a scanner, so we're done.
            return;
        }

        // Read from each line in data file until there are no more
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            // Construct a new scanner for each to get its tokens
            Scanner lineScanner = new Scanner(next);
            // Data tokens are separated by tabs
            lineScanner.useDelimiter("\t");

            // There are 5 data tokens that we need for each BoxOfficeFilm
            int ranking = lineScanner.nextInt();
            int peak = lineScanner.nextInt();
            String title = lineScanner.next();
            long revenue = lineScanner.nextLong();
            int year = lineScanner.nextInt();

            Film film = new BoxOfficeFilm(ranking, title, year, revenue, peak);
        }
    }
}
