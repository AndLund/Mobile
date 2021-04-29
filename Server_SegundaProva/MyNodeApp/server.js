var express = require('express');
var app = express();
var fs = require("fs");

var bodyParser = require('body-parser')
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));

var comidas = [{
    "id": 1,
    "nomeComida": "Pizza",
    "descricao": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.",
    "criador": "A1",
    "restaurante": "restaurante1",
    "regiao": "lugar1",
    "avaliacao": 3.5
}, {
    "id": 2,
    "nomeComida": "Bolacha",
    "descricao": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.",
    "criador": "A1",
    "restaurante": "restaurante1",
    "regiao": "lugar1",
    "avaliacao": 4.0
}, {
    "id": 3,
    "nomeComida": "Feijoada",
    "descricao": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.",
    "criador": "A1",
    "restaurante": "restaurante1",
    "regiao": "lugar1",
    "avaliacao": 5.0
}, {
    "id": 4,
    "nomeComida": "Arroz",
    "descricao": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.",
    "criador": "A1",
    "restaurante": "restaurante1",
    "regiao": "lugar1",
    "avaliacao": 3.0
}, {
    "id": 5,
    "nomeComida": "Coxinha",
    "descricao": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit.",
    "criador": "A1",
    "restaurante": "restaurante1",
    "regiao": "lugar1",
    "avaliacao": 4.5
}]

// Pega lista de comidas converte para JSON e envia para o app
app.get('/comidas', function (req, res) {
    var count = req.query.count != undefined ? req.query.count : req.query.count = 100;
    if (req.query.nomeComida) {
        var nomeSpots = comidas.filter(function (comida) {
            return comida.nomeComida == req.query.nomeComida
        });
        res.end(JSON.stringify(nomeSpots.slice(0, count)));
    }

    res.end(JSON.stringify(comidas.slice(0, count)));
})

// Pega 1 ID
app.get('/comidas/:id', function (req, res) {
    for (var i = 0; i < comidas.length; i++) {
        if (comidas[i].id == req.params.id) {
            res.end(JSON.stringify(comidas[i]));
        }
    }
})

// Home Page
app.get('/', (req, res) => res.send('Home'))

// Configuralção do server 
var server = app.listen(8080, '127.0.0.1', function (req, res) {

    var host = server.address().address
    var port = server.address().port

    console.log(`Server rodando em http://${host}:${port}/`);
})

