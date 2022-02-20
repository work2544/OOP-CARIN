package ProgramAST;

import ProgramAST.Parser.ExpParser;
import ProgramAST.Statement.ErrorPack.EvalError;
import ProgramAST.Statement.ErrorPack.SyntaxError;
import ProgramAST.Statement.GlobalFile.NodeTree;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class tokentest {
    static ProgramTokenizer tkz;
    static ArrayList<StatmentFac> AllStatement;
    static Map<String,Integer> unitvar=new HashMap<>();
    public static void main(String[] args) throws SyntaxError {
        Path file = Paths.get("Program/ProgramAST/testword.txt");
        StringBuilder sb=new StringBuilder();
        AllStatement=new ArrayList<>();
        Charset charset = StandardCharsets.US_ASCII;
        try (BufferedReader reader =
                     Files.newBufferedReader(file, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                System.out.println(sb);
                tkz=new ProgramTokenizer(sb.toString());
                while(tkz.peek()!="")
                {

                }
                sb.setLength(0);
            }
        }catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File not found");
        }
        catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }

}
