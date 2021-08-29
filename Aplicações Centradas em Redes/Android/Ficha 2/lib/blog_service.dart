import 'dart:convert';
import 'post.dart';
import 'user.dart';
import 'package:http/http.dart';

class BlogService {
  List<Post> posts = List<Post>();
  List<User> users = List<User>();
  int userId = 0;
  String _url = "http://jsonplaceholder.typicode.com";

  Future<void> updatePosts(int pUserId) async {
    this.userId = pUserId;
    await this.getPosts();
  }

  Future<void> getPosts() async {
    String route = this._url;
    if (this.userId == 0) {
      route += "/posts";
    } else {
      route+= "/users/${this.userId}/posts";
    }

    Response response = await get(route);
    List<dynamic> data = jsonDecode(response.body);

    this.posts.clear();

    for (int i = 0; i < data.length; i++) {
      Map postFromData = data[i];
      Post post = Post(
          id: postFromData["id"],
          userId: postFromData['userId'],
          title: postFromData['title'],
          body: postFromData['body'],
      );
      posts.add(post);
    }
  }

  Future<void> getUsers() async {
    Response response = await get("https://jsonplaceholder.typicode.com/users");
    List<dynamic> data = jsonDecode(response.body);

    for (int i = 0; i < data.length; i++) {
      Map postFromData = data[i];
      User user = User(
          id: postFromData["id"],
          name: postFromData['name'],
          username: postFromData['username'],
          email: postFromData['email'],
      );
      users.add(user);
    }
  }
}