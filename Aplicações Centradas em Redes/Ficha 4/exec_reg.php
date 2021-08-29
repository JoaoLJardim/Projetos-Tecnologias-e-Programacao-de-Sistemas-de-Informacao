<?php 
    include("connection.php");
    if (!empty($_GET)) {
         $username =  $_GET['username'];
         $name =  $_GET['nome'];
         $address =  $_GET['morada'];
         $email =  $_GET['email'];

         $sql = "CALL create_new_user('$username', '$name', '$address', '$email');";
         $result = mysqli_query($conn, $sql);
         
         if ($result == 1) {
           header( "Location: http://localhost/exerc%C3%ADcio3Get/index.php?created=true" );
           exit;
         }
         
    }
?>