import 'dart:convert';

import 'package:TheMovieDB/Movie.dart';
import 'package:TheMovieDB/Information.dart';
import 'package:TheMovieDB/globals.dart';
import 'package:http/http.dart';

class MovieService {
  List<Movie> movies = List<Movie>();
  Information information;
  Movie movieAtual;

  Future<void> getMovies() async {
    String route =
        Globals.apiUrl + "/popular" + Globals.tokenVar;

    Response response = await get(route);

    Map rawData = jsonDecode(response.body);

    List<dynamic> data = rawData['results'];
    movies.clear();

    for (int i = 0; i < data.length; i++) {
      Map movieData = data[i];
      Movie movie = Movie(
          originalTitle: movieData['original_title'],
          id: movieData['id'],
          posterPath: movieData['backdrop_path']);
      movies.add(movie);
    }
  }

  Future<void> getInformation() async {
    if (this.movieAtual == null) return;

    String route =
        Globals.apiUrl + "/" + this.movieAtual.id.toString() + Globals.tokenVar;

    Response response = await get(route);

    Map rawData = jsonDecode(response.body);

    this.information = Information(
        homepage: rawData['homepage'],
        originalTitle: rawData['original_title'],
        overview: rawData['overview'],
        releaseDate: rawData['release_date'],
        status: rawData['status']);
  }
}
