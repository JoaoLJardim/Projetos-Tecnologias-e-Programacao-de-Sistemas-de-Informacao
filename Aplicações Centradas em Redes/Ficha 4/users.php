<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    include("connection.php");
    include("menu.php");
    $sql = "CALL get_all_users();";
    $result = mysqli_query($conn, $sql);
    if (mysqli_num_rows($result) > 0) {
        // output data of each row
        echo "<table><tr><th>UserName</th><th>Name</th><th>Address</th><th>Email</th></tr>";
        while ($row = mysqli_fetch_assoc($result)) {
            echo "<tr><td>" . $row['Username'] . "</td><td>" . $row['Name'] . "</td><td>" . $row['Address'] . "</td><td>" . $row['Email'] . "</td></tr>";
        }
    } else {
        echo "0 results";
    }
    ?>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            text-align: center;
        }

        table td,
        table th {
            border: 3px solid #ddd;
        }

    </style>
</body>

</html>