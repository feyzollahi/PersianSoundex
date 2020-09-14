import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtractSoundex {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/words.txt";
        String content = null;
        try {
            content = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = content.split("\n");
        String[] soundex = new String[words.length];
        for(int i = 0; i < words.length; i++){
            soundex[i] = RefinedSoundex.GetSoundex(words[i]);
            if(soundex[i] == null)
                System.out.println(words[i]);
        }
        File file = new File("src/main/resources/results.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter("src/main/resources/results.txt");
        String results = "";
        for(int i = 0; i < words.length; i++){
            results += words[i].substring(0, words[i].length() - 1) + " === " + soundex[i] + "\n";
        }
        fileWriter.write(results);
        fileWriter.close();
    }
}
