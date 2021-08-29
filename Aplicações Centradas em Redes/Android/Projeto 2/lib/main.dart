import 'package:TheMovieDB/MovieInformations.dart';
import 'package:TheMovieDB/loading.dart';
import 'package:TheMovieDB/set_movie.dart';
import 'package:flutter/material.dart';
import 'package:TheMovieDB/globals.dart';

void main() {
  runApp(MaterialApp(
    initialRoute: '/',
    routes: {
      '/': (context) => Loading(),
      '/PopularMovies': (context) => SetMovie(),
      '/Informations': (context) => MovieInformations(),
      '/LoadInformations': (context) {
        Globals.nextRoute = '/Informations';
        return Loading();
      }
    },
  ));
}