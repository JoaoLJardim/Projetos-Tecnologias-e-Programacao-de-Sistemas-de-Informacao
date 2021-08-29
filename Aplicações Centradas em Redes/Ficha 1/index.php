<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

<?php
$age = 20;
$nome1 = "Joao Jardim";
$nome2 = "Carlos Serão";

echo "Idade: $age <br>";
echo "Tamanho do nome 1: ".strlen($nome1)."<br>";

echo "Nome 1 Igual ao nome 2: ".strcmp($nome1,$nome2)."<br>";
echo "Nome 1 Revertido: ". strrev($nome1);
echo "Nome 1 Trim: ". trim($nome1,"JoIm")."<br>";

function FimdeSemana() {
    $date = date("l");
    if ($date == "Saturday" || $date == "Sunday") {
        echo "”Boa!”<br>";
    } else {
        echo "Nunca Mais é fim de semana!<br>";
    }
}
FimdeSemana();

$array = [5,2,1,8];
sort($array);
for ($i=0; $i <count($array); $i++) { 
    echo $array[$i]."<br>";
};
?>


</body>

</html>