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
        $new_array[] = $row;     
    }    
}
else {
print "Database NOT Found ";
mysql_close($db_handle);

}
echo '<ul>';
foreach($new_array as $array){  
   // $sql = "SELECT * FROM persons WHERE first_name='john'";

  /* echo $array['ID'].'<br />';
   echo $array['prog_name'].'<br />';
   echo $array['pc_id'].'<br />';
   echo $array['pc_ip'].'<br />';*/


   $result1 = mysqli_query( $con,"SELECT * FROM $usertable WHERE pc_id= '". $array['pc_id'] ."'");
   
if($result1) {
    while($row1 = mysqli_fetch_array($result1)){      
        $new_array1[] = $row1;    
        //echo $row1['pc_ip'].'<br />';  
                     
    }
}       
echo'<li class="list-group-item ">
    <h4 id = "content" class="list-group-item-heading">'. $array['pc_ip'].'</h4>';
    foreach($new_array1 as $array1){  
        echo '<p class="list-group-item-text"> Host IP : '. $array1['prog_name'].' </p>';
    }
   
    echo'<span class="pull-right">
        <button id="toggle" class="btn btn-xs btn-info">Details</button>        
    </span>   </li>';
    
}
echo '</ul>';

?>
<html>
    <link rel="stylesheet" type="text/css" href="fram.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script>
    $(function() {
    $(".btn-info").on("click", function(e) {
        e.preventDefault(); // in some browsers a button submits if no type=

        $("#content").toggleClass("show");
        $(this).closest(".list-group-item").children(".list-group-item-text").show(500);
    });
    });   
    </script>
</html>



