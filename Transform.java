public class Transform {

  /**
   * Transform a .pgm image into an ASCII art
   * @param in input image
   * @param nCol number of columns
   * @param nRow number of rows
   * @param ascii string of characters to be used
   * @return output image
   */
  public static Image arteASCII(Image in, int nCol, int nRow, String ascii){
    int projRow = 0;  // column projection
    int projCol = 0;  // row projection
    int scale = in.getMaxValue() / ascii.length(); // scale of the ascii characters
    Image out = new Image(nRow, nCol, in.getMaxValue());

    for (int i = 0; i < nRow; i++) {
      for (int j = 0; j < nCol; j++) {
        if(projCol <= in.getNumCols() && projRow <= in.getNumRows()){
          out.pixels[i][j] = in.pixels[projRow][projCol];
          for(int s = 0; s < ascii.length(); s++){
            if(out.pixels[i][j] >= s * scale && out.pixels[i][j] < (s + 1) * scale){
              out.pixels[i][j] = ascii.charAt(s);
            }
          }
        }
        projCol += in.getNumCols() / nCol;
      }
      projCol = 0;
      projRow += in.getNumRows() / nRow;
    }
    return out;
  }
}
