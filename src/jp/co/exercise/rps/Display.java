
public class Display {
	
    // 初期盤面
    public void showBoard() {
        System.out.println("---------------------");
        System.out.println("| 1 | 2 |");
        System.out.println("---------------------");
        System.out.println("| 3 | 4 |");
        System.out.println("---------------------");
    }
    
    // プレイヤー、PC、モグ次郎が選択した表示
    public void display(int whoChoice, int moleChoice, boolean isPlayer) {
    	String color = isPlayer ? Color.blue : Color.bright_magenta;
    	// 盤面の数値部分に各Choiceを代入
        System.out.println(color + "---------------------");
        for (int i = 1; i <= 4; i++) {
        	System.out.print(color);
            if (i == whoChoice && i == moleChoice) {
                System.out.print("| " + Color.green + "HIT! " + Color.reset);
            } else if (i == whoChoice) {
                System.out.print("| " + Color.red + "miss " + Color.reset);
            } else if (i == moleChoice) {
                System.out.print("| " + Color.yellow + "(・*・) " + Color.reset);
            } else {
                System.out.print("| " + i + " ");
            }
            
            if (i == 2 || i == 4) {
            	System.out.print(color);
                System.out.println("|");
                System.out.println("---------------------");
            }
        }
        System.out.print(Color.reset);
    }
}
