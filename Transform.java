public class Transform {

  public static void negative(Image img) {
    for (int i = 0; i < img.getNumRows(); i++) {
      for (int j = 0; j < img.getNumCols(); j++) {
        img.setPixel(i, j, img.getMaxValue() - img.getPixel(i, j));
      }
    }
  }

  public static Image arteASCII(Image in, int nCol, int nRow, String ascii){
    int projRow = 0;
    int projCol = 0;
    int scale = 0;
    Image out = new Image(nRow, nCol, in.getMaxValue());
    for (int i = 0; i < nRow; i++) {
      for (int j = 0; j < nCol; j++) {
        if(projCol <= in.getNumCols() && projRow <= in.getNumRows()){
          out.pixels[i][j] = in.pixels[projRow][projCol];
          scale++;
          System.out.println(scale);
        }
        projCol += in.getNumCols() / nCol;
      }
      projCol = 0;
      projRow += in.getNumRows() / nRow;
    }
    return out;
  }

  public static Image convolucao(Image In) {
    Image Out = new Image(In.getNumRows(), In.getNumCols(), In.getMaxValue());
    for (int i = 1; i < In.getNumRows() - 1; i++) {
      for (int j = 1; j < In.getNumCols() - 1; j++) {
        int sum = 0;
        for (int y = -1; y <= 1; y++) {
          for (int x = -1; x <= 1; x++) {
            sum += In.pixels[i + y][j + x];
          }
        }
        Out.pixels[i][j] = sum / 9;
      }
    }
    return Out;
  }
}
