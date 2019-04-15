package e.g.dairien.android_project;

public class Rando {
    private String _title;
    private String _place;
    private String _date;

    public Rando(String title, String place, String date){
        _title = title;
        _place = place;
        _date = date;
    }

    public String getTitle(){
        return _title;
    }

    public String getPlace(){
        return _place;
    }

    public String getDate(){
        return _date;
    }
}
