public class InsertionSort {
    public static void main(String[] args) {

        int[] vetor = new int[10];

        // 1. Preenche o vetor aleatoriamente
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        // 2. Imprime o vetor Desordenado
        System.out.println("Desordenado");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

        // 3. Algoritmo do Insertion Sort
        // Este loop principal deve estar FORA do loop de impressão inicial
        int aux, j;
        for (int i = 1; i < vetor.length; i++) {
            // Declarando a variavel auxiliar
            aux = vetor[i];
            j = i - 1;
            // inserindo o j no algoritmo
            while (j >= 0 && vetor[j] > aux) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = aux;
        }

        // 4. Imprime o vetor Ordenado
        System.out.println("\n\nOrdenado");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}