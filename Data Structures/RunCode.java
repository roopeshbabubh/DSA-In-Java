import java.util.Collections;

public class RunCode {

    public static void main(String[] args) {

        GraphData gd = new GraphData();

        gd.addVerticesWihEdge("A","B");
        gd.addVerticesWihEdge("B","A");
        gd.addVerticesWihEdge("B","D");
        gd.addVerticesWihEdge("C","D");
        gd.addVerticesWihEdge("C","E");
        gd.addVerticesWihEdge("D","C");
        gd.addVerticesWihEdge("D","E");
        gd.addVerticesWihEdge("E","D");
        gd.addVerticesWihEdge("E","C");

//        gd.printGraph();

        System.out.println(gd.removeVertex("A"));

        gd.printGraph();


    }

}
