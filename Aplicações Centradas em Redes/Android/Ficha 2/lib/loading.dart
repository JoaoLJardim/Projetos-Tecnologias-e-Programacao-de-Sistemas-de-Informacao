import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_app/blog_service.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';

class Loading extends StatefulWidget {
  @override
  _LoadingState createState() => _LoadingState();
}

class _LoadingState extends State<Loading> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: SpinKitRipple(
          color: Colors.red,
          size: 200.0,
        ),
      ),
    );
  }

  void setupBlogService() async {
    BlogService bs = BlogService();
    await bs.getPosts();
    await bs.getUsers();

    Navigator.pushReplacementNamed(context, "/Blog",
        arguments: {"blogService": bs});
  }

  @override
  void initState() {
    super.initState();
    setupBlogService();
  }
}
