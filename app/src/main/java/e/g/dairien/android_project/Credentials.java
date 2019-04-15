package e.g.dairien.android_project;

public class Credentials {

    private String id;
    private String pwd;

    public Credentials(String id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }

    public Credentials(){}

    public String getPwd() {
        return pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
