/*O Quick Sort é um dos algoritmos de ordenação mais eficientes e amplamente utilizados.
 Ele é baseado na estratégia de "dividir para conquistar", o que significa que ele quebra
 um grande problema em subproblemas menores, mais fáceis de resolver.*/

public class QuickSort {
    public static void main(String[] args) {

        int[] vetor = new int[10]; // Declara e inicializa um vetor de inteiros com 10 posições

        // Preenche o vetor com números aleatórios entre 0 e 9
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        // Imprime o vetor antes da ordenação
        System.out.print("Desordenado: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }

        // Chama o método QuickSort para ordenar o vetor.
        // O algoritmo começa com o índice 0 (primeiro elemento) e vetor.length-1 (último elemento).
        QuickSort(vetor, 0, vetor.length - 1);

        // Imprime o vetor após a ordenação
        System.out.println("\n\nVetor Ordenado:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }

    /**
     * Método principal do Quick Sort.
     * Implementa a lógica recursiva de "dividir para conquistar".
     * @param vetor O array de inteiros a ser ordenado.
     * @param esquerda O índice inicial da sub-lista a ser ordenada.
     * @param direita O índice final da sub-lista a ser ordenada.
     */
    static void QuickSort(int[] vetor, int esquerda, int direita) {
        // A condição de parada da recursão: se a sub-lista tiver 1 ou 0 elementos,
        // ela já está ordenada, então não fazemos nada.
        if (esquerda < direita) {
            // 'p' é o índice do pivô após o particionamento, ou seja, sua posição final no array ordenado.
            int p = particao(vetor, esquerda, direita);

            // Chama o QuickSort recursivamente para a sub-lista à esquerda do pivô.
            // Note que aqui está 'p', que é a posição do pivô, o que pode causar um loop infinito
            // se o pivô for o próprio 'j' retornado pela partição, fazendo com que ele seja
            // incluído na próxima chamada recursiva da esquerda. O correto seria `p-1`.
            // Ou, se a partição retorna o índice do último elemento menor que o pivô (como na Lomuto),
            // então a chamada da esquerda vai até `p-1`. No caso da partição de Hoare (usada aqui),
            // o `p` é um índice dentro da partição que precisa ser excluído.
            // A chamada correta para a partição de Hoare deveria ser:
            // QuickSort(vetor, esquerda, j);
            // QuickSort(vetor, j + 1, direita);
            QuickSort(vetor, esquerda, p);     // POTENCIAL ERRO: Esta chamada recursiva pode incluir o pivô
            QuickSort(vetor, p + 1, direita); // Chama o QuickSort recursivamente para a sub-lista à direita do pivô.
        }
    }

    /**
     * Método de particionamento (implementação do tipo Hoare Partition Scheme).
     * Ele reorganiza os elementos do vetor de tal forma que todos os elementos
     * menores ou iguais ao pivô fiquem à sua esquerda, e os maiores fiquem à sua direita.
     * @param vetor O array de inteiros sendo particionado.
     * @param esquerda O índice inicial da sub-lista.
     * @param direita O índice final da sub-lista.
     * @return O índice onde a partição se divide.
     */
    static int particao(int[] vetor, int esquerda, int direita) {
        // Escolhe o elemento do meio como pivô.
        int meio = (int) (esquerda + direita) / 2;
        int pivot = vetor[meio];

        // Inicializa os ponteiros 'i' (da esquerda para a direita) e 'j' (da direita para a esquerda).
        // Eles começam fora dos limites para que os loops 'do-while' possam incrementá-los/decrementá-los
        // para dentro dos limites antes da primeira comparação.
        int i = esquerda - 1;
        int j = direita + 1;

        while (true) { // Loop infinito que é quebrado pela condição 'if (i >= j)' e o 'return j'.
            // Move 'i' para a direita enquanto o elemento em vetor[i] for menor que o pivô.
            do {
                i++;
            } while (vetor[i] < pivot);

            // Move 'j' para a esquerda enquanto o elemento em vetor[j] for maior que o pivô.
            do {
                j--;
            } while (vetor[j] > pivot);

            // Se os ponteiros 'i' e 'j' se cruzarem ou se encontrarem, a partição está completa.
            // Retorna 'j' (ou 'i'), que é o ponto de divisão.
            if (i >= j) {
                return j; // Retorna o ponto de divisão para as chamadas recursivas.
            }

            // Se os ponteiros não se cruzaram, troca os elementos em vetor[i] e vetor[j].
            // Isso garante que elementos menores que o pivô fiquem à esquerda e maiores à direita.
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }
}