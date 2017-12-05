import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class Converter {

    private String input_fileName;
    private String output_fileName;

    public Converter (String param_input_filename, String param_output_filename){
        input_fileName = param_input_filename;
        output_fileName = param_output_filename;
    }

    public void XMLtoJSON() {

        final int indent_factor = 4;

        String data = "";

        TheFileReader fileOp = new TheFileReader(input_fileName);
        data = fileOp.readerFunc();


        try {

            JSONObject xmlToJSONObject = XML.toJSONObject(data);

            String jsonPrintStr = xmlToJSONObject.toString(indent_factor);

            fileOp.writeIntoFile(output_fileName, jsonPrintStr);

        } catch (JSONException j) {

            System.out.println(j.toString());

        }

    }

    public void JSONtoXML() {

        String json_string = "";
        String root = "jsontoxml";

        TheFileReader fileOp = new TheFileReader(input_fileName);
        json_string = fileOp.readerFunc();

        try{
            org.json.JSONObject jsonFileObject = new org.json.JSONObject(json_string);
            String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<"+root+">"
                    + org.json.XML.toString(jsonFileObject) + "</"+root+">";

            fileOp.writeIntoFile(output_fileName, xml);
        }
        catch(JSONException j){
            System.out.println(j.getMessage());
        }



    }
}
