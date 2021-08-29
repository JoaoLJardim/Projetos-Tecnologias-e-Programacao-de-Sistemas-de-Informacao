import 'package:TheMovieDB/Movie.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class MovieCard extends StatelessWidget {
  final Movie movie;
  final Function showInfo;

  MovieCard({this.movie,this.showInfo});

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: EdgeInsets.all(4),
      color: Colors.lightBlueAccent[600],
      child: Column(
        children: [
          ListTile(
            title: Text(this.movie.originalTitle),
            leading: Icon(Icons.movie),
            onTap: showInfo,
          ),
          Image.network("https://image.tmdb.org/t/p/w500"+this.movie.posterPath)
        ],
      ),
    );
  }
}