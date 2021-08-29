import 'package:TheMovieDB/Information.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

class StatisticsContainer extends StatelessWidget {
  final Information informations;

  StatisticsContainer({this.informations});

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.all(4),
      color: Colors.lightBlueAccent[600],
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: <Widget>[
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(
              this.informations.originalTitle,
              style: TextStyle(
                fontSize: 22,
                fontWeight: FontWeight.bold,
                color: Colors.blueAccent[900],
              ),
            ),
          ),
          SizedBox(
            height: 5,
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: new InkWell(
              child: new Text('Open in Browser', style: TextStyle(decoration: TextDecoration.underline, color: Colors.blue)),
              onTap: () => launch(this.informations.homepage),
            )
          ),
          SizedBox(
            height: 20,
          ),
          Padding(
              padding: const EdgeInsets.all(8.0),
              child: Text("OverView: ${this.informations.overview}",
                  style: TextStyle(fontSize: 18, color: Colors.black))),
          SizedBox(
            height: 5,
          ),
          Padding(
              padding: const EdgeInsets.all(8.0),
              child: Text("Release Date: ${this.informations.releaseDate} (${this.informations.status})",
                  style: TextStyle(fontSize: 18, color: Colors.black))),
          SizedBox(
            height: 5,
          ),
        ],
      ),
    );
  }
}
