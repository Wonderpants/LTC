package pt.ispgaya.trabalho6;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static pt.ispgaya.trabalho6.ColouredSystemOutPrintln.FOREGROUNDS;

public class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Processo> processos = new ArrayList<Processo>();
//        Processo[] processos = new Processo[5];

        for (int i = 0; i < 5; i++) {
            processos.add(new Processo(i, FOREGROUNDS[i]));
        }

        HeapSort heapSort = new HeapSort();
        heapSort.sort(processos); // Sorts processes by priority

        while (processos.size() != 0) {
            Processo processo = processos.get(0);
            processo.set_cpu(processo.get_cpu() + processo.PUSER);

            System.out.println("Processo em execução: " + processo.toString());

            for (Processo process : processos) { /*System.out.println(process.toString());*/ process.update(); }

            if (processo.get_executions() <= 0) { processos.remove(processo); }
            processo.set_executions(processo.get_executions()-1);

            heapSort = new HeapSort();
            heapSort.sort(processos);

            TimeUnit.SECONDS.sleep(1);
        }

    }
}
