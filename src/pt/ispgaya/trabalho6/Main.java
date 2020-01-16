package pt.ispgaya.trabalho6;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static pt.ispgaya.ColouredSystemOutPrintln.FOREGROUNDS;

public class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws InterruptedException {
        Processo[] processos = new Processo[5];

        for (int i = 0; i < 5; i++) {
            processos[i] = new Processo(i, FOREGROUNDS[i]);
        }

        HeapSort heapSort = new HeapSort();
        heapSort.sort(processos); // Sorts processes by priority

        int second = 0;
        int runtime = 10;
        String[] runs = new String[runtime];

        while (second < runtime) {
            Processo processo = processos[0];
            processo.p_cpu += 60;
            runs[second] = processo.toString();

            System.out.println("---------------------");
            System.out.print("Processo em execução: " + processo.toString());
//            System.out.println(String.join("", Arrays.stream(runs).filter(Objects::nonNull).toArray(String[]::new)));

            processo.update();
            for (Processo process : processos) {
                if (process != null) {
                    process.update();
                };
            }

            heapSort = new HeapSort();
            heapSort.sort(processos);
            for (Processo process : processos) {
                if (process != null) {
                    System.out.print(process.toString());
                };
            }
            second++;
            TimeUnit.SECONDS.sleep(0);
        }

    }
}
