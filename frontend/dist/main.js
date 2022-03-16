"use strict";
function getArtists() {
    return fetch('http://localhost:8081/artists')
        .then(res => res.json())
        .then(res => {
        return res;
    });
}
const divArtists = document.getElementById('artists');
getArtists().then(artists => {
    divArtists.innerHTML = artists.map(a => a.name).toString;
});
