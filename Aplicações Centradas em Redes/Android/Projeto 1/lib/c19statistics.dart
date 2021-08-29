import 'package:covid19/StatisticsContainer.dart';
import 'package:covid19/globals.dart';
import 'package:flutter/material.dart';

class C19Statistics extends StatefulWidget {
  @override
  _C19StatisticsState createState() => _C19StatisticsState();
}

class _C19StatisticsState extends State<C19Statistics> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.amber[300],
      appBar: AppBar(
        title: Text("Estatisticas Covid19"),
        backgroundColor: Colors.lightBlueAccent[600],
      ),
      body: Column(
        children: <Widget>[
          Expanded(child: StatisticsContainer(statistics: Globals.service.statistics,))
        ],
      ),
    );
  }
}