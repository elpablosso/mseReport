import fastener.Fastener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {

    private Map<String,Fastener> results;

    public Results(List<Fastener> fasteners) {
        results = new HashMap<>();
        addReport(fasteners);
    }

    public List<Fastener> getResoults(){
        List<Fastener> summary = new ArrayList<>();
        for(Map.Entry<String,Fastener> entry : results.entrySet()){
            summary.add(entry.getValue());
        }
        return summary;
    }

    private void addReport(List<Fastener> fasteners){
        for(Fastener fastener : fasteners){
            addFastener(fastener);
        }
    }

    private void addFastener(Fastener fastener){
        if(!results.containsKey(fastener.toString())) {results.put(fastener.toString(),fastener);}
        else{increaseExisting(fastener);}
    }

    private void increaseExisting(Fastener fastener){
        Fastener existing = results.get(fastener.toString());
        existing.increaseAmount(fastener.getAmount());
        results.put(fastener.toString(), existing);
    }
}
