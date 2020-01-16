package pt.ispgaya.trabalho6;

public class Processo {

    int PUSER = 60;
    int NZERO = 20;

    private int p_id;
    int p_cpu;
    private int p_pri;
    private int p_nice;
    String color;

    private static int getRandomNumber(int max, int min) {
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }

    public Processo(int p_id, String color) {
        this.p_id = p_id;
        this.p_cpu = 0;
        this.p_pri = getRandomNumber(80, 0);
        this.p_nice = 20;
        this.color = color;
    }

    public void update() {
        this.p_cpu = this.p_cpu / 2;
        this.p_pri = (this.p_cpu / 2) + this.PUSER + (p_nice - NZERO);
    }

    public int getP_id() {
        return this.p_id;
    }

    public int getP_pri() {
        return this.p_pri;
    }


    @Override
    public String toString() {
        return this.color + "Processo { p_id=" + p_id +
                " p_cpu=" + p_cpu +
                " p_pri=" + p_pri +
                " p_nice=" + p_nice + "}" + ColouredSystemOutPrintln.ANSI_RESET + " \n";
    }
}
