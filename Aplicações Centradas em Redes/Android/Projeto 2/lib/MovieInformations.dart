import 'package:TheMovieDB/StatisticsContainer.dart';
import 'package:TheMovieDB/globals.dart';
import 'package:flutter/material.dart';

class MovieInformations extends StatefulWidget {
  @override
  _MovieInformationsState createState() => _MovieInformationsState();
}

class _MovieInformationsState extends State<MovieInformations> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.amber[300],
      appBar: AppBar(
        title: Text(""),
        backgroundColor: Colors.lightBlueAccent[600],
      ),
      body: Column(
        children: <Widget>[
          Expanded(child: StatisticsContainer(informations: Globals.service.information,))
        ],
      ),
    );
  }
}