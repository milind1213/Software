package Programes;
import java.util.*;


public class ProblemsHashmap {

    public static void main(String[] args) {

        HashMap<String, String> tmap = new HashMap<>();
        tmap.put("A", "12");
        tmap.put("B", "15");
        tmap.put("C", "14");

        for (Map.Entry<String, String> e : tmap.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        Set<String> keys = tmap.keySet();
        for (String key : keys) {
            System.out.println((key + " " + tmap.get(key)));
        }

        tmap.remove("C");

       /* System.out.println(map);
        ///Search
        if (map.containsKey("B")) {
            System.out.println("Present ");
        } else {
            System.out.println("Not Present");
        }

        System.out.println(map.get("A"));*/


        HashMap<Integer, String> hsMap = new HashMap<>();
        hsMap.put(1, "Milind");
        hsMap.put(2, "Manish");
        hsMap.put(3, "Manoje");

        for (Map.Entry h : hsMap.entrySet()) {
            System.out.println(h.getKey() + " " + h.getValue());
        }


        HashSet<Integer> set = new HashSet<>();
        set.add(11);
        set.add(21);
        set.add(12);

        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        HashMap map = new HashMap();
        map.put("dsdfs", "vdsf");
        map.put(1, 3);
        map.put("312", 34534);

        Set setkeys = map.keySet();
        Iterator it = setkeys.iterator();

        while (it.hasNext()) {
        }
        System.out.println(map.get(it.next()));
    }
}