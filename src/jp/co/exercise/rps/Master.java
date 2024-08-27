import java.io.IOException;

public class Master {
	
    private Player player;
    private Mole mole;
    private Display display;
    
    // クラスの呼び出し
    public Master() {
        player = new Player();
        mole = new Mole();
        display = new Display();
    }
    
    // ゲームの構成をまとめるメソッド
    public void startGame() throws IOException {
    	System.out.println("「ゲームスタート!」");
    	// 勝者が決まるまで続ける
        boolean winner = false;
        while (!winner) {
            
            // 初期盤面を表示
            display.showBoard();
            // モグ次郎の選択呼び出す
            mole.moleChoice();
            
            // プレイヤーの入力ターン
            player.playTurn();
            // プレイヤーとモグ次郎の結果表示
            int playerMoleChoice = mole.moleChoice();
            System.out.println("\n「あなたが叩いた結果を表示します。」");
            display.display(player.getPlayerChoice(), playerMoleChoice, true);
            mole.hitReaction(player.getPlayerChoice() == playerMoleChoice);
            
            
            // コンピュータの入力ターン
            int pcChoice = (int)(Math.random() * 4) + 1;
            // コンピュータとモグ次郎の結果表示
            int pcMoleChoice = mole.moleChoice();
            System.out.println("「コンピューターが叩いた結果を表示します。」\n");
            try {
                // 1秒待つ
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            display.display(pcChoice, pcMoleChoice, false);
            mole.hitReaction(pcChoice == pcMoleChoice);
            
            // Enterキーを押してターンエンド
            player.pushEnter();
            
            // 勝者判定
            if(player.getPlayerChoice() == playerMoleChoice || pcChoice == pcMoleChoice) {
            	System.out.println(Color.yellow + "「ゲーム終了!」");
            	if (player.getPlayerChoice() == playerMoleChoice && pcChoice != pcMoleChoice) {
            		// プレイヤーが勝者の場合
                    System.out.println("プレイヤーの勝ちです！");
                    winner = true;
                } else if (player.getPlayerChoice() != playerMoleChoice && pcChoice == pcMoleChoice) {
                	// コンピューターが勝者の場合
                    System.out.println("残念でした。。。コンピューターが勝ちました。");
                    winner = true;
                } else if (player.getPlayerChoice() == playerMoleChoice && pcChoice == pcMoleChoice) {
                	// 引き分けの場合
                    System.out.println("引き分けです！" + Color.reset);
                    winner = true;
                }
            }
            
            System.out.print(Color.reset);
        }
    }
}
