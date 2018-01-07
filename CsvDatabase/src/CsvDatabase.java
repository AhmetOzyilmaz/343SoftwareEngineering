public class CsvDatabase {
    public static void main(String [] args){
        DB.insert("MyPc", "ageOf", "asd", "asd",
                "sad", "lol", "lel", "pro");
        DB.insert("MyPc", "ageOn", "asd", "asd",
                "sad", "lol", "lel", "pro");
        DB.insert("YourPc", "ageDown", "asd", "asd",
                "sad", "lol", "lel", "pro");
        DB.insert("YourPc", "ageUp", "asd", "asd",
                "sad", "lol", "lel", "pro");
        DB.delete("YourPc", "ageUp");
    }
}
