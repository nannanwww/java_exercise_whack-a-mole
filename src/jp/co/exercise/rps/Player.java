
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private int playerChoice;
    
    // プレイヤーのターン
    public void playTurn() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
        	// プレイヤーの入力情報を取得
            System.out.println("「叩くマスを選んでください 1～4(半角数字)」\n");
            System.out.print(">");
            String input = reader.readLine();

            // 整数１～４以外にはループ処理
            try {
                playerChoice = Integer.parseInt(input);
                if (playerChoice >= 1 && playerChoice <= 4) {
                    break;
                } else {
                    System.out.println(Color.red + "無効な入力です。1～4の範囲で入力してください。" + Color.reset);
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println(Color.red + "無効な入力です。数字の形式で入力してください。" + Color.reset);
                continue;
            }
        }
    }
    // プレイヤーの入力情報
    public int getPlayerChoice() {
        return playerChoice;
    }
    
    // ターン終了時にEnterキーを押させるメソッド
    public void pushEnter() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("【Enterキーを押してください。】\n");
        reader.readLine();
    }

}
