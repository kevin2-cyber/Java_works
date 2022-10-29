import 'package:flutter/material.dart';

class CheckBockTest extends StatefulWidget {
  const CheckBockTest({Key? key}) : super(key: key);

  @override
  State<CheckBockTest> createState() => _CheckBockTestState();
}

class _CheckBockTestState extends State<CheckBockTest> {
  Map<String, bool> numbers = {
    "1": false,
    "2": false,
    "3": false,
    "4": false,
    "5": false,
  };

  var holder = [];
  getItems() {
    numbers.forEach((key, value) {
      if (value == true) {
        holder.add(key);
      }
    });
    holder.clear();
  }

  @override
  Widget build(BuildContext context) {
    Color getColor(Set<MaterialState> states) {
      const Set<MaterialState> interactiveStates = <MaterialState>{
        MaterialState.pressed,
        MaterialState.hovered,
        MaterialState.focused
      };
      if (states.any((element) => interactiveStates.contains(element))) {
        return Colors.blue;
      }
      return Colors.red;
    }

    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
          onPressed: () {
            Navigator.pop(context);
          },
          icon: const Icon(Icons.arrow_back_ios),
        ),
      ),
      // body: ListView(
      //   children: numbers.keys.map((String key) => CheckBoxListTile(
      //       title: Text(key),
      //       value: numbers[key],
      //       activeColor: Colors.red,
      //       checkColor: Colors.white,
      //       onchanged: (bool value) {
      //         setState(() {
      //           numbers[key] = value;
      //         });
      //       }
      //     ),
      //   ),
      // ),
    );
  }
}
