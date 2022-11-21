package aplication;


public class ArvoreBinaria {
    private No root;

    public ArvoreBinaria() {
        root = null;
    }

    public void inserir(long v) {
        No novo = new No();
        novo.setItem(v);
        novo.setDir(null);
        novo.setEsq(null);

        if (root == null)
            root = novo;
        else {
            No atual = root;
            No anterior;
            while (true) {
                anterior = atual;
                if (v <= atual.getItem()) {
                    atual = atual.getEsq();
                    if (atual == null) {
                        anterior.setEsq(novo);
                        return;
                    }
                } else {
                    atual = atual.getDir();
                    if (atual == null) {
                        anterior.setDir(novo);
                        return;
                    }
                }
            }
        }

    }

    public boolean remover(long v) {
        if (root == null)
            return false;

        No atual = root;
        No pai = root;
        boolean filho_esq = true;

        while (atual.getItem() != v) {
            pai = atual;
            if (v < atual.getItem()) {
                atual = atual.getEsq();
                filho_esq = true;
            } else {
                atual = atual.getDir();
                filho_esq = false;
            }
            if (atual == null)
                return false;
        }

        if ((atual.getEsq() == null) && (atual.getDir() == null)) {
            if (atual == root)
                root = null;
            else if (filho_esq)
                pai.setEsq(null);
            else
                pai.setDir(null);
        }

        else if (atual.getDir() == null) {
            if (atual == root)
                root = atual.getEsq();
            else if (filho_esq)
                pai.setEsq(atual.getEsq());
            else
                pai.setDir(atual.getEsq());
        }

        else if (atual.getEsq() == null) {
            if (atual == root)
                root = atual.getDir();
            else if (filho_esq)
                pai.setEsq(atual.getDir());
            else
                pai.setDir(atual.getDir());        
        }

        else {
            No sucessor = no_sucessor(atual);

            if (atual == root)
                root = sucessor;
            else if (filho_esq)
                pai.setEsq(sucessor);
            else
                pai.setDir(sucessor);
                sucessor.setEsq(atual.getEsq());
        }

        return true;
    }

    public No no_sucessor(No apaga) {
        No paidosucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.getEsq();

        while (atual != null) {
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }

        if (sucessor != apaga.getDir()) {
            paidosucessor.setEsq(sucessor.getDir());
            sucessor.setDir(apaga.getDir());
        }
        return sucessor;
    }

    public int folhas(No atual) {
        if(atual == null) return 0;
        if(atual.getEsq() == null && atual.getDir() == null) return 1;
        return folhas(atual.getEsq()) + folhas(atual.getDir());
      }

    public void imprimirFolha() {
        folhas(root);
    }

    public No noPaieFilho(long chave) {

        No atual = root;
       
        while (atual.getItem() != chave) {
            if (chave < atual.getItem())
                atual = atual.getEsq();
            else
                atual = atual.getDir();
        }
        if (atual != null) {
            mostrarPaieFilhos(atual);

        }
        return atual;
    }

    public void mostrarPaieFilhos(No atual) {
        
        if (atual != null) {
            System.out.print(atual.getItem() + " ");
        }

        if (atual.getEsq() != null) {
            System.out.print(atual.getEsq().getItem() + " ");
        }

        if (atual.getDir() != null) {
            System.out.print(atual.getDir().getItem() + " ");
        }

    }

    public No descendentes(long chave) {
        No atual = root;

        if(root == null){
            System.out.println("A arvore esta vazia");
        }

        while (atual.getItem() != chave) {
            if (chave < atual.getItem())
                atual = atual.getEsq();
            else
                atual = atual.getDir();
            if (atual == null)
                ;
        }
        if (atual != null) {
            percorrerDir(atual);

        }
        return atual;
    }

    public void percorrerDir(No atual) {
        if (atual != null) {
            System.out.print(atual.getItem() + " ");
            percorrerDir(atual.getEsq());
            percorrerDir(atual.getDir());
        }
    }
}