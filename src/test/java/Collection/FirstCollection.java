package Collection;
import java.util.*;
public class FirstCollection {
    public static void main(String[]arg){

         ArrayList<String> name =new ArrayList<String>();
         name.add("MIlind");
         name.add("Ravi");
         name.add("Raj");
         name.add("Anmol");

        Iterator<String> it = name.iterator();
        while (it.hasNext()){
            String next = it.next();
            System.out.println(next);
        }

        name.forEach(e->{
            System.out.println(e);
        });

        for(String str : name){
              System.out.println(str +"\t"+str.length()+"\t");
              StringBuffer br = new StringBuffer(str);
              System.out.println(br.reverse());

         }

       /* ListIterator<String> ltr = name.listIterator(name.size());

        while (ltr.hasPrevious()){
           String previous = String.valueOf(ltr.hasPrevious());
           System.out.println(previous);
        }*/


        name.remove("Ravi");
         System.out.println(name.contains("Raj"));
         name.size();
         name.set(1,"Ghongade");
         name.add(0,"MG");
         System.out.println(name);

        HashSet<Double> mm = new HashSet<>();
        mm.add(121.00);
        mm.add(321.34);
        mm.add(43.33);

        System.out.println(mm);

        TreeSet<Double> tset= new TreeSet<>();
        tset.addAll(mm);

        System.out.println(tset);




    }

}
