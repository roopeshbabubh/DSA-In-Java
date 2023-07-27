import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphData {
    HashMap<String, ArrayList<String>> adjList;

    GraphData() {
        this.adjList = new HashMap<>();
    }

    public void printGraph() {
        for (Map.Entry data: adjList.entrySet()) {
            System.out.println(data.getKey() + " = " + data.getValue());
        }
    }

    public void addVerticesWihEdge(String vertex1, String vertex2) {
        if (adjList.containsKey(vertex1)) {
            if (!adjList.get(vertex1).contains(vertex2))
                adjList.get(vertex1).add(vertex2);
        } else {
            adjList.put(vertex1, new ArrayList<>(List.of(vertex2)));
        }
        if (adjList.containsKey(vertex2)) {
            if (!adjList.get(vertex2).contains(vertex1))
                adjList.get(vertex2).add(vertex1);
        } else {
            adjList.put(vertex2, new ArrayList<>(List.of(vertex1)));
        }
    }

    public String removeVertex(String vertex) {
        ArrayList<String> removed = null;
        if (adjList.containsKey(vertex)) {
            for (String key : adjList.get(vertex)) {
                adjList.get(key).remove(vertex);
            }
            removed = adjList.remove(vertex);
        }
        return vertex + " = " + removed;
    }
}
