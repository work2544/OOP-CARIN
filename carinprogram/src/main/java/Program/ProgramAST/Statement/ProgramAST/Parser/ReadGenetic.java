package ProgramAST.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadGenetic {
    public static String GetGenetic(String filepath)
             {
        Path file = Paths.get(filepath);
        StringBuilder s=new StringBuilder();
        Charset charset = StandardCharsets.US_ASCII;
        try (BufferedReader reader =
                     Files.newBufferedReader(file, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                s.append(line);
                s.append("\n");
            }
        }catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File not found");
        }
        catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return s.toString();
    }
}
