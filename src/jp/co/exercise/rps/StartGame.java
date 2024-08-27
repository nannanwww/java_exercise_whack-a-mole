import java.io.IOException;

public class StartGame {

    public static void main(String[] args) throws IOException {
        Master master = new Master();
        
        try {
            master.startGame();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
