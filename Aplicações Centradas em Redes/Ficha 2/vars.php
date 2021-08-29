<div>
    <form name="form" action="" method="post">
        <input type="text" name="subject" id="subject">
        <input type="text" name="subject1" id="subject">
        <button type="submit">Submit</button>
    </form>
    <br>
    <?php
    $num1 =  0;
    $num2 = 0;
    if (!empty($_POST)) {
        $num1 = $_POST["subject"];
        $num2 = $_POST["subject1"];

        echo "Numero 1: $num1<br>";
        echo "Numero 2: $num2<br>";
        echo "$num1 + $num2 = " . ($num1 + $num2);
    }
    ?>
</div>