import java.util.*;

public class WideSearch {

  //Создание вершин графа
  private static Top start = new Top("start");
  private static Top top1 = new Top("top1");
  private static Top top2 = new Top("top2");
  private static Top top3 = new Top("top3");
  private static Top top4 = new Top("top4");
  private static Top top5 = new Top("top5");
  private static Top end = new Top("end");

  //Создание коллекции вершин
  private static List<Top> tops = new ArrayList<>();

  //Создание ребер
  private static Edge start_top1 = new Edge("start -> top1");
  private static Edge top1_top2 = new Edge("top1 -> top2");
  private static Edge top2_end = new Edge("top2 -> end");
  private static Edge start_top4 = new Edge("start -> top4");
  private static Edge top4_top3 = new Edge("top4 -> top3");
  private static Edge top4_top5 = new Edge("top4 -> top5");
  private static Edge top5_top2 = new Edge("top5 -> top2");
  private static Edge top3_top2 = new Edge("top3 -> top2");

  //Заполнение и связывание вершин и графов между собой
  static {
    start.addEdge(start_top1);
    start.addEdge(start_top4);

    top1.addEdge(top1_top2);

    top2.addEdge(top2_end);

    top3.addEdge(top3_top2);

    top4.addEdge(top4_top3);
    top4.addEdge(top4_top5);

    top5.addEdge(top5_top2);

    start_top1.addTop(start);
    start_top1.addTop(top1);

    start_top4.addTop(start);
    start_top4.addTop(top4);

    top1_top2.addTop(top1);
    top1_top2.addTop(top2);

    top1_top2.addTop(top1);
    top1_top2.addTop(top2);

    top2_end.addTop(end);
    top2_end.addTop(top2);

    top3_top2.addTop(top3);
    top3_top2.addTop(top2);

    top4_top3.addTop(top4);
    top4_top3.addTop(top3);

    top4_top5.addTop(top4);
    top4_top5.addTop(top5);

    top5_top2.addTop(top5);
    top5_top2.addTop(top2);

    tops.add(start);
    tops.add(top1);
    tops.add(top2);
    tops.add(top3);
    tops.add(top4);
    tops.add(top5);
    tops.add(end);
  }

  protected static boolean wideSearch() {
    boolean exist = false;                   // флажок об успехе поиска пути
    Top topForStep = tops.get(0);            // начальная вершина для итерации по коллекции
    if (start.equals(end)) return true;      // проверка на необходимость алгоритма

    do {                                       // перебираем пути пока вершины начала и конца не будут ровны

      for (Top top : tops) {                       // начинаем итерацию по вершинам
        if (top.equals(topForStep)) {              // находим вершину начала
          for (Edge edge : top.getEdgeList()) {    // перебираем ребра из данной вершины
            for (Top underTop : edge.getTops()) {  // перебираем вершины ребер
              if (!underTop.equals(topForStep)) {  // если найдена новая вершина
                topForStep = underTop;             // меняем начальную вершину
                System.out.println(edge);          // выводим путь
              }

              if (topForStep.equals(end)) {        // если вершины начала и конца равны значит путь существует
                exist = true;                      // меняем флажок
                break;                             // останавливаем поиск
              }
            }
          }
        }
      }

    } while (!topForStep.equals(end));

    return exist;
  }
}
