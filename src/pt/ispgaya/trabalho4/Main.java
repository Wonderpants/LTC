package pt.ispgaya.trabalho4;

public class Main {

    public static void main(String[] args) {
        dispersionTable Table = new dispersionTable(30);
        int option;
        do {
            System.out.println("1 - Insert");
            System.out.println("2 - Remove");
            System.out.println("3 - Search");
            System.out.println("4 - Class Size");
            System.out.println("5 - Student List");
            System.out.println("6 - Exit");
            System.out.println("Option? ");
            System.out.println();

            option = Read.Int();

            switch (option) {

                case 1:
                    if (Table.getOccupationRate() >= 75) {
                        System.out.println("Max Occupation Tax Reached.");
                        break;
                    }
                    System.out.println("Insert Someone.");

                    System.out.print(" Student Code: ");
                    int code = Read.Int();
                    if (!String.valueOf(code).startsWith("2019")) {
                        code = Integer.parseInt("2019" + code);
                    }
                    System.out.print(" Name: ");
                    String name = Read.String();
                    System.out.print(" Assignment: ");
                    String assignment = Read.String();
                    System.out.print(" Grade: ");
                    double grade = Read.Double();
                    Table.insert(new Student(code, name, assignment, grade));
                    break;
                case 2:
                    System.out.print(" Student Code: ");
                    code = Read.Int();
                    Table.remove(code);
                    break;
                case 3:
                    System.out.print(" Student Code: ");
                    code = Read.Int();
                    Student student = Table.searchStudent(code);
                    if (student != null) {
                        System.out.println("Student found: " + student.print());
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 4:
                    System.out.println("There are currently " + Table.getSize() + " students in the list");
                    break;
                case 5:
                    Table.print();
                    break;
                case 6:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        } while (option != 6);
    }
}

class Chain {
    private Student student;
    private Chain next;

    Chain(Student student) {
        this.student = student;
        this.next = null;
    }

    void setNext(Chain next) {
        this.next = next;
    }

    Student getStudent() {
        return this.student;
    }

    Chain getNext() {
        return this.next;
    }

}

class dispersionTable {

    private Chain[] newHash;

    private int MAX_HASH;

    private int hash(int key) {
        return key % this.MAX_HASH;
    }

    dispersionTable(int MAX_HASH) {
        this.MAX_HASH = MAX_HASH;
        this.newHash = new Chain[MAX_HASH];
    }

    void print() {
        StringBuilder fmt = new StringBuilder();
        for (int i = 0; i < newHash.length; i++) {
            Chain chain = newHash[i];
            if (chain != null) {
                fmt.append(chain.getStudent().print());
                while (chain.getNext() != null) {
                    chain = chain.getNext();
                    fmt.append(" -> ").append(chain.getStudent().print());
                }
                if (i != newHash.length - 1) {
                    fmt.append("\n");
                }
            }
//            else {
//                fmt.append("null\n");
//            }
        }
        System.out.println(fmt);
    }

    int getSize() {
        int count = 0;
        for (Chain hash : newHash) {
            Chain chain = hash;
            if (chain != null) {
                count++;
                while (chain.getNext() != null) {
                    chain = chain.getNext();
                    count++;
                }
            }
        }
        return count;
    }

    Chain getPos(int pos) {
        return this.newHash[pos];
    }

    void setPos(int pos, Chain chain) {
        this.newHash[pos] = chain;
    }

    void insert(Student student) {
        Chain tempChain = new Chain(student);
        int pos = hash(student.getCode());
        Chain posChain = this.getPos(pos);
        if (posChain != null) {
            while (posChain.getNext() != null) {
                posChain = posChain.getNext();
            }
            posChain.setNext(tempChain);
        } else {
            this.setPos(pos, tempChain);
        }
    }

    void remove(int code) {
        if (String.valueOf(code).startsWith("2019")) {
            code = Integer.parseInt(String.valueOf(code).substring(4));
        }
        int pos = -1;
        if (this.getSize() == 0) {
            System.out.println("Table is empty");
            return;
        }
        for (Chain hash : newHash) {
            pos++;
            Chain p = hash, ant;
            if (p == null) {
                continue;
            }
            if (p.getStudent().getCode() == code) {
                this.setPos(pos, hash.getNext());
                return;
            } else {
                ant = p;
                p = p.getNext();
                while (p != null) {
                    if (p.getStudent().getCode() == code) {
                        ant.setNext(p.getNext());
                        System.out.println("Value eliminated");
                        this.setPos(pos, hash);
                        return;
                    } else {
                        p = p.getNext();
                        ant = ant.getNext();
                    }
                }
            }
        }
        System.out.println("Student not found");
    }

    float getOccupationRate() {
        return ((float) getSize() / newHash.length) * 100;
    }

    Student searchStudent(int code) {
        if (String.valueOf(code).startsWith("2019")) {
            code = Integer.parseInt(String.valueOf(code).substring(4));
        }
        if (this.getSize() == 0) {
            System.out.println("Table is empty");
            return null;
        }
        for (Chain hash : newHash) {
            Chain p = hash;
            if (p == null) {
                continue;
            }
            if (p.getStudent().getCode() == code) {
                return p.getStudent();
            } else {
                p = p.getNext();
                while (p != null) {
                    if (p.getStudent().getCode() == code) {
                        return p.getStudent();
                    } else {
                        p = p.getNext();
                    }
                }
            }
        }
        return null;
    }

}
