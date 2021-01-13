package org.sla;

import java.io.File;
import java.util.Scanner;

class HomeVideo extends Film {
    // Fields
    private String releaseDate;
    private int allSales;
    private int vhsSales;
    private int dvdSales;
    private int bluraySales;

    // Constructors
    HomeVideo(int rank, String title, long gross, String releaseDate, int allSales, int vhsSales, int dvdSales, int bluraySales) {
        super(rank, title, gross);
        this.releaseDate = releaseDate;
        this.allSales = allSales;
        this.vhsSales = vhsSales;
        this.dvdSales = dvdSales;
        this.bluraySales = bluraySales;
    }

    // Setters/Getters

    String getReleaseDate() {
        return releaseDate;
    }

    void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    int getAllSales() {
        return allSales;
    }

    void setAllSales(int allSales) {
        this.allSales = allSales;
    }

    int getVhsSales() {
        return vhsSales;
    }

    void setVhsSales(int vhsSales) {
        this.vhsSales = vhsSales;
    }

    int getDvdSales() {
        return dvdSales;
    }

    void setDvdSales(int dvdSales) {
        this.dvdSales = dvdSales;
    }

    int getBluraySales() {
        return bluraySales;
    }

    void setBluraySales(int bluraySales) {
        this.bluraySales = bluraySales;
    }

    // Methods
    public String toString() {
        String description = "Home Video rank #" + this.getRank();
        description = description + " is \"" + this.getTitle() + "\"";
        description = description + " (released " + this.getReleaseDate();
        description = description + ") grossing $" + this.getGross();
        description = description + " (based on " + this.getAllSales() + " sales)";
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
        int ranking = 1;
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            Scanner lineScanner = new Scanner(str);
            // scan data files line by separating text between tabs \t
            lineScanner.useDelimiter("\t");

            String title = lineScanner.next();

            String date = lineScanner.next();

            String allSales = lineScanner.next();
            allSales = allSales.replaceAll(",", "").trim();
            int salesNum = Integer.parseInt(allSales);

            String vhsSales = lineScanner.next();
            if (vhsSales.contains("N/A")) {
                vhsSales = "0";
            }
            if (vhsSales.contains("[")) {
                vhsSales = vhsSales.substring(0, vhsSales.indexOf("["));
            }
            vhsSales = vhsSales.replaceAll(",", "").trim();
            int vhsSalesNum = Integer.parseInt(vhsSales);

            String dvdSales = lineScanner.next();
            if (dvdSales.contains("N/A")) {
                dvdSales = "0";
            }
            if (dvdSales.contains("[")) {
                dvdSales = dvdSales.substring(0, dvdSales.indexOf("["));
            }
            dvdSales = dvdSales.replaceAll(",", "").trim();
            int dvdSalesNum = Integer.parseInt(dvdSales);

            String bluraySales = lineScanner.next();
            if (bluraySales.contains("N/A")) {
                bluraySales = "0";
            }
            if (bluraySales.contains("[")) {
                bluraySales = bluraySales.substring(0, bluraySales.indexOf("["));
            }
            bluraySales = bluraySales.replaceAll(",", "").trim();
            int bluraySalesNum = Integer.parseInt(bluraySales);

            String revenue = lineScanner.next();
            revenue = revenue.substring(1, revenue.indexOf("[")).replaceAll(",", "").trim();
            long revenueNum = Long.parseLong(revenue);

            new HomeVideo(ranking, title, revenueNum, date, salesNum, vhsSalesNum, dvdSalesNum, bluraySalesNum);
            ranking = ranking + 1;
        }
    }
}
