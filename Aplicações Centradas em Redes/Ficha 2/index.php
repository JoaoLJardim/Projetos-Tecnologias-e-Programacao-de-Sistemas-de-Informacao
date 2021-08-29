<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=<, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    $pages = [ "home", "vars", "strings", "arrays", "about"];
    $page = 0;
    if (!empty($_GET)) {
        $page = $_GET["p"];
    }
    $pageName = $pages[$page];

    function GenerateMenu() {
        global $pages;
        echo "<ul>";
        for ($i=0; $i < count($pages); $i++) { 
            echo "<li><a href=\"./?p=".$i."\">".$pages[$i]."</a></li>";
        };
        echo "</ul>";
    }
    GenerateMenu();
    include("$pageName.php")
    ?>
</body>
</html>