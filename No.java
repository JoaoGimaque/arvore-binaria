package aplication;

public class No {
    private long item;
    private No dir;
    private No esq;

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public long getItem() {
        return item;
    }

    public void setItem(long item) {
        this.item = item;
    }
}

