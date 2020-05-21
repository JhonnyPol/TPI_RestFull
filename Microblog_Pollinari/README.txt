Progetto Microblog - Jonathan Pollinari 5^ei

Database h2:
console raggiungibile con http://localhost:8080/h2  

Dove:  

JDBC URL: jdbc:h2:mem:microblogDb
Username: admin
Password: admin

Logica del progetto:

Amministratore - può inserire i post e vederne i commenti, ma non inserirli;
la registrazione degli amministratori non è prevista perchè gli amministratori devono 
già essere registrati.			

Utente registrato - una volta loggato può vedere tutti i post ed i relativi commenti potendo commentare a sua volta

Utente pubblico - può vedere i post ed i commenti e può registrarsi per poter aggiungere commenti