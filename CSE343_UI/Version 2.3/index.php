<?php
$hostname='94.73.145.118';
$username='userD09F7E';
$password='WPsc05M5';
$dbname='dbD09F7E';
$usertable='monitor';

$con = mysqli_connect($hostname,$username, $password) OR DIE ('Unable to connect to database! Please try again later.');
mysqli_select_db($con,$dbname);

$query = 'SELECT DISTINCT prog_name FROM ' . $usertable;
$result = mysqli_query($con, $query);
if($result) {
    while($row = mysqli_fetch_array($result)){      
        $resultPNArray[] = $row;     
    }    
}
else {
    print "Database NOT Found ";
    mysql_close($db_handle);
}

$query = 'SELECT DISTINCT pc_ip FROM ' . $usertable; //
$result2 = mysqli_query($con, $query);
if($result2) {
    while($row = mysqli_fetch_array($result2)){      
        $resultPDArray[] = $row;    
    }    
}
else {
    print "Database NOT Found ";
    mysql_close($db_handle);
}

?>

<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="./m.js"></script>
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>
        <div id="header">
            <img src="./img/logo.png" />
        </div>
        <div id="content">
            <div id="title-container">
                <header>DevOps Monitoring System</header>
            </div>
            <div id="link-container">
                <i class="fa fa-home"></i>
                <a href="#"><i class="fa fa-desktop" id="list-program"></i></a>
                
                <i class="fa fa-envelope"></i>
                <a href="data\main.pdf"><i class="fa fa-question"> </i></a>      
            </div>
            <div id="file-content-container">
                <div>
                    <div id="panel-container">
                        <div id="panel1">
                        <ul>
                            <?php foreach($resultPNArray as $array){  
                                $resultPN = mysqli_query( $con,"SELECT * FROM $usertable WHERE prog_name= '". $array['prog_name'] ."'");
                                
                             if($resultPN) {
                                 $resultPNArray2 = array();
                                 while($row1 = mysqli_fetch_array($resultPN)){      
                                     array_push($resultPNArray2, $row1);                                                      
                                 }
                             }?>
                               
                                <li class="list-group-item ">
                                    <div style="overflow: hidden;">
                                        <div style="float: left; width: calc(100% - 60px);">
                                            <h4 class="list-group-item-heading"><?php echo $array['prog_name']; ?></h4>
                                        </div>
                                        <div style="float: left; width: 60px;">
                                            <button id="toggle" class="btn btn-xs btn-info" data-pcid="<?php echo $array['prog_name']; ?>">Details</button>
                                        </div>
                                    </div>
                                    
                                    <div class="prog-container" data-pcid="<?php echo $array['prog_name']; ?>">
                                        <?php foreach($resultPNArray2 as $array1){  ?>
                                            <p class="list-group-item-text"> Host IP : <?php echo $array1['pc_ip']; ?> 
                                                <a href="http://localhost/zabbix/graphs.php?form=update&graphid=<?php echo $array1['cpu_id'];?>&hostid=<?php echo $array1['pc_id'];?>" ><button id="first"  class=""  > CPU USAGE</button> </a>                                                
                                                <a href="http://localhost/zabbix/graphs.php?form=update&graphid=<?php echo $array1['memory_id'];?>&hostid=<?php echo $array1['pc_id'];?>" ><button id="second"  class=""  > MEMORY USAGE</button> </a>                                                
                                                <a href="http://localhost/zabbix/graphs.php?form=update&graphid=<?php echo $array1['process_num'];?>&hostid=<?php echo $array1['pc_id'];?>" ><button id="third"  class=""  > NO OF PROCESSES</button> </a>                                                
                                            </p>
                                        <?php } ?>
                                    </div>
                                </li>
                            <?php } ?>
                                    </ul>
                        </div>
                        <div id="panel2">
                            <ul>
                            <?php foreach($resultPDArray as $array){  
                                $resultPD = mysqli_query( $con,"SELECT * FROM $usertable WHERE pc_ip= '". $array['pc_ip'] ."'");
                                
                             if($resultPD) {
                                 $resultPDArray2 = array();
                                 while($row1 = mysqli_fetch_array($resultPD)){      
                                     array_push($resultPDArray2, $row1);                                                      
                                 }
                             }?>
                               
                                <li class="list-group-item ">
                                    <div style="overflow: hidden;">
                                        <div style="float: left; width: calc(100% - 60px);">
                                            <h4 class="list-group-item-heading"><?php echo $array['pc_ip']; ?>
                                            <?php 
                                                 $resultPD_row = mysqli_query( $con,"SELECT pc_id FROM $usertable WHERE pc_ip= '". $array['pc_ip'] ."'");
                                                 if($resultPD_row) {
                                                    $resultPD_rowArr = array();
                                                    if($row2 = mysqli_fetch_array($resultPD_row)){
                                                    }                                               
                                                }
                                            ?>
                                            
                                                <a href="http://localhost/zabbix/graphs.php?groupid=0&hostid=<?php echo  $row2["pc_id"];?>"><button id="four"  class=""  > GRAPHS PAGE </button></a>
                                            </h4>
                                        </div>
                                        <div style="float: left; width: 60px;">
                                            <button id="toggle" class="btn btn-xs btn-info" data-pcid="<?php echo $array['pc_ip']; ?>">Details</button>
                                        </div>
                                    </div>
                                    <div class="prog-container" data-pcid="<?php echo $array['pc_ip']; ?>">
                                        <?php foreach($resultPDArray2 as $array1){  ?>
                                        
                                            <p class="list-group-item-text"> Program Name : <?php echo $array1['prog_name']; ?> 
                                            </p>
                                        <?php } ?>
                                    </div>
                                </li>
                            <?php } ?>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- <div id="footer">DevOps Monitoring (GTU CSE343 Term Project). All rights reserved.</div> -->
    </body>
</html>
