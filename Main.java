public class Main {

  public static void main(String[] args) {
    Image img = new Image(args[0]);
    int nCol = Integer.parseInt(args[1]);
    int nRow = Integer.parseInt(args[2]);
    String ascii = args[3];
    Image out;
    out = Transform.arteASCII(img, nCol, nRow, ascii);
    // Transform.negative(img);
    out = Transform.convolucao(img);
    out.saveToFile("result");
  }
}
