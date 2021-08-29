import 'Movieservice.dart';

class Globals {
  static MovieService service = MovieService();
  static String apiUrl = 'https://api.themoviedb.org/3/movie';
  static String tokenVar = '?api_key=';

  static String nextRoute = "/PopularMovies";
}
