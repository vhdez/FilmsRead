package org.sla;

import java.io.File;
import java.util.Scanner;

class BoxOfficeFilm extends Film {
    // Fields
    private int releaseYear;
    private int peak;

    // Constructors
    BoxOfficeFilm(int rank, String title, int releaseYear, long gross, int peak) {
        super(rank, title, gross);
        this.releaseYear = releaseYear;
        this.peak = peak;
    }

    // Setters/Getters
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    int getPeak() {
        return peak;
    }

    void setPeak(int peak) {
        this.peak = peak;
    }

    // Methods
    public String toString() {
        String description = "Box Office ranking #" + this.getRank();
        description = description + " is \"" + this.getTitle() + "\"" ;
        description = description + " from year " + this.getReleaseYear();
        description = description + " grossing $" + this.getGross();
        description = description + " and peaking at rank #" + this.getPeak();
        return description;
    }

    static void read(String datafilePath) {
        // scan data file line-by-line
        File dataFile = new File(datafilePath);
        Scanner scanner;
        try {
            scanner = new Scanner(dataFile);
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            Scanner lineScanner = new Scanner(str);
            // scan data files line by separating text between tabs \t
            lineScanner.useDelimiter("\t");

            int ranking = lineScanner.nextInt();

            int highest = lineScanner.nextInt();

            String title = lineScanner.next();

            String revenue = lineScanner.next();
            if (revenue.contains("$")) {
                revenue = revenue.substring(revenue.indexOf("$")+1, revenue.length());
            }
            revenue = revenue.replaceAll(",", "").trim();
            long revenueNum = Long.parseLong(revenue);

            int year = lineScanner.nextInt();

            new BoxOfficeFilm(ranking, title, year, revenueNum, highest);
        }
    }
}
