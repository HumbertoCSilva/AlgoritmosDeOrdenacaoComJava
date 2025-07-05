// SelectionSort compara o primeiro elemento com o próximo e vai trocando de posição até ordenar

public class SelectionSort {

    public static void main(String[] args) {
        int[] vetor = new int[10];


        // gerando o vetor aleatóriamente com Math.ramdom
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }
        // Imprimindo o vetor desordenado
        System.out.println("Vetor desordenado: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

        //Algoritmo Selection sort
        // Definindo as variáveis PosicaoMenor (que vai armazenar o menor numero
        // Definindo a variável auxiliar que vai armazenar temporariamente o menor numero
        int PosicaoMenor, aux;
        for (int i = 0;  i < vetor.length; i++) {
            PosicaoMenor = i;
            for(int j = i+1; j < vetor.length; j++) {
                if (vetor[j] < vetor[PosicaoMenor]) {
                    PosicaoMenor = j;
                }
            }
            //Trocando as posições de i por j (menor numero agr
            aux = vetor[PosicaoMenor];
            vetor[PosicaoMenor] = vetor[i];
            vetor[i] = aux;
        }

        System.out.println("\n\n Vetor Ordenado:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}