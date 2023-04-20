/*+=============================================================
2 | UNIFAL = Universidade Federal de Alfenas.
3 | BACHARELADO EM CIENCIA DA COMPUTACAO.
4 | Trabalho . . : Imagem ASCII
5 | Disciplina . : Processamento de Imagens
6 | Professor. . : Luiz Eduardo da Silva
7 | Aluno . . . .: Gabriel Francelino Nascimento
8 | Data . . . . : 02/05/2023
9 +=============================================================*/

public class Main {

  public static void main(String[] args) {
    Image img = new Image(args[0]);
    int nCol = Integer.parseInt(args[1]);
    int nRow = Integer.parseInt(args[2]);
    String ascii = args[3];
    Image out;
    
    out = Transform.arteASCII(img, nCol, nRow, ascii);
    out.saveToFile("result");
  }
}
