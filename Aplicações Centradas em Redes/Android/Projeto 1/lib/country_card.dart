import 'package:covid19/Country.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class CountryCard extends StatelessWidget {
  final Country pais;
  final Function showStats;

  CountryCard({this.pais,this.showStats});

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: EdgeInsets.all(4),
      color: Colors.lightBlueAccent[600],
      child: ListTile(
        title: Text(this.pais.name),
        leading: Icon(Icons.flag),
        onTap: showStats,
      ),
    );
  }
}