import 'package:covid19/c19statistics.dart';
import 'package:covid19/loading.dart';
import 'package:covid19/set_country.dart';
import 'package:flutter/material.dart';
import 'package:covid19/globals.dart';

void main() {
  runApp(MaterialApp(
    initialRoute: '/',
    routes: {
      '/': (context) => Loading(),
      '/Countries': (context) => SetCountry(),
      '/Statistics': (context) => C19Statistics(),
      '/LoadStatistics': (context) {
        Globals.nextRoute = '/Statistics';
        return Loading();
      }
    },
  ));
}