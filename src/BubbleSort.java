public class BubbleSort {
    public static void main(String[] args) {
        int [] vetor = new int [10];

        System.out.println("Vetor desordenado:");
        for(int i=0;i<vetor.length;i++) {
            vetor[i]= (int) (Math.random() * vetor.length);
            System.out.print(vetor[i] + " "); // Use print para manter na mesma linha
        }
        System.out.println("\n"); // Nova linha para separar

        // Algoritmo BubbleSort
        int aux;
        // O loop externo garante múltiplas passagens
        for(int i=0;i<vetor.length-1;i++) { // Percorre até o penúltimo elemento
            // O loop interno compara e troca adjacentes
            // A cada passagem, o maior elemento 'borbulha' para o final
            for(int j=0;j<vetor.length-1-i;j++) { // Reduz o escopo a cada passagem
                // Compara elementos adjacentes
                if(vetor[j] > vetor[j+1]){ // Compara o elemento atual com o próximo
                    // Trocando os elementos de posição corretamente
                    aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }

        System.out.println("Vetor ordenado!");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println(); // Nova linha final
    }
}