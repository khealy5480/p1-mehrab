var welcomeMsg = 'Music App';
document.querySelector('h1').innerText = welcomeMsg;

fetch('http://localhost:8081/artists').then(resp => resp.json()).then(artists => {
        document.querySelector('#artists').innerHTML = listArtists(artists);
    }
);

function listArtists(json) {
    return `${json.map(listArtist).join('\n')}`;
};

let listArtist = function(artist) {
    return '<p>' + artist.artistId + ": " + artist.name + '</p>';
};

function postArtist() {
    let artist = {
        "artistId": document.getElementById("artistId").value,
        "name": document.getElementById("name").value
    }
    console.log(artist);
    fetch("http://localhost:8081/artists", {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(artist)
    }).then((result) => {
        if (result.status != 200) {
            throw new Error("Bad Server Response");
        }
        console.log(result.text());
    }).catch((error) => { console.log(error); })
    fetch('http://localhost:8081/artists').then(resp => resp.json()).then(artists => {
            document.querySelector('#artists').innerHTML = listArtists(artists);
        }
    );
}

let button = document.querySelector('button');
button.addEventListener('mouseenter', function() {
    button.textContent = "Go!";
})