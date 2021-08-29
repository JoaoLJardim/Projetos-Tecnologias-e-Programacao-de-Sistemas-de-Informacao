<?php 
    include("connection.php");
    if (!empty($_POST)) {
         $username =  $_POST['username'];
         $name =  $_POST['nome'];
         $address =  $_POST['morada'];
         $email =  $_POST['email'];

         $sql = "CALL create_new_user('$username', '$name', '$address', '$email');";
         $result = mysqli_query($conn, $sql);
         
         if ($result == 1) {
           header( "Location: http://localhost/exerc%C3%ADcio3Post/index.php?created=true" );
           exit ;

         }
         
    }
?>