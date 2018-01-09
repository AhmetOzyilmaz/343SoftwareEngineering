import java.sql.*;


    public class db_connector {
        private final static String driver = "com.mysql.jdbc.Driver";
        private final static  String url = "jdbc:mysql://94.73.145.118/dbD09F7E";
        private final static  String username = "userD09F7E";
        private final static String password = "WPsc05M5";

        public static void main(String[] args) {
            //String databaseURL = "https://databases.000webhost.com/id4079017_devopsproject";
            try{
                String info = "insert into monitor (prog_name, pc_id,pc_ip,cpu_id,memory_id,process_num)" + " values (?,?,?,?,?,?)";
//                insertTable_1(info, "111.111.111.1","10031","ugur.exe","121","10","40");
                select_1();
                remove_row("10054","Github.exe");
                select_1();
            }
            catch(Exception e){
                System.out.println(e);
            }

        }
        public static void remove_row(String pc_id, String prog_name)throws Exception{
            Connection con= db_connector.getConnection();
            Statement st = con.createStatement();
            String str ="'ugur.exe'";
            String query =  "DELETE FROM monitor WHERE pc_id ="+pc_id+" AND prog_name = '"+prog_name+"'";
            System.out.println(query);
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.execute();
            con.close();
        }
        public static void select_1() throws Exception {
            // insert statement
            Connection con= db_connector.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM monitor";

            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                String host_ip = rs.getString("ID");
                String host_id = rs.getString("pc_id");
                String program_name = rs.getString("prog_name");
                String pc_ip = rs.getString("pc_ip");
                String cpu_id = rs.getString("cpu_id");
                String memory_id = rs.getString("memory_id");
                String process_num = rs.getString("process_num");


                // print the results
                System.out.format("%s, %s, %s , %s ,%s, %s, %s\n",
                        host_id,host_ip,program_name,pc_ip,cpu_id,memory_id,process_num);
            }
            st.close();
            con.close();
        }

        public static void insertTable_1(String info,String host_ip,String host_id, String program_name,String cpu_id,
                                         String memory_id,String process_num) throws Exception {
            // insert statement
            Connection con= db_connector.getConnection();
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(info);
            preparedStmt.setString (1, program_name);
            preparedStmt.setString (2, host_id);
            preparedStmt.setString (3, host_ip);
            preparedStmt.setString (4, cpu_id);
            preparedStmt.setString (5, memory_id);
            preparedStmt.setString (6, process_num);

            preparedStmt.execute();
            con.close();
        }

        public static Connection getConnection() throws Exception{
            try{
                Class.forName(driver);
                Connection conn = DriverManager.getConnection(url,username,password);
                System.out.println("Connected");
                return conn;
            } catch(Exception e){System.out.println(e);}
            System.out.println("Not Connected");

            return null;
        }

    }
