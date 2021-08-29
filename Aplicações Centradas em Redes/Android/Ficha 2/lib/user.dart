import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class User {
  int id;
  String name;
  String username;
  String email;

  User({this.id, this.name, this.username, this.email});


  Card toCard({Function update}) {
    return Card(
      child: ListTile(
        onTap: update,
        title: Text(
          "${this.name} (${this.email})",
          style: TextStyle(
            fontSize: 18,
            color: Colors.red[800],
            fontWeight: FontWeight.bold),
        ),
        leading: Icon(Icons.person),
      ),
    );
  }

  static Card getAllUsersCard({Function update}) {
    return Card(
      child: ListTile(
        onTap: update,
        title: Text("All users",
        style: TextStyle(
          fontSize: 18,
          color: Colors.red[800],
          fontWeight: FontWeight.bold),
        ),
        leading: Icon(Icons.person),
      ),
    );
  }
}