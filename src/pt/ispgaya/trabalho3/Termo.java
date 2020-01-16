package pt.ispgaya.trabalho3;

public class Termo {
    private int coeficiente;
    private int expoente;

    Termo(int coeficiente, int expoente) {
        this.coeficiente = coeficiente;
        this.expoente = expoente;
    }

    Termo(int coeficiente) {
        this.coeficiente = coeficiente;
        this.expoente = 0;
    }

    Termo(String termo){
        String[] values = termo.split("x");
        if (values.length > 1) {
            this.coeficiente = Integer.parseInt(values[0]);
            this.expoente = Integer.parseInt(values[1]);
        }
        else if (termo.contains("x")) {
            this.coeficiente = Integer.parseInt(values[0]);
            this.expoente = 1;
        }
        else {
            this.coeficiente = Integer.parseInt(values[0]);
        }
    }

    public void setCoeficiente(int coeficiente) {
        this.coeficiente = coeficiente;
    }
    public void setExpoente(int expoente) {
        this.expoente = expoente;
    }

    int getCoeficiente() {
        return this.coeficiente;
    }
    int getExpoente() {
        return this.expoente;
    }

    String print() {
        return this.coeficiente + "x^" + this.expoente;
    }
}
