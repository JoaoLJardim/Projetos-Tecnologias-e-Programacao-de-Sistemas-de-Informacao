import 'package:flutter/material.dart';
import 'package:flutter_app/blog_service.dart';
import 'post.dart';

class Blog extends StatefulWidget {
  @override
  _BlogState createState() => _BlogState();
}

class _BlogState extends State<Blog> {
  Map data = {};

  @override
  Widget build(BuildContext context) {
    if (data == null || data.isEmpty) {
      data = ModalRoute.of(context).settings.arguments;
    }
    BlogService bs = data["blogService"];

    return Scaffold(
      appBar: AppBar(
        title: Text("My Blog"),
        centerTitle: true,
        backgroundColor: Colors.blueGrey[850],
      ),
      body: Column(
        children: <Widget>[
          FlatButton.icon(
            onPressed: () async {
              dynamic result = await Navigator.pushNamed(context, "/SetUser",
                  arguments: {"blogService": bs});
              setState(() {
                data = result;
              });
            },
            icon: Icon(Icons.person),
            label: Text("Choose User"),
          ),
          Expanded(
              child: ListView.builder(
                  itemCount: bs.posts.length,
                  itemBuilder: (context, index) {
                    return bs.posts[index].toCard();
                  }))
        ],
      ),
    );
  }
}
