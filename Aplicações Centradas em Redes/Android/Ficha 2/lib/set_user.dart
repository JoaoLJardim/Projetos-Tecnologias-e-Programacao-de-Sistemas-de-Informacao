import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_app/blog_service.dart';
import 'package:flutter_app/user.dart';

class SetUser extends StatefulWidget {
  @override
  _SetUserState createState() => _SetUserState();
}

class _SetUserState extends State<SetUser> {
  Map data = {};

  Future<void> updateUserId(BlogService bs, int id) async {
    await bs.updatePosts(id);
    Navigator.pop(context,{"blogService": bs});
  }

  @override
  Widget build(BuildContext context) {
    data = ModalRoute.of(context).settings.arguments;
    BlogService bs = data['blogService'];

    return Scaffold(
        appBar: AppBar(
          title: Text("Select User"),
          centerTitle: true,
          backgroundColor: Colors.blueGrey[850],
        ),
        body: Column(children: <Widget>[
          Expanded(
              child: ListView.builder(
                  itemCount: bs.users.length + 1,
                  itemBuilder: (context , index) {
                    if (index == 0) {
                      return User.getAllUsersCard(update: () {
                        this.updateUserId(bs, 0);
                      });
                    } else {
                      User user = bs.users[index -1];
                      return user.toCard(update: () {
                        this.updateUserId(bs, user.id);
                      });
                    }
                    return bs.users[index].toCard();
                  }))
        ]));
  }
}
