<div>
<form name="form" action="" method="post">
  <input type="text" name="subject" id="subject">
  <input type="text" name="subject1" id="subject">
  <button type="submit">Submit</button>
</form>
<br>
<?php 
    $str =  "";
    $str2 = "";
    if (!empty($_POST)) {
    $str =  $_POST['subject'];
    $str2 = $_POST['subject1'];
    echo "String 1: $str<br>";
    echo "String 2: $str2<br><br>";

    echo "Tamanho string 1: ".strlen($str)."<br>";
    echo "Tamanho string 2: ".strlen($str2);
}

?></div>