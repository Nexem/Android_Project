package e.g.dairien.android_project;

public class Materiel {

    private String _nom;

    public Materiel(String nom){
        _nom=nom;
    }

    public String getNom(){
        return _nom;
    }
    public void setNom(String nom) {
        this._nom = nom;
    }

    @Override
    public String toString(){
        return _nom;
    }
}
