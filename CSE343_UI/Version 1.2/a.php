<?php
//Connect To Database
$hostname='94.73.145.118';
$username='userD09F7E';
$password='WPsc05M5';
$dbname='dbD09F7E';
$usertable='monitor';

$con = mysqli_connect($hostname,$username, $password) OR DIE ('Unable to connect to database! Please try again later.');
mysqli_select_db($con,$dbname);

$query = 'SELECT * FROM ' . $usertable;
$result = mysqli_query($con,$query);
if($result) {
    while($row = mysqli_fetch_array($result)){
         $name = $row["ID"];
         $name1= $row["prog_name"];
         $name2 = $row["pc_id"];
         $name3 = $row["pc_ip"];
         
         echo 'ID: ' . $name . '   ' .'prog_name: ' . $name1 . '   '.'pc_id: '  . $name2 . '   ' .'pc_ip: '. $name3."<br>";

        //echo json_encode($row);
        
    }
}
else {
print "Database NOT Found ";
mysql_close($db_handle);

}
?>