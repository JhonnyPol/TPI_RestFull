var APP = {
    setCookie: function (cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
        var expires = "expires=" + d.toUTCString();
        document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
    },
    getCookie: function (cname) {
        var name = cname + "=";
        var decodedCookie = decodeURIComponent(document.cookie);
        var ca = decodedCookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) === ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) === 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    },
    getUtente: function ()
    {
        var username = $("#username").val();
        var password = $("#password").val();
        var url = "http://localhost:8080/utenti?username=" + username + "&password=" + password;
        if (username === "") {
            window.alert("il campo USERNAME non può essere vuoto!");
        } else if (password === "") {
            window.alert("il campo PASSWORD non può essere vuoto!");
        } else {
            $.ajax(
                    {
                        url: url,
                        method: "GET",
                        success: function (utente) {
                        },
                        statusCode: {
                            200: function (utente) {
                                APP.setCookie("idUtente", utente.id);
                                location.assign("posts_Utente.html");
                            }
                        }
                    }
            );
        }
    },
    getAmministratore: function ()
    {
        var username = $("#username").val();
        var password = $("#password").val();
        var url = "http://localhost:8080/amministratori?username=" + username + "&password=" + password;
        if (username === "") {
            window.alert("il campo USERNAME non può essere vuoto!");
        } else if (password === "") {
            window.alert("il campo PASSWORD non può essere vuoto!");
        } else {
            $.ajax(
                    {
                        url: url,
                        method: "GET",
                        success: function (data, status) {
                        },
                        statusCode: {
                            200: function (amministratore) {
                                APP.setCookie("idAmministratore", amministratore.id);
                                location.assign("inserimento_Post.html");
                            }
                        }
                    }
            );
        }
    },
    insertUtente: function ()
    {
        var cognome = $("#cognome").val();
        var nome = $("#nome").val();
        var username = $("#username").val();
        var password = $("#password").val();
        if (cognome === "") {
            window.alert("il campo COGNOME non può essere vuoto!");
        } else if (nome === "") {
            window.alert("il campo NOME non può essere vuoto!");
        } else if (username === "") {
            window.alert("il campo USERNAME non può essere vuoto!");
        } else if (password === "") {
            window.alert("il campo PASSWORD non può essere vuoto!");
        } else {
            $.ajax(
                    {
                        url: "http://localhost:8080/utenti",
                        method: "POST",
                        contentType: "application/json",
                        data: JSON.stringify(
                                {
                                    cognome: cognome,
                                    nome: nome,
                                    username: username,
                                    password: password

                                }
                        ),
                        success: function (utente, status) {
                        },
                        statusCode: {
                            200: function (utente) {
                                APP.setCookie("idUtente", utente.id);
                                location.assign("login_Utente.html");
                            }
                        }
                    }
            );
        }
        ;
    },
    
    insertPost: function ()
    {
        var titolo = $("#titolo").val();
        var testo = $("#testo").val();
        var idAmministratore = APP.getCookie("idAmministratore");
        var date = new Date();
        var month = '' + (date.getMonth() + 1);
        var day = '' + date.getDate();
        var year = date.getFullYear();
        if (month.length < 2)
            month = '0' + month;
        if (day.length < 2)
            day = '0' + day;
        var formatted_date = year + "-" + month + "-" + day;
        var post = JSON.stringify(
                {
                    amministratore: {id: idAmministratore},
                    dataPost: formatted_date,
                    titolo: titolo,
                    testo: testo
                });
        $.ajax(
                {
                    url: "http://localhost:8080/posts",
                    method: "POST",
                    contentType: "application/json",
                    data: post,
                    success: function (data, status) {
                    },
                    statusCode: {
                        200: function () {
                            window.alert("Post inserito");
                        }
                    }
                }
        );
    },
    getPosts: function ()
    {
        $.ajax(
                {
                    url: "http://localhost:8080/posts",
                    method: "GET",
                    success: function (data, status) {
                        APP.showPosts(data);
                    }
                }
        );
    },
    showPosts: function (posts)
    {

        var tabellaPosts = '<tr>'
                + '<th>ID</th>'
                + '<th>Data</th>'
                + '<th>Titolo</th>'
                + '<th>Testo</th>'
                + '<th>ID_Amministratore</th>'
                + '<th>Commenti</th>'
                + '<th></th>'
                + '</tr>';
        for (i = 0; i < posts.length; i++) {
            var id = posts[i].id;
            var dataPost = posts[i].dataPost;
            var titolo = posts[i].titolo;
            var testo = posts[i].testo;
            var idAmministratore = posts[i].amministratore.id;
            tabellaPosts += '<tr>'
                    + '<td>' + id + '</td>'
                    + '<td>' + dataPost + '</td>'
                    + '<td>' + titolo + '</td>'
                    + '<td>' + testo + '</td>'
                    + '<td>' + idAmministratore + '</td>'
                    + '<td>' + '<input class="buttonCommenti" type="submit" id="' + id + '" value="View">' + '</td>'
                    + '<td>' + '<input class="buttonCommenti" type="submit" id="' + id + '" value="Add">' + '</td>' 
                    /*Il tasto Add dovrebbe portare a inserimento_Commento.html ma non so come fargli prendere il cookie del post che commenta per prendere l'idPost*/
                    + '</tr>';
        }
        document.getElementById("posts").innerHTML = tabellaPosts;
    },
   
    insertCommento: function ()
    {
        var testo = $("#testo").val();
        var idPost = APP.getCookie("idPost");
        var idUtente = APP.getCookie("idUtente");

        var commento = JSON.stringify(
                {
                    post: {id: idPost},
                    utente: {id: idUtente},
                    testo: testo
                });
        $.ajax(
                {
                    url: "http://localhost:8080/commenti",
                    method: "POST",
                    contentType: "application/json",
                    data: commento,
                    success: function (data, status) {
                    },
                    statusCode: {
                        200: function () {
                            window.alert("Commento inserito");
                        }
                    }
                }
        );
    },

    getCommenti: function ()
    {
        var url = "http://localhost:8080/commenti";
        $.ajax(
                {
                    url: url,
                    method: "GET",
                    success: function (data, status) {
                        APP.showCommenti(data);
                    }
                }
        );
    },
    showCommenti: function (commenti)
    {
        var tabellaCommenti = '<tr>'
                + '<th>ID</th>'
                + '<th>Testo</th>'
                + '<th>ID_Utente</th>'
                + '<th>ID_Post</th>'
                + '</tr>';
        for (i = 0; i < commenti.length; i++) {
            var id = commenti[i].id;
            var testo = commenti[i].testo;
            var idUtente = commenti[i].utente.id;
            var idPost = commenti[i].post.id;
            tabellaCommenti += '<tr>'
                    + '<td>' + id + '</td>'
                    + '<td>' + testo + '</td>'
                    + '<td>' + idUtente + '</td>'
                    + '<td>' + idPost + '</td>'
                    + '</tr>';
        }
        document.getElementById("commenti").innerHTML = tabellaCommenti;
    }



};

