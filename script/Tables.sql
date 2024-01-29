CREATE TABLE Favori(
    idfavori SERIAL NOT NULL,
    idutilisateur INTEGER NOT NULL,
    idannonce INTEGER NOT NULL,
    PRIMARY KEY(idfavori),
    FOREIGN KEY(idutilisateur) REFERENCES utilisateur(idutilisateur),
    FOREIGN KEY(idannonce) REFERENCES annonce(idannonce)
);