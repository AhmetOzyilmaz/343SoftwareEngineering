public class Adapter {
    public static void main(String [] args){
        Converter converter_obj = new Converter("deneme.xml", "output.json");
        converter_obj.XMLtoJSON();
    }
}
