type Artist = {
    id: number,
    name: string
}

function getArtists(): Promise<Artist[]> {
    return fetch('http://localhost:8081/artists')
        .then(res => res.json())
        .then(res => {
            return res as Artist[]
        })
}

const divArtists = document.getElementById('artists');
getArtists().then(artists => {
    divArtists.innerHTML = artists.map(a => a.name).toString;
})

