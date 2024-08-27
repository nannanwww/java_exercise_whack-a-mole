
public class Mole {

    // モグ次郎の選択
    public int moleChoice() {
    	return (int)(Math.random() * 4) + 1;
    }

    // モグ次郎の反応メソッド
    public void hitReaction(boolean hit) {
        if (hit) {
            System.out.println("モグ次郎:「痛いモグ。。。」\n");
        } else {
            System.out.println("モグ次郎:「はずれ! ちゃんとねらうモグよ!」\n");
        }
    }
}
