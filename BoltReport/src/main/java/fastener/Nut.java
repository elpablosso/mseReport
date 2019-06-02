package fastener;
import enums.FinishType;
import enums.NormClass;

public class Nut implements Fastener {
    private short diameter;
    private NormClass normClass;
    private FinishType finishType;
    private int amount;
    private double totalWeight;

    public Nut(String[] record) {
        this.diameter=Short.parseShort(record[1]);
        this.normClass=NormClass.valueByName(record[2]);
        this.finishType=FinishType.valueOf(record[3]);
        this.amount=Integer.parseInt(record[4]);
        this.totalWeight=Double.parseDouble(record[5]);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NUT-").append(diameter).append("-").append(normClass.getName()).append("-")
                .append(finishType.name());
        return stringBuilder.toString();
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void increaseAmount(int value) {
        amount+=value;
    }

    @Override
    public double getWeight() {
        return totalWeight;
    }

    @Override
    public int sortNumber() {
        return 5000-diameter*10+1000*finishType.name().length();
    }
}
