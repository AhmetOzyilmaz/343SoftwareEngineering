<?php
//Connect To Database
$hostname='localhost';
$username='root';
$password='';
$dbname='programs';
$usertable='prog';

$con = mysqli_connect($hostname,$username, $password) OR DIE ('Unable to connect to database! Please try again later.');
mysqli_select_db($con,$dbname);

$query = 'SELECT * FROM ' . $usertable;
$result = mysqli_query($con,$query);
if($result) {
    while($row = mysqli_fetch_array($result)){
         $name = $row["computerID"];
         $name1= $row["computerName"];
         $name2 = $row["programName"];
        
         echo 'Name: ' . $name ."<br>";
         echo 'Name: ' . $name1 ."<br>";
        echo 'Name: ' . $name2 ."<br>";
        //echo json_encode($row);
        
    }
}
else {
print "Database NOT Found ";
mysql_close($db_handle);
}
?>