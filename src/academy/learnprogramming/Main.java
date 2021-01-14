package academy.learnprogramming;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {


        int month = 1 + Calendar.getInstance().get(Calendar.MONTH); // TODAYS DATE
        int year = Calendar.getInstance().get(Calendar.YEAR);       // TODAYS DATE

        double stockPrice = 49.33;          // CURRENT STOCK PRICE
        double dividend = 0.41;             // CURRENT DIVIDEND

        double stockDiff = 1;
        double dividendDiff = 1;

        double investments = 100.00;        // THIS IS HOW MUCH $ YOU WANT TO INVEST INTO STOCK MONTHLY
        double balance = investments;
        int stockCount = 0;                 // THIS IS HOW MUCH STOCKS YOU HAVE AT THE BEGINNING
        int newStock;

        boolean diffs = false;              // CHANGE TO TRUE FOR SOME SMALL CHANGES IN DIVIDENDS AND STOCK PRICES

        int period = 503;                   // THIS IS HOW MANY MONTHS YOU WANT TO INVEST
        int dividendPeriod = 3;             // THIS IS HOW OFTEN THE COMPANY PAYS DIVIDENDS (3 - QUARTERLY, 6 - HALF YEAR, 12 - YEARLY)



        for(int i = 0; i<period; i++){

            if (month % dividendPeriod == 0){
                balance = balance + stockCount * dividend;
            }

            newStock = (int) ((int) balance / stockPrice);
            stockCount = stockCount + newStock;
            balance = balance - newStock * stockPrice;




            System.out.println(String.format("%02d",month) + "." + year + " Stocks: " + String.format("%03d",stockCount) + " Dividend: " + String.format("%.2f",stockCount*dividend) + " New stocks: " + newStock);


            month++;

            if(month>12){
                year++;
            }

            if (month > 12){
                month = 1;
            }

            balance = balance + investments;


                dividendDiff = ((Math.random() - 0.50) / 100.00) + 1;
                stockDiff = ((Math.random() - 0.50) / 100.00) + 1;


            if (diffs){
                stockPrice = stockPrice*stockDiff;
                dividend = dividend*dividendDiff;
                System.out.print(" Stock Price: ");
                System.out.format("%.2f",stockPrice);
                System.out.print(" Dividend: ");
                System.out.format("%.2f",dividend);

            }


        }

    }
}
