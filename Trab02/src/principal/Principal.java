package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import util.Posicao;

public class Principal {

	public static void main(String[] args) throws Exception {
		int a = somar(13, 8);
		
		// Declara��o
		int[][] matrizA, matrizB, matrizConvolucao;
		Posicao posicaoCentralB;
		int i, j;
		
		// Obten��o das matrizes
		matrizA = getMatriz("matrizA.dat");
		matrizB = getMatriz("matrizB.dat");		
		
		matrizConvolucao = new int[matrizA.length][matrizA[0].length];
		
		// Execu��o das convolu��es
		posicaoCentralB = getPosicaoCentral(matrizB);
		
		for (i=0; i<matrizA.length; i++) {
			for (j=0; j<matrizA[i].length; j++) {
				matrizConvolucao[i][j] = getConvolucao(matrizA, matrizB, new Posicao(i, j));
			}
		}
		
		// Impress�o da matriz
		imprimeMatriz(matrizConvolucao);
		
	}

	private static int getConvolucao(int[][] matrizA, int[][] matrizB, Posicao posicaoCentral) {
		int iA, iB, jA, jB, z, dimensaoMetade;
		
		z = 0;		
		dimensaoMetade = matrizB.length/2;
		for (iA=posicaoCentral.getPosLinha()-dimensaoMetade, iB=0;
				iB<matrizB.length; 
				iA++, iB++) {
			for (jA=posicaoCentral.getPosColuna()-dimensaoMetade, jB=0;
					jB<matrizB[iB].length; 
					jA++, jB++) {
				
					if (iA < 0 || iA >= matrizA.length ||
							jA < 0 || jA >= matrizA[iA].length )
						continue;
					
					z += multiplicar(matrizA[iA][jA], matrizB[iB][jB]);
			}
		}
		
		return z;
	}

	private static int multiplicar(int termo1, int termo2) {
		int i, resultado;
		
		resultado = 0;
		for (i=0; i<32; i++) {
			if (termo2 % 2 == 1) {
				resultado += termo1;
			}
			termo2 = termo2 >> 1;
			termo1 = termo1 << 1;
		}
		
		return resultado;
	}
	
	private static int somar(int a, int b) {
		return a+b;
		
		/*int soma;
		
		soma = parcela1;
		
		while (parcela2 > 0) {
			soma = soma ^ parcela2;
			parcela2 = (parcela2 & soma) << 1; 
		}
		
		return soma;
		
        int c= 0;
        int r= 0;
        int t= ~0;
        for (t= ~0; t != 0; t>>= 1)
         {
                r<<= 1;
                r|= (a^b^c)&1;
                c= ((a|b)&c|a&b)&1;
                a>>= 1;
                b>>= 1;
         }
        for (t= ~0, c= ~t; t != 0; t>>= 1)
         {
                c<<= 1;
                c|= r&1;
                r>>= 1;
         }
        return c;*/
	}

	private static void imprimeMatriz(int[][] matriz) {
		int i, j;
		
		for (i=0; i<matriz.length; i++) {
			for (j=0; j<matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "  ");
			}
			System.out.println();
		}		
	}

	private static Posicao getPosicaoCentral(int[][] matriz) {
		// Declara��o
		Posicao posicaoCentral;
		int dimensaoMetade;
				
		dimensaoMetade = matriz.length/2;
		posicaoCentral = new Posicao(dimensaoMetade, dimensaoMetade);
		
		return posicaoCentral;
	}

	private static int[][] getMatriz(String arquivo) throws IOException {
		// Declara��o
		int linhas, colunas, i, j;
		int[][] matriz;
		String[] linha;
		BufferedReader fluxo;
		
		fluxo = new BufferedReader(new FileReader(arquivo));
		
		linha = fluxo.readLine().split(" ");
		
		linhas = Integer.parseInt(linha[0]);
		colunas = Integer.parseInt(linha[1]);
		matriz = new int[linhas][colunas];
		
		for (i=0; i<linhas; i++) {
			matriz[i] = new int[colunas];
			linha = fluxo.readLine().split(" ");
			
			for (j=0; j<colunas; j++) {
				matriz[i][j] = Integer.parseInt(linha[j]);
			}
		}
		
		fluxo.close();
		
		return matriz;
	}

}
