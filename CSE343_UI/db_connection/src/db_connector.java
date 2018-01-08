import java.sql.*;


    public class db_connector {
        public static void main(String[] args) {
            //String databaseURL = "https://databases.000webhost.com/id4079017_devopsproject";
            try{

                String query_table2 = "SELECT * FROM graph";

                //String info = "insert into monitor (ID , prog_name, pc_name)" + " values (?, ?, ?)";
                //String info_2 = "insert into graph (program_name,graph_id)" + " values (?, ?)";

                //insertTable_1(info, "127.10.1.22","10050","Github.exe");

                select_1();
            }
            catch(Exception e){
                System.out.println("lel");
            }

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
                String host_id = rs.getString("prog_name");
                String program_name = rs.getString("pc_name");
                // print the results
                System.out.format("%s, %s, %s\n",host_id,host_ip,program_name);
            }
            st.close();
            con.close();
        }
        public static void insertTable_1(String info,String host_ip,String host_id, String program_name) throws Exception {
            // insert statement
            Connection con= db_connector.getConnection();
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(info);
            preparedStmt.setString (1, host_ip);
            preparedStmt.setString (2, host_id);
            preparedStmt.setString (3, program_name);
            preparedStmt.execute();
            con.close();
        }


        public static Connection getConnection() throws Exception{
            try{
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://94.73.145.118/dbD09F7E";
                //String url = "jdbc:mysql://localhost/prog";
                String username = "userD09F7E";
                String password = "WPsc05M5";

                Class.forName(driver);

                Connection conn = DriverManager.getConnection(url,username,password);
                System.out.println("Connected");
                return conn;
            } catch(Exception e){System.out.println(e);}
            System.out.println("Not Connected");

            return null;
        }

    }
