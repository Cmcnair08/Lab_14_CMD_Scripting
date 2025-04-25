import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption.*;
import static java.nio.file.StandardOpenOption.CREATE;

public class FileScan {
    public static void main(String[] args) {
    JFileChooser chooser = new JFileChooser();
    File selectedFile;
    String line="";
    String [] words;
    int linecnt = 0;
    int wordcnt = 0;
    int charcnt = 0;
    Path file = null;

    try
    {
        File workingDireectory = new File(System.getProperty("user.dir"));
    if (args.length == 0) {
        chooser.setCurrentDirectory(workingDireectory);
        if (chooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION){
            selectedFile = chooser.getSelectedFile();
            file= selectedFile.toPath();
        }
        else {
            System.out.println("No file selected!!!");
        }
    }
    else {
            file = new File(args[0]).toPath();
    }
        InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        while (reader.ready()){

            line = reader.readLine();
            words = line.split(" ");
            linecnt++;
            charcnt+=line.length();
            wordcnt += words.length;

        }
        reader.close();
        System.out.println("Lines: " + linecnt);
        System.out.println("Chars: " + charcnt);
        System.out.println("Words: " +wordcnt);

        }
    catch (IOException e){
        e.printStackTrace();

    }
    catch (Exception e){
        System.out.println("File not found");
        e.printStackTrace();
    }
    }
}