package pt.ispgaya.trabalho6;

public class Processo {

    int PUSER = 60;
    int NZERO = 20;

    private int p_id;
    private int p_cpu;
    private int p_pri;
    private int p_nice;
    private int executions;
    private String color;

    public Processo(int p_id, String color) {
        this.p_id = p_id;
        this.p_cpu = 0;
        this.p_pri = getRandomNumber(80, 40);
        this.p_nice = 20;
        this.color = color;
        this.executions = getRandomNumber(10, 5);
    }

    private static int getRandomNumber(int max, int min) {
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }

    public void update() {
        this.p_cpu = this.p_cpu / 2;
        this.p_pri = (this.p_cpu / 2) + this.PUSER + (p_nice - NZERO);
    }

    public int get_id() { return this.p_id; }
    public int get_cpu() { return this.p_cpu; }

    public void set_cpu(int cpu) { this.p_cpu = cpu; }

    public int get_pri() { return this.p_pri; }

    public void set_pri(int pri) { this.p_pri = pri; }

    public int get_nice() { return this.p_nice; }

    public void set_nice(int nice) { this.p_pri = nice; }

    public int get_executions() { return this.executions; }

    public void set_executions(int executions) { this.executions = executions; }

    public String get_Color() { return this.color; }

    @Override
    public String toString() {
        return String.format("%sProcesso %s { p_cpu=%s p_pri=%s p_nice=%s }%s",
                this.color, this.p_id, this.p_cpu, this.p_pri, this.p_nice, ColouredSystemOutPrintln.ANSI_RESET);
    }
}
