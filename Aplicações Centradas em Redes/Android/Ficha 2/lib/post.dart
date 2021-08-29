import 'package:flutter/material.dart';

class Post {
  int id;
  int userId;
  String title;
  String body;

  Post({this.id, this.userId, this.title, this.body});


  Card toCard() {
    return Card(
      margin: EdgeInsets.symmetric(horizontal: 10, vertical: 20),
      child: Padding(
        padding: const EdgeInsets.all(10.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
          Text(this.title,
            style: TextStyle(
              fontSize: 18,
              color: Colors.red[800],
            ),
          ),
          SizedBox(height: 4),
          Text(this.body,
            style: TextStyle (
              fontSize: 14,
              color: Colors.black,
            ),
          )
        ],),
      ),
    );
  }
}