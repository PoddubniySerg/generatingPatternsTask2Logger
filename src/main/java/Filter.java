import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer value : source) {
            if (value < this.treshold) {
                logger.log("Элемент \"" + value + "\" не проходит");
            } else {
                result.add(value);
                logger.log("Элемент \"" + value + "\" проходит");
            }
        }
        logger.log("Элементов прошло фильтр: " + result.size() + " из " + source.size());
        return result;
    }
}