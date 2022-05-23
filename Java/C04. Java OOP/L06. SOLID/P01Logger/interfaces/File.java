package L06SOLID.Exercise.P01Logger.interfaces;

public interface File {

    int getSize();
    boolean write(String text);
    void append(String text);

}
