package Exam24April2021;

import java.util.Scanner;

public class RoomPainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int paintBoxesNum = Integer.parseInt(scanner.nextLine());
        int rollsWallpapersNum = Integer.parseInt(scanner.nextLine());
        double priceGloves = Double.parseDouble(scanner.nextLine());
        double priceBrush = Double.parseDouble(scanner.nextLine());


        double pricePaint = 21.50;
        double priceRollsWallpaper = 5.20;

        double priceAllPaint = paintBoxesNum * pricePaint;
        double priceAllWallpapers = rollsWallpapersNum * priceRollsWallpaper;




        double neededGloves = Math.ceil(0.35 * rollsWallpapersNum);
        double neededBrush = Math.floor(0.48 * paintBoxesNum);

        double priceAllGloves = neededGloves * priceGloves;
        double priceAllBrush = neededBrush * priceBrush;

        double allSum = priceAllPaint + priceAllWallpapers + priceAllGloves + priceAllBrush;
        double finalSum = 1.0 * 1/15 * allSum;

        System.out.printf("This delivery will cost %.2f lv.", finalSum );
    }
}
