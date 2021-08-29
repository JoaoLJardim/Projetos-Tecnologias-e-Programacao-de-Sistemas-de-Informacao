<?php 
    $servername = "";
    $username = "";
    $password = "";
    $dbschema = "";
    // Create connection
    $conn = mysqli_connect($servername, $username, $password, $dbschema);

    // Check connection
    if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
   }
 
?>