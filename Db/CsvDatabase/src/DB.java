import java.io.FileWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class DB {
    private static String filename = "data.csv";

    private static void insert(ArrayList<String> info){

        ArrayList<ArrayList<String>> dbList = get();

        final String COMMA = ",";
        final String NEW_LINE = "\n";

        FileWriter fw = null;

        try{
            fw = new FileWriter(filename, false);
            dbList.add(info);
            for(int a = 0; a < dbList.size(); a++){
                for(int b = 0; b < dbList.get(a).size(); b++){
                    fw.append(dbList.get(a).get(b));
                    if(b != dbList.get(a).size()-1){
                        fw.append(COMMA);
                    }
                }
                fw.append(NEW_LINE);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            try{
                fw.flush();
                fw.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }


    }

    public static void insert(String host_id, String app_name, String item_cpu, String item_memory, String item_number_process,
    String graph_cpu, String graph_memory, String graph_number_process){

        ArrayList<String> temp = new ArrayList<String>();

        temp.add(host_id);
        temp.add(app_name);
        temp.add(item_cpu);
        temp.add(item_memory);
        temp.add(item_number_process);
        temp.add(graph_cpu);
        temp.add(graph_memory);
        temp.add(graph_number_process);

        insert(temp);

    }

    private static ArrayList<ArrayList<String>> get(){

        ArrayList<ArrayList<String>> dbList = new ArrayList<ArrayList<String>>();
        final String COMMA = ",";

        BufferedReader br = null;
        String line = "";

        if (new File(filename).exists()) {
            try{
                br = new BufferedReader(new FileReader(filename));

                while((line = br.readLine()) != null){
                    String[] tokens = line.split(COMMA);
                    ArrayList<String> temp = new ArrayList<String>();
                    for(String str : tokens){
                        temp.add(str);
                    }
                    dbList.add(temp);
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            finally{
                try{
                    br.close();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }

        return dbList;
    }

    public static void delete(String host_id, String app_name){
        ArrayList<ArrayList<String>> dbList = get();

        int line = -1;

        for(int a = 0; a < dbList.size(); a++){
            for(int b = 0; b < dbList.get(a).size(); b++) {
                if(dbList.get(a).get(0).equals(host_id) && dbList.get(a).get(1).equals(app_name)){
                    line = a;
                }
            }
        }

        if(line != -1) {dbList.remove(line);}

        FileWriter fw = null;

        try{
            fw = new FileWriter(filename, false);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            try{
                fw.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        for(int a = 0; a < dbList.size(); a++){
            ArrayList<String> temp = dbList.get(a);
            insert(temp.get(0),temp.get(1),temp.get(2),temp.get(3),temp.get(4),temp.get(5),temp.get(6),temp.get(7));
        }

    }
}
