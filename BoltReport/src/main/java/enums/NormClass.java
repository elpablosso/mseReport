package enums;

public enum NormClass {
    FULLTHREAD("4017-8.8"),
    HALFTHREAD("4014-8.8"),
    NUT("4032"),
    WASHER("7089"),
    BIGWASHER("7093");

    private String name;

    NormClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static NormClass valueByName(String name){
        if(name.equals("4017-8.8")) return FULLTHREAD;
        if(name.equals("4014.8.8")) return HALFTHREAD;
        if(name.equals("4032")) return NUT;
        if(name.equals("7089")) return WASHER;
        if(name.equals("7093")) return BIGWASHER;
        return null; }
}
