public class RunCode {

    public static void main(String[] args) {

        LinkedList dlli = new LinkedList(1);

        dlli.append(2);
        dlli.append(3);
        dlli.append(4);
        dlli.append(5);
        dlli.append(6);
        dlli.append(7);
        dlli.append(8);

        dlli.prepend(0);


        System.out.println(dlli.removeFirst());

        System.out.println(dlli.removeLast());

        System.out.println(dlli.get(4).value);

        dlli.insert(5, 15);

        dlli.set(5, 25);

        dlli.remove(3);

        System.out.println("Length " + dlli.getLength());

        dlli.reverse();

        dlli.printLList();

    }

}
