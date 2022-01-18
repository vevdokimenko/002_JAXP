package practice;

import java.util.ArrayList;
import java.util.List;

public class CandyHelper {
    private List<Candy> candyList = new ArrayList<>();

    public void addCandy(Candy candy){
        candyList.add(candy);
    }

    public List<Candy> getCandyList() {
        return candyList;
    }
}
