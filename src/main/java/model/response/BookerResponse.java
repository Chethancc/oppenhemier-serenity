package model.response;

public class BookerResponse {
    public String getNatid() {
        return natid;
    }

    public void setNatid(String natid) {
        this.natid = natid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelief() {
        return relief;
    }

    public void setRelief(String relief) {
        this.relief = relief;
    }

    private String natid;
    private String name;
    private String relief;
}
