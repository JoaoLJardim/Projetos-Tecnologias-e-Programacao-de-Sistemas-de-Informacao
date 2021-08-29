import 'package:covid19/Country.dart';
import 'package:covid19/country_card.dart';
import 'package:covid19/globals.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SetCountry extends StatefulWidget {
  @override
  _SetCountryState createState() => _SetCountryState();
}

class _SetCountryState extends State<SetCountry> {
  Future<void> showStats(Country pais) async {
    Globals.service.paisAtual = pais;
    await Globals.service.getStatistics();

    Navigator.pushNamed(context, '/LoadStatistics');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.amber[300],
      appBar: AppBar(
        title: Text("Escolha o País"),
        backgroundColor: Colors.lightBlueAccent[600],
      ),
      body: Column(
        children: <Widget>[
          Expanded(
            child: ListView.builder(
              itemCount: Globals.service.paises.length,
              itemBuilder: (context, index) =>
                  CountryCard(
                    pais: Globals.service.paises[index],
                    showStats: () {
                      this.showStats(Globals.service.paises[index]);
                    },
                  ),
            ),)
        ],
      ),
    );
  }
}
