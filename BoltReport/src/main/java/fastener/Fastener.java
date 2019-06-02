package fastener;

public interface Fastener {

    static Fastener instanceBy(String[] record){
        switch (record[0]){
            case "SR": return new Bolt(record);
            case "POD": return new Washer(record);
            case "NAK": return new Nut(record);
    } return null;}

    int getAmount();
    int sortNumber();
    void increaseAmount(int value);

    default String fastenerType(){
        if(this instanceof Bolt) return "BOLT";
        if(this instanceof Washer) return "WASHER";
        if(this instanceof Nut) return "NUT";
        return "";
    }
    double getWeight();

}
