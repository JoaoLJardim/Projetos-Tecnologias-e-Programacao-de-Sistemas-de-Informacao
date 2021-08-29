import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(home: Home()));
}

class Home extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Hello world"),
        centerTitle: true,
        backgroundColor: Colors.blueGrey[400],
      ),
      body: Column(
        children: [
          Text("Hello World",
              style: TextStyle(
                  fontSize: 40,
                  fontWeight: FontWeight.bold,
                  letterSpacing: 2,
                  color: Colors.blueAccent[200],
                  fontFamily: 'Bangers')
          ),
          Image.network("https://ichef.bbci.co.uk/news/1024/cpsprodpb/10403/production/_114936566_coronavirus_index_wolrd_976.png"),
          Image.asset('assets/running.gif')
        ],
      ),
      floatingActionButton: FloatingActionButton(
        child: Text('Click Me'),
        backgroundColor: Colors.blueGrey[400],
      ),
    );
  }
}
