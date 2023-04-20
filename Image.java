/*+=============================================================
2 | UNIFAL = Universidade Federal de Alfenas.
3 | BACHARELADO EM CIENCIA DA COMPUTACAO.
4 | Trabalho . . : Imagem ASCII
5 | Disciplina . : Processamento de Imagens
6 | Professor. . : Luiz Eduardo da Silva
7 | Aluno . . . .: Gabriel Francelino Nascimento
8 | Data . . . . : 02/05/2023
9 +=============================================================*/

import java.io.*;
import java.util.*;

public class Image {

  private int rows;
  private int cols;
  private int maxValue;
  public int[][] pixels;

  /**
   * Constructor that creates an empty image
   * @param rows number of rows
   * @param cols number of columns
   * @param maxValue maximum value of a pixel
   */
  public Image(int rows, int cols, int maxValue) {
    this.rows = rows;
    this.cols = cols;
    this.maxValue = maxValue;
    pixels = new int[rows][cols];
  }

  /**
   * Constructor that reads the input file
   * @param filename name of file to read from
   */
  public Image(String filename) {
    try {
      Scanner infile = new Scanner(new FileReader(filename + ".pgm"));
      String filetype = infile.nextLine();
      String comment = infile.nextLine();
      if (comment.charAt(0) != '#') {
        String[] dim = comment.split(" ");
        cols = Integer.parseInt(dim[0]);
        rows = Integer.parseInt(dim[1]);
      } else {
        System.out.println(comment);
        cols = infile.nextInt();
        rows = infile.nextInt();
      }
      maxValue = infile.nextInt();

      pixels = new int[rows][cols];

      System.out.println(
        "Leitura da imagem " +
        filename +
        ".pgm, type=" +
        filetype +
        " (" +
        rows +
        " x " +
        cols +
        ")"
      );

      //Read in image
      for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
          pixels[r][c] = infile.nextInt();
        }
      }
      infile.close();
    } catch (FileNotFoundException fe) {
      System.out.println("arquivo não encontrado");
    } catch (Exception e) {
      System.out.println(e.toString() + " erro no arquivo .PGM");
      e.printStackTrace();
    }
  }

  public void setPixel(int r, int c, int value) {
    pixels[r][c] = value;
  }

  public int getPixel(int r, int c) {
    return pixels[r][c];
  }

  public int getNumCols() {
    return cols;
  }

  public int getNumRows() {
    return rows;
  }

  public int getMaxValue() {
    return maxValue;
  }

  /**
   * Save image to file
   * @param filename name of file to save to
   */
  public void saveToFile(String filename) {
    try {
      PrintWriter outfile = new PrintWriter(filename + ".txt");
      System.out.println("Escrevendo o arquivo: " + filename + ".txt");

      outfile.println("# ASCII IMAGE"); // Ascii PPM file
      outfile.println("# Image created by Image.java");

      for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
          char simbol = (char)pixels[r][c];
          outfile.print(simbol);
        }
        outfile.println("");
      }

      outfile.close();
    } catch (Exception e) {
      System.out.println(e.toString() + " erro no arquivo .PGM.");
      e.printStackTrace();
    }
  }
}
