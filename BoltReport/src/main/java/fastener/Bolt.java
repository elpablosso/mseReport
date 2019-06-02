package fastener;

import enums.FinishType;
import enums.NormClass;

public class Bolt implements Fastener {
    private short diameter;
    private short length;
    private FinishType finish;
    private NormClass normClass;
    private int amount;
    private double weightTotal;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BOLT-").append(diameter).append("-").append(length).append("-").append(finish)
                .append("-").append(normClass.getName());
        return builder.toString();
    }

    public Bolt(String[] record) {
        this.diameter=Short.parseShort(record[1]);
        this.length=Short.parseShort(record[2]);
        this.finish=FinishType.valueOf(record[3]);
        this.normClass= NormClass.valueByName(record[4]);
        this.amount=Short.parseShort(record[5]);
        this.weightTotal=Double.parseDouble(record[6]);
    }

    @Override
    public int sortNumber() {
        return -diameter*100-length+finish.name().length()*1000;
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
        return weightTotal;
    }
}
