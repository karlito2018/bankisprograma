import java.util.List;

public class Core {
    DataHandler medium;

    void addAmount(String client, int amount) throws Exception {
        int newBalance = this.getBalance(client) + amount;

        if (newBalance < 0) {
            System.out.println("Shecdoma gadaricxvisas");
        } else {
            long dataId = System.currentTimeMillis();
            medium.write(client,dataId,Integer.toString(newBalance));
        }

    }

    void getAmount(String client, int amount) throws Exception {
        this.addAmount(client,-amount);
    }

    void transferAmount(String fromClient, String toClient, int amount) throws Exception {
        this.getAmount(fromClient, amount);
        this.addAmount(toClient, amount);
    }

    int getBalance(String client) throws Exception {
        int balance = 0;
        List<String> gadaricxvebi = medium.read(client);

        for (String gadaricxva : gadaricxvebi) {
            balance += Integer.valueOf(gadaricxva);
        }

        return balance;
    }
}
