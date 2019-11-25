package transferwise;


import java.util.*;

public class WorldWidRelay {

    public static void main(String args[]){
        Map<Integer, Cyclist> cyclistMap = new HashMap();
        cyclistMap.put(1, new Cyclist(1, 1, 2000));
        cyclistMap.put(2, new Cyclist(2, 10, 2000));
        cyclistMap.put(3, new Cyclist(3, 4, 2000));
        cyclistMap.put(4, new Cyclist(4, 2, 100));
        cyclistMap.put(5, new Cyclist(5, 1, 100));
        cyclistMap.put(6, new Cyclist(6, 2, 1000));

        Map<Integer, Map<Integer, Integer>> edgeMap = new HashMap<>();
        Map<Integer, Integer> tempMap = new HashMap<>();
        tempMap.put(2, 200);
        tempMap.put(3, 150);
        edgeMap.put(1, tempMap);

        tempMap = new HashMap<>();
        tempMap.put(5, 2000);
        edgeMap.put(2, tempMap);

        tempMap = new HashMap<>();
        tempMap.put(4, 200);
        edgeMap.put(3, tempMap);

        tempMap = new HashMap<>();
        tempMap.put(5, 1000);
        edgeMap.put(4, tempMap);

        Queue<Path> pathQueue = new LinkedList<>();
        pathQueue.add(new Path(1,1,2000,0));
        worldWideRelay(cyclistMap,edgeMap,pathQueue);
    }

    public static void worldWideRelay(Map<Integer, Cyclist> cyclistMap,
                                      Map<Integer, Map<Integer, Integer>> edgeMap,
                                      Queue<Path> pathQueue){
        int bestTime = Integer.MAX_VALUE;
        while(!pathQueue.isEmpty()){
            Path path = pathQueue.poll();
            Cyclist currentCyclist = cyclistMap.get(path.cityId);
            if(path.time_spent<bestTime)
                bestTime = path.time_spent;
            for(Map.Entry<Integer,Integer> entry: edgeMap.get(currentCyclist.id).entrySet()){
                path.remaining_distance -= entry.getValue();
                if(path.remaining_distance < 0 )
                    continue;
                Cyclist cyclistNextCity = cyclistMap.get(entry.getKey());
                if(path.speed > cyclistNextCity.speed || path.remaining_distance > cyclistNextCity.distance ) {
                    Path nextCyclist = new Path(cyclistNextCity.id,cyclistNextCity.speed, cyclistNextCity.distance,0);
                    pathQueue.add(nextCyclist);
                }
                if(cyclistNextCity.speed>path.speed || cyclistNextCity.distance > path.remaining_distance){
                    Path nextCyclist = new Path(cyclistNextCity.id,cyclistNextCity.speed, cyclistNextCity.distance,0);
                    pathQueue.add(nextCyclist);
                }
            }
        }
        System.out.println("Best time :: " + bestTime);
    }
}
