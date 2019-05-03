package interfaces;

public interface Measurable {

    double getMeasure();

    static double average(Measurable[] objects){
        double sum = 0;
        for(Measurable object : objects){
            sum+=object.getMeasure();
        }
        return sum/objects.length;
    }

    static Measurable largest(Measurable[] objects){
        double highest = 0;
        Measurable measurable = null;
        for(Measurable object : objects){
            if(object.getMeasure()>highest) {
                highest = object.getMeasure();
                measurable = object;
            }
        }
        return measurable;
    }
}
