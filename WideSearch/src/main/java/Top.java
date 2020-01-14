import java.util.*;

public class Top {
  private List<Edge> edgeList = new ArrayList<Edge>();
  private String name;

  public Top(String name) {
    this.name = name;
  }

  public List<Edge> getEdgeList() {
    return edgeList;
  }

  public void addEdge(Edge edge){
    this.edgeList.add(edge);
  }

  public void setEdgeList(List<Edge> edgeList) {
    this.edgeList = edgeList;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Top)) return false;
    Top top = (Top) o;
    return getName().equals(top.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  @Override
  public String toString() {
    return "Top{" +
      "name='" + name + '\'' +
      '}';
  }
}
