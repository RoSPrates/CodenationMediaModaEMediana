package concluidos;

import java.util.Arrays;

public class Utils {

    public int average(int... intArr) {
        int soma = 0;
        for (int i : intArr) {
            soma += i;
        }
        return soma / intArr.length;
    }

    public int median(int... arr) {
        quickSort(0, arr.length - 1,arr);
        mostraVetor(arr);
        return arr.length % 2 == 1 ? arr[arr.length / 2] : (arr[arr.length / 2] + arr[(arr.length / 2) - 1]) / 2;
    }

    public int mode(int... arr) {
        int mais = 0, aux = 1, pos = -1;
        quickSort(0, arr.length - 1,arr);
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                aux++;
                continue;
            }
            if (aux > mais) {
                pos = i;
                mais = aux;
            }
            aux = 1;
        }
        return arr[pos];
    }

    private int separar(int inicio, int fim,int... vetor) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[f])
                f--;
            else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    private void quickSort(int inicio, int fim, int... vetor) {
        if (inicio < fim) {
            int posicaoPivo = separar(inicio, fim, vetor);
            quickSort(inicio, posicaoPivo - 1,vetor);
            quickSort(posicaoPivo + 1, fim,vetor);
        }
    }

    public void mostraVetor(int... arr) {
        for (int i : arr) System.out.print(i + " |");
        System.out.println("\n" + arr.length);
    }


}
