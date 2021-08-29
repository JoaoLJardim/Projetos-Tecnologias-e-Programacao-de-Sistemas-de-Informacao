import 'dart:convert';

import 'package:covid19/Country.dart';
import 'package:covid19/Statistics.dart';
import 'package:covid19/globals.dart';
import 'package:http/http.dart';

class C19Service {
  List<Country> paises = List<Country>();
  Statistics statistics;
  Country paisAtual;

  Future<void> getCountries() async {
    if (this.paises.isNotEmpty) return;

    String route = Globals.apiUrl + "/countries";
    Response response = await get(route, headers: Globals.apiHeaders);

    Map rawData = jsonDecode(response.body);
    List<dynamic> data = rawData['response'];

    paises.clear();

    for (int i = 0; i < data.length; i++) {
      Country pais = Country(name: data[i]);
      paises.add(pais);
    }
  }

  Future<void> getStatistics() async {
    if (this.paisAtual == null) return;

    String route = Globals.apiUrl + "/statistics?country=" +
        this.paisAtual.name;
    Response response = await get(route, headers: Globals.apiHeaders);

    Map rawData = jsonDecode(response.body);
    List<dynamic> data = rawData['response'];

    Map paisData = data[0];
    Map casesData = paisData['cases'];
    Map deathsData = paisData['deaths'];
    Map testsData = paisData['tests'];

    this.statistics = Statistics(
      continent: paisData['continent'],
      country: paisData['country'],
      population: paisData['population'],
      casesNew: casesData['new'],
      casesActive: casesData['active'],
      casesCritical: casesData['critical'],
      casesRecovered: casesData['recovered'],
      cases1MPop: casesData['1M_pop'],
      casesTotal: casesData['total'],
      deathsNews: deathsData['new'],
      deaths1MPop: deathsData['1M_pop'],
      deathsTotal: deathsData['total'],
      tests1MPop: testsData['1M_pop'],
      testsTotal: testsData['total'],
      day: paisData['day'],
      time: paisData['time'],
    );
  }
}