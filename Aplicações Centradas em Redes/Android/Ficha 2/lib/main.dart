import 'package:flutter/material.dart';
import 'blog.dart';
import 'set_user.dart';
import 'loading.dart';

void main() {
  runApp(MaterialApp(initialRoute: '/', routes: {
    '/': (context) => Loading(),
    '/Blog': (context) => Blog(),
    '/SetUser': (context) => SetUser(),
  }));
}