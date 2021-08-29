import 'c19service.dart';

class Globals {
  static C19Service service = C19Service();
  static String apiUrl = 'https://covid-193.p.rapidapi.com';
  static Map<String,String> apiHeaders = {
    'x-rapidapi-key': '',
    'x-rapidapi-host': '',
    'useQueryString': 'true'
  };

  static String nextRoute = "/Countries";
}