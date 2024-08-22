package model;

import java.util.ArrayList;

public class Pessoa {
    private final String nome;
    private final ArrayList<Pessoa> amigos = new ArrayList<>();

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public int getContagemAmigos() {
        return this.amigos.size();
    }

    public void adicionaAmigo(Pessoa amigo) {
        if (amigo.equals(this)) {
            return;
        }
        
        if (!amigos.contains(amigo)) {
            amigos.add(amigo);
        }

        if (!amigo.getAmigos().contains(this)) {
            amigo.adicionaAmigo(this);
        }
    }

    public void removeAmigo(Pessoa amigo) {
        if (amigos.contains(amigo)) {
            amigos.remove(amigo);
        }

        if (amigo.getAmigos().contains(this)) {
            amigo.removeAmigo(this);
        }
    }

    public void removeAmigo(int amigoIndex) {
        removeAmigo(getAmigo(amigoIndex));
    }

    public ArrayList<Pessoa> getAmigos() {
        return this.amigos;
    }

    public Pessoa getAmigo(int amigoIndex) {
        try {
            return amigos.get(amigoIndex);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
