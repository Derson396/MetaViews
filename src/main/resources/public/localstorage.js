let dadosHTML = '';
let dadosHTML1 = '';
let dadosHTML2 = '';
const mostraRilmes = (data) => {
  let dadosFilmes = JSON.parse(data.target.response)
  localStorage.setItem('db_filmes', data.target.response)
  for (let i = 0; i < 4; i++) {
    let filme = localStorage.getItem('db_filmes').results[i];
    dadosHTML += `

            <div class="col-3 col-md-6 col-sm-12 col-lg-3"><div class="card-group" id="lista_recentes" style="padding-top:30px;" >
<div class="card" style="width: 18rem;">
<img src="https://image.tmdb.org/t/p/original/${filme.poster_path}" class="card-img-top"alt="">
<div class="card-body">
<h5 class="card-title">${filme.title}</h5>
<a href="Movie0.html?id=${filme.id}" class="btn btn-dark">Acesse</a>
</div>
</div>
</div>
</div>
 `
  }
  document.getElementById('divListaFilmes').innerHTML = dadosHTML
}
const mostraFilmes = (data) => {
  let dadosFilmes = JSON.parse(data.target.response)
  localStorage.setItem('dbb_filmes', data.target.response)
  for (let i = 0; i < 8; i++) {
    let midia = localStorage.getItem('dbb_filmes').results[i];
    dadosHTML1 += `<div class="col-3 col-md-6 col-sm-12 col-lg-3"><div class="card-group" id="lista_filmes" style="padding-top:30px; >
<div class="card" style="width: 18rem;">
<img src="https://image.tmdb.org/t/p/original/${midia.poster_path}" class="card-img-top"alt="">
<div class="card-body">
<h5 class="card-title">${midia.title}</h5>
<a href="Movie0.html?id=${midia.id}" class="btn btn-dark">Acesse</a>
</div>
</div>
</div>
</div>`;
  }
  document.getElementById('lista_filmes').innerHTML = dadosHTML1
}
const mostratilmes = (data) => {
  let dadosFilmes = JSON.parse(data.target.response)
  console.log(dadosFilmes);
  localStorage.setItem('dbbb_filmes', data.target.response)
  for (let i = 0; i < 20; i++) {
    let tilia = localStorage.getItem('dbbb_filmes').results[i];
    dadosHTML2 += `<div class="col-3 col-md-6 col-sm-12 col-lg-3"><div class="card-group" id="lista_filmes" style="padding-top:30px; >
<div class="card" style="width: 18rem;">
<img src="https://image.tmdb.org/t/p/original/${tilia.poster_path}" class="card-img-top"alt="">
<div class="card-body">
<h5 class="card-title">${tilia.title}</h5>
<a href="Movie0.html?id=${tilia.id}" class="btn btn-dark">Acesse</a>
</div>
</div>
</div>
</div>`;
  }
  document.getElementById('lista_filmes_destaque').innerHTML = dadosHTML2
}

function exibirRecentes() {
  let xhr = new XMLHttpRequest();
  let url = "https://api.themoviedb.org/3/movie/popular?api_key=16fbb8062ed98d2f19ed95f35348c8e9&language=pt-BR&"
  xhr.onload = mostraRilmes;
  xhr.open('GET', url, true);
  xhr.send();
}

function exibirFilmes() {
  let xhr = new XMLHttpRequest();
  let url = "https://api.themoviedb.org/3/movie/popular?api_key=16fbb8062ed98d2f19ed95f35348c8e9&language=pt-BR&page=" + parseInt(Math.random() * 20 + 1)
  xhr.onload = mostraFilmes;
  xhr.open('GET', url, true);
  xhr.send();
}

//HTML Filmes
function exibirFilmesDestaque() {
  let xhr = new XMLHttpRequest();
  let url = "https://api.themoviedb.org/3/movie/popular?api_key=16fbb8062ed98d2f19ed95f35348c8e9&language=pt-BR&page=" + parseInt(Math.random() * 20 + 1)
  xhr.onload = mostratilmes;
  xhr.open('GET', url, true);
  xhr.send();
}
//Carregar chaves
$(document).ready(function () {
  exibirRecentes();
  exibirFilmes();
  exibirFilmesDestaque();
});
