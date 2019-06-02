import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHandler implements Medium {
    File file = new File("database.txt");

    void backup() {
        try {
            Backup.saveWithBackup("database.txt");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public void write(String user, long dataId, String data) throws Exception {
        String newLine = dataId + "-" + user + "-" + data;
        try (FileWriter writer = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(newLine);
            this.backup();
        }
    }

    @Override
    public String read(String user, long dataId) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));

        String ourLine;
        int i = 1;
        while ((ourLine = br.readLine()) != null) {
            String[] operation = ourLine.split("-");
            if (operation[0].equals(dataId)) {
                return ourLine;
            }
            i += 1;
        }
        return null;
    }

    @Override
    public List<String> read(String user) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> gadaricxvebi = new ArrayList<>();

        String ourLine;
        int i = 1;
        while ((ourLine = br.readLine()) != null) {
            String[] operation = ourLine.split("-");
            if (operation[1].equals(user)) {
                gadaricxvebi.add(operation[2]);
            }
            i += 1;
        }
        return gadaricxvebi;
    }
}
