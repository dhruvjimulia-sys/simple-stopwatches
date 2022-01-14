public class Stopwatch {
  private int timeLapsed;
  
  public Stopwatch() {
    timeLapsed = 0;
  }
  
  public void start() {
    while (true) {
        int[] time = convertFromSeconds(timeLapsed);
        printTime(time);
        wait(1000);
        clearLine();
        timeLapsed++;
    }
  }
  
  private void wait(int ms) {
    try {
        Thread.sleep(ms);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
  }

  private int[] convertFromSeconds(int secs) {
      int mins = secs / 60;
      secs %= 60;
      int hrs = mins / 60;
      mins %= 60;
      int[] time = {hrs, mins, secs};
      return time;
  }

  private void printTime(int[] time) {
      StringBuilder sb = new StringBuilder();
      sb.append(String.format("%02d", time[0]));
      sb.append(":");
      sb.append(String.format("%02d", time[1]));
      sb.append(":");
      sb.append(String.format("%02d", time[2]));
      System.out.println(sb.toString());
  }

  private void clearLine() {
    System.out.print("\033[F");
  }
}