import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solucion {
	
	public int mayoresQueColsParProm(int n, int m) {
		
		int[][] matriz = new int [n][m];
		int contColumnasPar = 0;
		int sumaColumnasPar = 0;
		double promColumnasPar;
		List<Integer> totalesColumnas = new ArrayList<>();
		
		for (int j = 0; j < m; j++) {
			int totalColumna = 0;
			for(int i = 0; i < n; i++) {
				Random random = new Random();
				matriz[i][j] = random.ints(1, (n * m + 1)).limit(1).findFirst().getAsInt();
				totalColumna += matriz[i][j];
			}
			totalesColumnas.add(totalColumna);
			if ((j + 1) % 2 == 0) {
				sumaColumnasPar += totalColumna;
				contColumnasPar ++;
			}
		}
		
		promColumnasPar = sumaColumnasPar/contColumnasPar;
		return (int) totalesColumnas.stream().filter(x -> x > promColumnasPar).count();
		
	}
	
}
