var APP = {

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
                                sessionStorage.setItem("idUtente", utente.id);
                                location.assign("posts.html");
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
                                sessionStorage.setItem("idAmministratore", amministratore.id);
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
                                sessionStorage.setItem("idUtente", utente.id);
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
        var idAmministratore = sessionStorage.getItem("idAmministratore");
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
                    + '<td>' + '<button class="buttonView" id="' + id + '"> View </button>' + '</td>'
                    + '<td>' + '<button class="buttonAdd" id="add' + id + '"> Add </button>' + '</td>'
                    + '</tr>';
        }
        document.getElementById("posts").innerHTML = tabellaPosts;


        for (i = 0; i < posts.length; i++) {
            $("#" + posts[i].id).on("click", APP.getCommentibyPostId);
            $("#add" + posts[i].id).on("click", APP.showAddCommentoDiv);
        }


        APP.checkLogin();

    },

    showAddCommentoDiv: function (event)
    {
        var buttonId = event.target.id;
        var postId = buttonId.split("add")[1];
        var divCommenti = '<div id="addCommento' + postId + '">' +
                '<h1> Inserimento Commento </h1><br>' +
                '<label for="testo">Commento</label><br>' +
                '<input type="text" id="testo" name="testo" placeholder="Commento" required><br><br><br>' +
                '<button class="button" type="submit" id="inserisci' + postId + '">Inserisci</button><br><br><br><br>' +
                '</div>';
        document.getElementById("insertCommenti").innerHTML = divCommenti;
        $("#inserisci" + postId).on("click", APP.insertCommento);
    },

    insertCommento: function (event)
    {
        var buttonId = event.target.id;
        var idPost = buttonId.split("inserisci")[1];
        var testo = $("#testo").val();
        var idUtente = sessionStorage.getItem("idUtente");

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

    getCommentibyPostId: function (event)
    {
        var id = event.target.id;
        var url = "http://localhost:8080/commenti/posts/" + id;
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
    },

    showAddButton: function ()
    {
        var buttons = document.getElementsByClassName("buttonAdd");

        for (i = 0; i < buttons.length; i++) {
            buttons[i].style.display = "block";
        }
    },

    checkLogin: function ()
    {
        var idUtente = sessionStorage.getItem("idUtente");

        if (idUtente !== null) {
            APP.showAddButton();
        }

    }


};

