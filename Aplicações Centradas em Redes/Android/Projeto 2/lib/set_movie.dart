import 'package:TheMovieDB/Movie.dart';
import 'package:TheMovieDB/movie_card.dart';
import 'package:TheMovieDB/globals.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SetMovie extends StatefulWidget {
  @override
  _SetMovieState createState() => _SetMovieState();
}

class _SetMovieState extends State<SetMovie> {
  Future<void> showStats(Movie movie) async {
    Globals.service.movieAtual = movie;
    await Globals.service.getInformation();

    Navigator.pushNamed(context, '/LoadInformations');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.amber[300],
      appBar: AppBar(
        title: Text("Selecione um Filme Popular"),
        backgroundColor: Colors.lightBlueAccent[600],
      ),
      body: Column(
        children: <Widget>[
          Expanded(
            child: ListView.builder(
              itemCount: Globals.service.movies.length,
              itemBuilder: (context, index) => MovieCard(
                movie: Globals.service.movies[index],
                showInfo: () {
                  this.showStats(Globals.service.movies[index]);
                },
              ),
            ),
          )
        ],
      ),
    );
  }
}
