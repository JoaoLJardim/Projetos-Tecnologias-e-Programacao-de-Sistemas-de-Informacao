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
    <form action="exec_reg.php" method="post">
        <label for="username">UserName</label>
        <input id="username" name="username" required><br>
        <label for="nome">Nome</label>
        <input id="nome" name="nome" required><br>
        <label for="morada">Morada</label>
        <input id="morada" name="morada" required><br>
        <label for="email">Email</label>
        <input id="email" name="email" required>
        <input type="submit">
    </form>
</body>
</html>