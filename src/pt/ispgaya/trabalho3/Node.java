/*
 * Node.java
 *
 * Definicao de um no da lista
 */

package pt.ispgaya.trabalho3;

public class Node {

    private Termo termo;
    private Node proximo;

    public Node() {
        this.setTermo(null);
        this.setProximo(null);
    }

    Node(Termo x) {
        this.setTermo(x);
        this.setProximo(null);
    }

    private void setTermo(Termo termo) {
        this.termo = termo;
    }

    void setProximo(Node proximo) {
        this.proximo = proximo;
    }

    Termo getTermo() {
        return this.termo;
    }

    Node getProximo() {
        return this.proximo;
    }
}
