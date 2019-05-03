import java.util.Arrays;
public class EightQueens {

	public static Boolean putQueens (int[] solutionCand) {
			Boolean isSolution=true;

			for(int i=0; i<7; i++) {
				int j=i+1;
				while (isSolution && j<=7) {
				
				/* Verificamos: no repetidos -> no reinas misma fila
								array[i]+i != array[j]+j -> no reinas diagonales crecientes
								array[i]-i != array[j]-j -> no reinas diagonales decrecientes */

					if ((solutionCand[i]+i != solutionCand[j]+j) && (solutionCand[i]-i != solutionCand[j]-j) && (solutionCand[i] != solutionCand[j])) {
						isSolution = true;
					} else isSolution = false;
					
					j++;
				}
			}

			return isSolution;
		}

	public static void main(String[] args) {

		int[] chessTable= new int[8];

		for (int a=0; a<8; a++) {
			for (int b=0; b<8; b++) {
				for (int c=0; c<8; c++) {
					for (int d=0; d<8; d++) {
						for (int e=0; e<8; e++) {
							for (int f=0; f<8; f++) {
								for (int g=0; g<8; g++) {
									for(int h=0; h<8; h++) {
										chessTable[0]=a;
										chessTable[1]=b;
										chessTable[2]=c;
										chessTable[3]=d;
										chessTable[4]=e;
										chessTable[5]=f;
										chessTable[6]=g;
										chessTable[7]=h;

										if (putQueens(chessTable))
											System.out.println(Arrays.toString(chessTable));
									}
								}
							}
						}
					}
				}
			}
		}

	}
}