import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    title: "Fitness App",
    home: new Home(),
  ));
}

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  List<Container> lista = List();

  var array = [
    {
      "nombre": "espalda",
      "imagen": "espalda.jpg",
      "ejercicio": "LLevar mancuernas hacia atrás 4 series de 15 repeticiones."
    },
    {
      "nombre": "hombro",
      "imagen": "hombro.jpg",
      "ejercicio": "LLevar mancuernas hacia arriba 4 series de 15 repeticiones."
    },
    {
      "nombre": "mancuernas",
      "imagen": "mancuernas.jpg",
      "ejercicio": "Trabajo con mancuernas, 4 series de 15 repeticiones."
    },
    {
      "nombre": "pierna",
      "imagen": "pierna.jpg",
      "ejercicio": "Sentadillas, 4 series de 15 repeticiones."
    },
    {
      "nombre": "piernas",
      "imagen": "piernas.jpg",
      "ejercicio":
          "Levantamiento de piernas 4 series de 15 repeticiones, cada pierna."
    },
    {
      "nombre": "press",
      "imagen": "press.jpg",
      "ejercicio": "Press de banca, 4 series de 15 repeticiones."
    },
    {
      "nombre": "remo-mancuerna",
      "imagen": "remo-mancuerna.jpg",
      "ejercicio": "Hacer remo con las mancuernas 4 series de 10 repeticiones."
    },
    {
      "nombre": "saltos",
      "imagen": "saltos.jpg",
      "ejercicio": "Realizar saltos, 4 series de 20 repeticiones."
    },
  ];

  @override
  Widget build(BuildContext context) {
    return Container();
  }
}
