import 'package:covid19/globals.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';

class Loading extends StatefulWidget {
  @override
  _LoadingState createState() => _LoadingState();
}

class _LoadingState extends State<Loading> {

  Future<void> setupService() async {
    await Globals.service.getCountries();
    await Globals.service.getStatistics();
    Navigator.pushReplacementNamed(context, Globals.nextRoute);
  }

  @override
  void initState() {
    super.initState();
    setupService();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.amber[300],
      body: Center(
        child: SpinKitCubeGrid(
          color: Colors.red,
          size: 50.0,
        ),
      ),
    );
  }
}
