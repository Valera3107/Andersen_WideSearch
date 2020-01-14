import java.util.*;

public class Edge {
  private List<Top> tops = new ArrayList<>();
  private String name;

  public Edge(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Top> getTops() {
    return tops;
  }

  public void setTops(List<Top> tops) {
    this.tops = tops;
  }

  public void addTop(Top top){
    this.tops.add(top);
  }

  @Override
  public String toString() {
    return "Edge{" +
      "name='" + name + '\'' +
      '}';
  }
}
