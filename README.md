# LibraryAndroid
App android - biblioetca de filme, series e livros. #kotlin #themovieAPI #firebase 

Não é possível ter acesso a aplicação sem o devido registo e, como visto, esse registo é 
feito todo através do Firebase (https://console.firebase.google.com/), sendo necessário 
então ter uma conta no referido recurso. A conexão através do IDE da android foi feito
através da aba:
“tools > firebase > Authentication > Authenticate using a custom authetication system”.
O login de teste utilizado foi: teste1@gmail.com passe: 123456
Para ter acesso aos filmes e aplicação ser corretamente alimentada pela API é necessário 
ter o registo na TMDB (https://www.themoviedb.org/documentation/api) e após 
receber a “API Key (v3 auth)” é necessário colocar na Interface chamada “API”, dentro 
da nossa aplicação, nas linhas 11 e 17, onde são feitos os pedidos referentes aos 
“endpoint” destinados.
