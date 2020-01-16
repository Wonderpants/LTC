package pt.ispgaya.trabalho3;

import java.io.IOException;

public class Main {

    // troca dois nos da lista entre si
    static Node trocaNos(Node inicio, Node a, Node b) {
        Node ant_a = inicio, ant_b = inicio, aux;

        if (a == inicio) {
            ant_a = null;
        } else {
            while (ant_a != null) {
                if (ant_a.getProximo() == a) {
                    break;
                } else {
                    ant_a = ant_a.getProximo();
                }
            }
        }

        if (b == inicio) {
            ant_b = null;
        } else {
            while (ant_b != null) {
                if (ant_b.getProximo() == b) {
                    break;
                } else {
                    ant_b = ant_b.getProximo();
                }
            }
        }

        aux = b.getProximo();

        if (ant_a == null) {
            inicio = b;
        } else {
            if (ant_a != b) {
                ant_a.setProximo(b);
            }
        }

        if (a != ant_b) {
            b.setProximo(a.getProximo());
        } else {
            b.setProximo(a);
        }

        if (ant_b == null) {
            inicio = a;
        } else {
            if (ant_b != a) {
                ant_b.setProximo(a);
            }
        }

        if (b != ant_a) {
            a.setProximo(aux);
        } else {
            a.setProximo(b);
        }

        return inicio;
    }

    // ordenacao da lista usando o algoritmo SelectionSort
    private static Node selectionSort(Node lista) {
        int min;
        Node v = lista, k, j, primeiroAux = lista;

        while (v.getProximo() != null) {
            k = v;
            min = v.getTermo().getCoeficiente();
            for (j = v.getProximo(); j != null; j = j.getProximo())
                if (j.getTermo().getCoeficiente() < min) {
                    k = j;
                    min = k.getTermo().getCoeficiente();
                }

            // usando o metodo trocaNos
            lista = trocaNos(lista, v, k);
            v = k; // necessario apenas se for usado o metodo trocaNos()

            // pode-se tambem usar, em alternativa, o metodo troca( v, k )
            //troca( v, k );

            v = v.getProximo();
        }
        return lista;
    }

    // insere um novo no no inicio da lista
    private static Node insere(Node inicio, Node novo) {
        novo.setProximo(inicio);
        return novo;
    }

    // insere um novo no no fim da lista
    private static Node insereFim(Node inicio, Node novo) {
        Node n = inicio;

        if (inicio == null) {
            inicio = novo;
        } else {
            while (n.getProximo() != null) {
                n = n.getProximo();
            }
            n.setProximo(novo);
        }

        return inicio;
    }

    // imprime no ecra todos os elementos da lista
    private static void listar(Node inicio) {
        Node n;
        n = inicio;
        if (inicio == null) {
            System.out.println("A lista esta vazia!");
        }

        while (n != null) {
            System.out.print(n.getTermo().print() + " -> ");
            n = n.getProximo();
        }
        System.out.println("null");
    }

    // imprime no ecra todos os elementos da lista - VERSAO RECURSIVA
    private static void listarRecursivo(Node n) {

        if (n != null) {
            System.out.print(n.getTermo().print() + " -> ");
            listarRecursivo(n.getProximo());
        } else {
            System.out.println("null");
        }
    }

    // pesquisa a ocorrencia de um no
    private static Node pesquisa(Node inicio, Termo n) {
        Node no = inicio;
        while (no != null) {
            if (!no.getTermo().print().equals(n.print())) {
                no = no.getProximo();
            } else {
                break;
            }
        }
        return no;
    }

    // pesquisa a ocorrencia de um no - VERSAO RECURSIVA
    private static Node pesquisaRecursiva(Node no, Termo n) {
        if (no == null)
            return null;
        else {
            if (no.getTermo().print().equals(n.print()))
                return no;
            else
                return pesquisaRecursiva(no.getProximo(), n);
        }
    }

    // conta o numero de nos da lista
    private static int contaNos(Node inicio) {
        Node no = inicio;
        int n = 0;
        while (no != null) {
            n++;
            no = no.getProximo();
        }
        return n;
    }

    // elimina um no dado o seu valor
    private static void elimina(Node lista, Termo n) {
        Node p = lista, ant;
        if (lista == null) {
            System.out.println("A lista esta vazia!");
            return;
        }
        if (p.getTermo().print().equals(n.print())) {
            lista = lista.getProximo();
        } else {
            ant = p;
            p = p.getProximo();
            while (p != null) {
                if (p.getTermo().print().equals(n.print())) {
                    ant.setProximo(p.getProximo());
                    System.out.println("Valor eliminado!");
                    return;
                } else {
                    p = p.getProximo();
                    ant = ant.getProximo();
                }
            }
            System.out.println("Valor nao encontrado!");
        }
    }

    private static Node getTermos(String polinomio, Node novo, Node primeiro) {
        String[] termos = polinomio.split(" ");
        for (int i = 0; i < termos.length; i++) {
            String termo = null;
            if (termos[i].split("")[0].matches("-?(0|[1-9]\\d*)")) {
                termo = termos[i];
            } else if (termos[i].startsWith("-")) {
                termo = termos[i] + termos[i + 1];
                i++;
            }
            if (termo != null) {
                String[] values = termo.split("x");
                Termo termo1;
                if (values.length > 1) {
                    termo1 = new Termo(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
                } else if (termos[i].contains("x")) {
                    termo1 = new Termo(Integer.parseInt(values[0]), 1);
                } else {
                    termo1 = new Termo(Integer.parseInt(values[0]));
                }
                novo = new Node(termo1);
                primeiro = insere(primeiro, novo);
            }
        }
        return primeiro;
    }

    private static Node bubbleSort(Node lista) {
        int size = contaNos(lista);
        Node n = lista;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
//                System.out.print(n.getTermo().print() + " -> ");
                if (n.getProximo() != null) {
                    if (n.getTermo().getExpoente() > n.getProximo().getTermo().getExpoente()) {
                        lista = trocaNos(lista, n, n.getProximo());
//                        lista = trocaNos(lista, n.getProximo(), n);
                    }
                    n = n.getProximo();
                } else {
                    n = lista;
//                    System.out.println();
                }
            }
        return lista;
    }

    private static int getGrau(Node no) {
        int max = 0;
        while (no != null) {
            if (no.getTermo().getExpoente() > max) {
                max = no.getTermo().getExpoente();
            }
            no = no.getProximo();
        }
        return max;
    }

    public static void main(String[] args) throws IOException {

        Node primeiro = null; // apontador para a cabeca da lista
        Node novo = null;     // referencia para um novo no a criar
        // int opcao, num;       // variaveis auxiliares

        // Inserir polinómio
        String polinomio = "5x4 + 6x - 3x2 + 9";
        primeiro = getTermos(polinomio, primeiro, novo);

        // Criar um novo termo
        primeiro = insere(primeiro, new Node(new Termo("3x3")));

        // Escrever o polinómio
        listarRecursivo(primeiro);

        // Indicar o grau
        System.out.println("Grau: " + getGrau(primeiro));

        // Indicar o número de termos do polinómio;
        System.out.println("Número de termos: " + (contaNos(primeiro) - 1));

        // Ordenar o polinómio
        primeiro = bubbleSort(primeiro);
        System.out.print("Ordenado: ");
        listar(primeiro);

        // Calcular o valor do polinómio para um dado valor de x.
        double x = 5;
        double result = 0.0;
        Node n = primeiro;
        while (n != null) {
            result += EvaluateString.eval(n.getTermo().print().replace("x", "*" + x));
            n = n.getProximo();
        }
        System.out.println(result);
    }
}
