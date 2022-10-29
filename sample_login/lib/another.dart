import 'package:flutter/material.dart';
import 'package:sample_login/login.dart';
import 'package:sample_login/option.dart';

class Main extends StatefulWidget {
  const Main({Key? key}) : super(key: key);

  @override
  State<Main> createState() => _MainState();
}

class _MainState extends State<Main> {
  Option? answer = Option.no;
  Answer? newAns = Answer.no;
  @override
  Widget build(BuildContext context) {
    var color2 = const Color(0xFF092390);
    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: false,
        backgroundColor: color2,
        title: const Center(child: Text('Forpin Survey')),
        elevation: 0,
        actions: [
          PopupMenuButton<MenuItem>(
            icon: const Icon(Icons.more_vert),
            onSelected: (value) {
              if(value == MenuItem.may) {
                Navigator.push(context, MaterialPageRoute(builder: (context) => const Login()));
              }
            },
            itemBuilder: (context) => [
            const PopupMenuItem(
              value: MenuItem.may,
                child: Text('Log out'),
            ),
          ],
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              children: const [
                Text('1. '),
                SizedBox(
                  width: 20,
                ),
                Text('Name of your outlet'),
              ],
            ),
            SizedBox(
              height: MediaQuery.of(context).size.height * 0.01,
            ),
            SizedBox(
              width: MediaQuery.of(context).size.width,
              height: 50,
              child: TextFormField(
                obscureText: true,
                decoration: InputDecoration(
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(05),
                  ),
                ),
              ),
            ),
            SizedBox(
              height: MediaQuery.of(context).size.height * 0.02,
            ),
            Row(
              children: const [
                Text('2. '),
                SizedBox(
                  width: 20,
                ),
                Text('Do you like Peak milk products?'),
              ],
            ),
            ListTile(
              title: const Text('Yes'),
              leading: Radio<Option>(
                groupValue: answer,
                value: Option.yes,
                onChanged: (Option? value) {
                  setState(() {
                    answer = value;
                  });
                },
              ),
            ),
            ListTile(
              title: const Text('No'),
              leading: Radio<Option>(
                groupValue: answer,
                value: Option.no,
                onChanged: (Option? value) {
                  setState(() {
                    answer = value;
                  });
                },
              ),
            ),
            SizedBox(
              height: MediaQuery.of(context).size.height * 0.01,
            ),
            Row(
              children: const [
                Text('3. '),
                SizedBox(
                  width: 20,
                ),
                Text('How many products can you sell in a day?'),
              ],
            ),
            ListTile(
              title: const Text('1'),
              leading: Radio<Answer>(
                groupValue: newAns,
                value: Answer.yes,
                onChanged: (Answer? value) {
                  setState(() {
                    newAns = value;
                  });
                },
              ),
            ),
            ListTile(
              title: const Text('2'),
              leading: Radio<Answer>(
                groupValue: newAns,
                value: Answer.no,
                onChanged: (Answer? value) {
                  setState(() {
                    newAns = value;
                  });
                },
              ),
            ),
            Row(
              children: const [
                Text('4. '),
                SizedBox(
                  width: 20,
                ),
                Text('What is your favourite product name'),
              ],
            ),
            SizedBox(
              height: MediaQuery.of(context).size.height * 0.01,
            ),
            SizedBox(
              width: MediaQuery.of(context).size.width,
              height: 50,
              child: TextFormField(
                obscureText: true,
                decoration: InputDecoration(
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(05),
                  ),
                ),
              ),
            ),
            SizedBox(
              height: MediaQuery.of(context).size.height * 0.02,
            ),
            SizedBox(
              width: MediaQuery.of(context).size.width,
              height: MediaQuery.of(context).size.height * 0.06,
              child: MaterialButton(
                onPressed: () {
                  Navigator.push(context,
                      MaterialPageRoute(builder: (context) => const Main()));
                },
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
                color: color2,
                child: const Text(
                  'Submit',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 18,
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
