CREATE TABLE "artist" (
    "artist_id" INT PRIMARY KEY NOT NULL,
    "name" VARCHAR
);

CREATE TABLE "album" (
    "album_id" INT NOT NULL,
    "title" VARCHAR NOT NULL,
    "artist_id" INT NOT NULL,
    CONSTRAINT "pk_album" PRIMARY KEY ("album_id"),
    CONSTRAINT "fk_album_artist_id" FOREIGN KEY ("artist_id") REFERENCES "artist" ("artist_id") ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX "ifk_albumartistid" ON "album" ("ArtistId");

INSERT INTO "artist" VALUES (1, 'AC/DC');
INSERT INTO "artist" VALUES (2, 'Aerosmith');