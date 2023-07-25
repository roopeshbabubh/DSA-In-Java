public class RunCode {

    public static void main(String[] args) {

        HashTableData htd = new HashTableData();

        htd.put("paint", 100);
        htd.put("nails", 200);
        htd.put("spray", 50);
        htd.put("lamer", 100);
        htd.put("wood", 100);
        htd.put("bed", 200);
        htd.put("matt", 50);
        htd.put("gun", 100);

        System.out.println(htd.contains("water"));
        System.out.println(htd.contains("wood"));
        System.out.println(htd.contains("nails"));
        System.out.println(htd.contains("lamer"));

        htd.printHash();

        System.out.println(htd.remove("lamer"));
        System.out.println(htd.remove("wood"));
        System.out.println(htd.remove("spray"));
        System.out.println(htd.remove("no-problem"));

        System.out.println(htd.allKeys());

        System.out.println(htd.getSize());

        htd.printHash();

        System.out.println(htd.getValue("gun"));
        System.out.println(htd.getValue("gu"));

    }

}
