<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    include("menu.php");
    ?>
    <form action="exec_reg.php" method="get">
        <label for="username">UserName</label><br>
        <input type="text" id="username" name="username" required><br>
        <label for="nome">Nome</label><br>
        <input type="text" id="nome" name="nome" required><br>
        <label for="morada">Morada</label><br>
        <input type="text" id="morada" name="morada" required><br>
        <label for="email">Email</label><br>
        <input type="text" id="email" name="email" required><br>
        <input type="submit">
    </form>

    <style>
        input[type=text],
        select {
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
        
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
</body>

</html>