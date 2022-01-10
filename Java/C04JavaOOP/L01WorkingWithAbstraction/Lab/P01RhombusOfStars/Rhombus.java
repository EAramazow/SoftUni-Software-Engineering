package L01WorkingWithAbstraction.Lab.P01RhombusOfStars;

public class Rhombus {
   private final int n;

    public Rhombus (int n) {
        this.n = n;

    }

    public String getFigure() {

       return printTop() + printMiddle() + printBottom();

    }

    private String printTop() {

        StringBuilder out = new StringBuilder();

        for (int r = 1; r < n; r++) {
            out.append( repeatAndPrintString(n - r, " "))
                    .append(repeatAndPrintString(r, "* "))
                    .append(System.lineSeparator());
        }

        return out.toString();
    }




    private String printMiddle() {

    return    repeatAndPrintString(n, "* ") + System.lineSeparator();

    }

    private String printBottom() {
        StringBuilder out = new StringBuilder();

        for (int r = 1; r < n; r++) {
           out.append( repeatAndPrintString(r, " "))
                   .append(repeatAndPrintString(n - r, "* "))
                   .append(System.lineSeparator());
        }

        return out.toString();
    }



    private String repeatAndPrintString(int count, String str) {

        return str.repeat(count);
    }

}
