import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class TheFileReader {

    private String returnedString = "";
    private String filename = "";


    public TheFileReader(String FILENAME) {
        filename = FILENAME;
    }

    public String readerFunc() {

        BufferedReader fileptr = null;
        String line = "";

        try {
            fileptr = new BufferedReader(new FileReader(filename));

            while ((line = fileptr.readLine()) != null) {

                returnedString += line;
                returnedString += "\n";

            }
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

        finally {
            try{
                fileptr.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        return returnedString;
    }

    public void writeIntoFile(String fileName, String data){
        FileWriter fileWriter = null;

        try{
            fileWriter = new FileWriter(fileName);

            fileWriter.append(data);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            try{
                fileWriter.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}
